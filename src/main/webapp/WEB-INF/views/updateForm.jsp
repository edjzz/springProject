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
<h1>WebContent/member/updateForm.jsp</h1>
<%
// 세션값 가져오기
String id=(String)session.getAttribute("id");
//패키지 member 파일이름 MemberDAO 
//MemberDAO 객체생성
// MemberDAO mdao=new MemberDAO();
// //MemberBean mb =    getMember(아이디) 호출
// MemberBean mb=mdao.getMember(id);
%>
<form action="./update" method="post">
아이디: <input type="text" name="id" value="${mb.id }" readonly="readonly"><br>
비밀번호: <input type="password" name="pass"><br>
수정할 이름:<input type="text" value="${mb.name }" name="name" value=""><br>
<input type="submit" value="회원정보수정">
</form>
</body>
</html>








