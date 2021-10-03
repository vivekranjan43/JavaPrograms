package com.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.Class1DoaImp;
import com.dao.StudentDaoImp;
import com.dto.Class1;
import com.dto.Student;

/**
 * Servlet implementation class ListStudents
 */
public class ListStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListStudents() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String loggeduname= (String)session.getAttribute("uname");
		if(loggeduname!=null){
			Class1DoaImp class1DoaImp= new Class1DoaImp();
			StudentDaoImp studentDaoImp= new StudentDaoImp();
			System.out.println(request.getParameter("If-Modified-Since"));
			
			if (request.getParameter("If-Modified-Since") == null && request.getParameter("addStudent")!=null && request.getParameter("addStudent").equals("addStudent") && request.getParameter("fname")!=null)
			{
				
				Class1 class1 = class1DoaImp.searchClass1ById(Integer.valueOf(request.getParameter("class1")));
				
				Student NewStudent = new Student(request.getParameter("fname"),request.getParameter("lname"),class1);
				studentDaoImp.addStudent(NewStudent);
				
			}
			
			if (request.getParameter("If-Modified-Since") == null && request.getParameter("deleteStudent")!=null && request.getParameter("deleteStudent").equals("deleteStudent") && request.getParameter("stId")!=null)
			{
							
				int stId = Integer.parseInt(request.getParameter("stId"));
				studentDaoImp.deleteStudent(stId);
				
			}
			
			
			
			List<Class1> classlist=class1DoaImp.listAllClasses();
			List<Student> students=studentDaoImp.listAllStudents();
			
			request.setAttribute("classlist", classlist);
			request.setAttribute("studentlist", students);
			
			RequestDispatcher rd = request.getRequestDispatcher("Students.jsp");
	
			
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("login");
			request.setAttribute("loginstatus", "Logged out");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
