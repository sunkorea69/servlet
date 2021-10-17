package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        printStartLine(req, resp);
        printHeader(req);
    }

    private void printStartLine(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("Hello Servlet. servet");
        System.out.println("requdst = " + req);
        System.out.println("resoponse = " + resp);
        String username = req.getParameter("username");
        System.out.println("getRequest " + req.getRequestURI());
        System.out.println("getRequest " + req.getRequestURL());
        System.out.println(username);

        resp.setContentType("text/plain");
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().write("Hello " + username);
    }

    private void printHeader(HttpServletRequest request) {
        System.out.println("-----Header Start -----");
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();
            System.out.println(headerName);
        }
        System.out.println("-----Header End -----");
    }
}
