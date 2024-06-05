<%@page import="java.io.PrintWriter"%>
<%@page import="com.smhrd.util.SHA256"%>
<%@page import="com.smhrd.model.MavenMemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String code = request.getParameter("code");
	MavenMemberDAO dao = new MavenMemberDAO();
	String id = request.getParameter("id");
	
	String userEmail = dao.getEmail(id);
	boolean rightCode = (new SHA256().getSHA256(userEmail).equals(code)) ? true : false;
	if(rightCode == true) {
		dao.setEmailChecked(id);
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('인증에 성공했습니다.');");
		script.println("location.href = 'index.jsp'");
		script.println("</script>");
		script.close();
		return;
		} else {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('유효하지 않은 코드입니다.');");
		script.println("location.href = 'index.jsp'");
		script.println("</script>");
		script.close();
		return;
		}
	

%>    
