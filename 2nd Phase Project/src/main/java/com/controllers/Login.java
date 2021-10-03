package com.controllers;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDaoImp;
import com.dto.User;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) throws ServletException {
		/*
		 * User user = new User("admin","admin"); UserDaoImp userDaoimp= new
		 * UserDaoImp(); userDaoimp.addUser(user);
		 */
    	
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String uname = request.getParameter("uname");
		String password = request.getParameter("password");
		
		User user = new User(uname,password);		
		UserDaoImp dao = new UserDaoImp();
		boolean isValiduser = dao.validateUser(user);
		
		if (isValiduser) {
			HttpSession session = request.getSession();
			session.setAttribute("uname",user.getUserName());
			session.setMaxInactiveInterval(600);
			response.sendRedirect("dashboard");	
			}else {
				response.sendRedirect("login.jsp");
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
