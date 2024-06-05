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
		String result = dao.login(id);
		// 성공 : 회원의 정보를 담고 있는 MavenMember 객체 반환
		// 실패 : MavenMember 객체 생성 x => null

		if (result != null) {
			System.out.println("성공");
			// 로그인한 회원의 정보를 세션에 저장
			HttpSession session = request.getSession();
			session.setAttribute("member", result);

			response.sendRedirect("index.jsp");
		} else { // null
			System.out.println("실패");
			response.sendRedirect("login.jsp");
		}

	}

}
