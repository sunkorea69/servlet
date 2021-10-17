package hello.servlet.web.servlet;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Repository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "memberListServlet", urlPatterns = "/servlet/members")
public class MemberListServlet extends HttpServlet {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      List<Member> listAll = memberRepository.findAll();
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        PrintWriter p =  resp.getWriter();
        p.write("<html>");
        p.write("<head>");
        p.write("</head>");
        p.write("<body>");
        p.write("<table boder=1>");
        for (Member mm : listAll) {
            p.write("<tr>");
            p.write (" <td>" + mm.getUsername() + "</td>");
            p.write (" <td>" + mm.getAge() + "</td>");
            p.write("</tr>");
        }
        p.write("</table>");
        p.write("</body>");
    }
}
