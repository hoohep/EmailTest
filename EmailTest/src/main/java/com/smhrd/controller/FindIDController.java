package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.MavenMember;
import com.smhrd.model.MavenMemberDAO;
import com.smhrd.util.SHA256;

public class FindIDController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String emailHash = SHA256.getSHA256(email);
		boolean emailChecked = false;
		
		MavenMember member = new MavenMember(name, email, emailHash);
		
		MavenMemberDAO dao = new MavenMemberDAO();
		int res = dao.FindID(member);
		
		
	}

}
