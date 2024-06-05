package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.MavenMember;
import com.smhrd.model.MavenMemberDAO;
import com.smhrd.util.SHA256;

public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String emailHash = SHA256.getSHA256(email);
		
		MavenMember member = new MavenMember(id, pw, email, emailHash, name);
		
		MavenMemberDAO dao = new MavenMemberDAO();
		int res = dao.join(member);
		
		if(res>0) {
			// 회원가입 성공
			response.sendRedirect("index.jsp");
		}else {
			// 회원가입 실패
			response.sendRedirect("join.jsp");
		}
	}

}
