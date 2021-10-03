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
import com.dao.SubjectDaoImp;
import com.dao.TeacherDaoImp;
import com.dto.Class1;
import com.dto.Subject;
import com.dto.Teacher;

/**
 * Servlet implementation class ListSubjects
 */
public class ListSubjects extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListSubjects() {
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
			TeacherDaoImp teacherDaoImp= new TeacherDaoImp();
			SubjectDaoImp subjectDaoImp= new SubjectDaoImp();
			
			if (request.getParameter("If-Modified-Since") == null && request.getParameter("addSubject")!=null && request.getParameter("addSubject").equals("addSubject") && request.getParameter("name")!=null)
			{				
				Class1 class1 = class1DoaImp.searchClass1ById(Integer.valueOf(request.getParameter("class1")));
				Teacher teacher= teacherDaoImp.searchTeacherById(Integer.valueOf(request.getParameter("teacher")));
				Subject obj = new Subject(request.getParameter("name"),request.getParameter("discription"),class1,teacher);	
				subjectDaoImp.addSubject(obj);
				
				
			}
			if (request.getParameter("If-Modified-Since") == null && request.getParameter("deleteSubject")!=null && request.getParameter("deleteSubject").equals("deleteSubject") && request.getParameter("SubjectId")!=null)
			{
				Integer SubjectId = Integer.parseInt(request.getParameter("SubjectId"));
				subjectDaoImp.deleteSubject(SubjectId);
				
			}
			
			
			List<Class1> class1list=class1DoaImp.listAllClasses();
			ArrayList<Subject> subjectlist=(ArrayList<Subject>) subjectDaoImp.listAllSubjects();		
			List<Teacher> teacherlist=teacherDaoImp.listAllTeachers();
			
			request.setAttribute("subjectlist", subjectlist);
			request.setAttribute("class1list", class1list);
			request.setAttribute("teacherlist", teacherlist);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("Subjects.jsp");
			
			
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
