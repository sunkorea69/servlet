<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="java.util.List" %>
<%@ page import="hello.servlet.domain.member.Member" %><%--
  Created by IntelliJ IDEA.
  User: josun
  Date: 2021-09-18
  Time: 오후 1:55
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
${member1.id}
${member1.age}
<table>
    <%
        for (Member fm : lm) {
            out.write("<tr>");
            out.write("<td>" + fm.getUsername() + "</td>");
            out.write("<td>" + fm.getAge() + "</td>");
            out.write("</tr>");
        }
    %>
</table>

<a href = "/index.html"> 메인 </a>
</body>

</html>
