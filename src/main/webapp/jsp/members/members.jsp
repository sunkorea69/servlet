<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: josun
  Date: 2021-09-18
  Time: 오전 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    MemberRepository mm = MemberRepository.getInstance();
    List<Member> lm = mm.findAll();
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    for (Member member : lm){
        out.write("<tr>");
        out.write("<td>" + member.getUsername() + "</td>");
        out.write("<td>" + member.getAge() + "</td>");
        out.write("</tr>");
        out.write("</br>");
    }
%>
<a href = "/index.html"> 메인 </a>
</body>
</html>





