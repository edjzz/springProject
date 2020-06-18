<%-- <%@page import="member.MemberBean"%> --%>
<%-- <%@page import="member.MemberDAO"%> --%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>WebContent/member/info.jsp</h1>

아이디:${mb.id }<br>
비밀번호:${mb.pass}<br>
이름:${mb.name}<br>
가입날짜:${mb.reg_date}<br>

<a href="./main">메인화면</a>
</body>
</html>















