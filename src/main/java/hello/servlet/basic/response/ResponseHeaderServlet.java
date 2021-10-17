package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="responseheaderservlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.setHeader("Content-type", "text/plain;charset=utf-8");
        resp.setHeader("Content-Control", "no-cache");
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("my-headeer", "header");
        content(resp);
        resp.sendRedirect("/basic/helloHome.html");
    }

    private void content(HttpServletResponse resp) {
//        resp.setHeader();
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(60000);
        resp.addCookie(cookie);
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("utf-8");
        resp.setHeader("Location", "/basic/heelo-form.html");
    }
}
