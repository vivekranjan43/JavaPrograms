package com.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.Class1DoaImp;
import com.dao.StudentDaoImp;
import com.dao.SubjectDaoImp;
import com.dto.Class1;
import com.dto.Student;
import com.dto.Subject;

/**
 * Servlet implementation class Dashboard
 */
public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Dashboard() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String loggeduname = (String) session.getAttribute("uname");
		if (loggeduname != null) {

			Class1DoaImp class1DoaImp = new Class1DoaImp();
			SubjectDaoImp subjectDaoImp = new SubjectDaoImp();
			StudentDaoImp studentDaoImp = new StudentDaoImp();

			Integer classId = 0;

			if (request.getParameter("If-Modified-Since") == null && request.getParameter("searchByClass") != null
					&& request.getParameter("searchByClass").equals("searchByClass")
					&& request.getParameter("classId") != null) {
				System.out.println(request.getParameter("classId"));
				classId = Integer.parseInt(request.getParameter("classId"));			

			}

			List<Class1> class1list = class1DoaImp.listAllClasses();
			ArrayList<Subject> subjectlist = (ArrayList<Subject>) subjectDaoImp.searchSubjectsByClassId(classId);
			List<Student> studentlist = studentDaoImp.searchStudentsByClassId(classId);

			request.setAttribute("subjectlist", subjectlist);
			request.setAttribute("class1list", class1list);
			request.setAttribute("studentlist", studentlist);

			RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");

			rd.forward(request, response);

		} else {
			RequestDispatcher rd = request.getRequestDispatcher("login");
			request.setAttribute("loginstatus", "Logged out");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
