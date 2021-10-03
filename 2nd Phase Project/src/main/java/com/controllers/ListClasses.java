package com.controllers;

import java.io.IOException;
import java.util.ArrayList;
//import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.Class1DoaImp;
import com.dto.Class1;

/**
 * Servlet implementation class ListClasses
 */
public class ListClasses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListClasses() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		String loggeduname= (String)session.getAttribute("uname");
		if(loggeduname!=null){

			Class1DoaImp class1DoaImp= new Class1DoaImp();
			
			if (request.getParameter("If-Modified-Since") == null && request.getParameter("addClass")!=null && request.getParameter("addClass").equals("addClass") && request.getParameter("name")!=null)
			{
				System.out.println("test form");
				System.out.println(request.getParameter("addClass"));
				System.out.println(request.getParameter("className"));
				System.out.println("test form end");
				
				Class1 NewClass = new Class1(request.getParameter("name"),request.getParameter("discription"));	
				class1DoaImp.addClass(NewClass);
				
			}
			if (request.getParameter("If-Modified-Since") == null && request.getParameter("deleteClass")!=null && request.getParameter("deleteClass").equals("deleteClass") && request.getParameter("classId")!=null)
			{
				System.out.println(request.getParameter("classId"));
				Integer classId = Integer.parseInt(request.getParameter("classId"));
				class1DoaImp.deleteClass1(classId);
				
			}
			
			
			
			ArrayList<Class1> classlist=(ArrayList<Class1>) class1DoaImp.listAllClasses();
			
			request.setAttribute("classlist", classlist);
			
			RequestDispatcher rd = request.getRequestDispatcher("Classes.jsp");
			
			
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
