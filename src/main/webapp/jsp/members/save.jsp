<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="hello.servlet.domain.member.Member" %><%--
  Created by IntelliJ IDEA.
  User: josun
  Date: 2021-09-18
  Time: 오전 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    MemberRepository mm = MemberRepository.getInstance();
    Member mb = new Member(request.getParameter("username"), Integer.parseInt(request.getParameter("age")));
    mm.save(mb);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <li> id=<%=mb.getId()%> </li>
    <li> id=<%=mb.getUsername()%> </li>
    <li> id=<%=mb.getAge()%> </li>
</ul>
<a href = "/index.html"> 메인 </a>
</body>
</html>
