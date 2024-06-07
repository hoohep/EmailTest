<%@page import="com.smhrd.model.MavenMember"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String id = request.getParameter("id");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%MavenMember member = (MavenMember)session.getAttribute("member"); %>

	<%if(member==null){ %>
		<!-- 로그인 전 -->
	<a href="join.jsp"><button>회원가입</button></a>
	<a href="login.jsp"><button>로그인</button></a><br>
	<a href="FindID.jsp"><button>ID찾기</button></a>
	<%}else{ %>
		<!-- 로그인 후 -->
		<%=member.getName()%> <a href="LogoutController"><button>로그아웃</button></a>
	<%} %>
	
	<%if(id!=null){ %>
	<script>
        // URL 파라미터로부터 가져온 ID를 사용하여 알림창으로 표시
        alert('인증에 성공했습니다. ID는 <%= id %>입니다.');
    </script>
	<%} %>
</body>
</html>