package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.MavenMember;
import com.smhrd.model.MavenMemberDAO;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MavenMember member = new MavenMember(id, pw);		
		
		MavenMemberDAO dao = new MavenMemberDAO();
		MavenMember result = dao.login(member);
		
		if(result!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("member", result);
			response.sendRedirect("index.jsp");
		}else { 
			response.sendRedirect("login.jsp");
		}

	}

}
