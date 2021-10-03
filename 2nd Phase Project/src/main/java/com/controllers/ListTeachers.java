package com.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.TeacherDaoImp;
import com.dto.Teacher;

/**
 * Servlet implementation class ListTeachers
 */
public class ListTeachers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListTeachers() {
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

			TeacherDaoImp teacherDaoImp= new TeacherDaoImp();
			
			if (request.getParameter("If-Modified-Since") == null && request.getParameter("addTeacher")!=null && request.getParameter("addTeacher").equals("addTeacher") && request.getParameter("name")!=null)
			{				
				Teacher obj = new Teacher(request.getParameter("name"),request.getParameter("discription"));	
				teacherDaoImp.addTeacher(obj);
				
			}
			if (request.getParameter("If-Modified-Since") == null && request.getParameter("deleteTeacher")!=null && request.getParameter("deleteTeacher").equals("deleteTeacher") && request.getParameter("TeacherId")!=null)
			{
				Integer TeacherId = Integer.parseInt(request.getParameter("TeacherId"));
				teacherDaoImp.deleteTeacher(TeacherId);
				
			}
			
			
			
			ArrayList<Teacher> teacherlist=(ArrayList<Teacher>) teacherDaoImp.listAllTeachers();
			
			request.setAttribute("teacherlist", teacherlist);
			
			RequestDispatcher rd = request.getRequestDispatcher("Teachers.jsp");
			
			
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
