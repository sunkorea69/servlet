package hello.servlet.web.frontcontroller.v4;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v4.ControllerV4;
import hello.servlet.web.frontcontroller.v4.MemberFormControllerV4;
import hello.servlet.web.frontcontroller.v4.MemberListControllerV4;
import hello.servlet.web.frontcontroller.v4.MemberSaveControllerV4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV4", urlPatterns = "/front-controller/v4/*")
public class FrontControllerServletV4 extends HttpServlet {
    private Map<String, ControllerV4> controllerMap = new HashMap<>();

    public FrontControllerServletV4() {
        controllerMap.put("/front-controller/v4/members/new-form", new MemberFormControllerV4());
        controllerMap.put("/front-controller/v4/members/save", new MemberSaveControllerV4());
        controllerMap.put("/front-controller/v4/members", new MemberListControllerV4());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

////       url 분석
////         객체 조회
////        이동
        String requestURI = req.getRequestURI();

        ControllerV4 controller = controllerMap.get(requestURI);
        if(controller == null) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return ;
        }
        Map<String, String> paramMap = new HashMap<>();
        Map<String, Object> model = new HashMap<>();
        req.getParameterNames().asIterator().forEachRemaining(
                (s) -> {
                   paramMap.put(s, req.getParameter(s));
                }
        );

        String viewName  = controller.process(paramMap, model);

        MyView mv = new MyView("/WEB-INF/views/" + viewName + ".jsp");
        mv.render(model,req,resp);


//        Map<String, String> paramMap = createParaMap(req);
//        ModelView mv = controller.process(paramMap);
//
//        String viewName = mv.getViewName();
//        MyView view = viewResolver(viewName);
//        view.render(mv.getModel(), req, resp);
//
    }
//    private Map<String, String> createParaMap(HttpServletRequest req) {
//        Map<String, String> paramMap = new HashMap<>();
//
//        req.getParameterNames().asIterator().forEachRemaining(s -> paramMap.put(s, req.getParameter(s)));
//
//        return paramMap;
//    }
//    private MyView viewResolver(String viewName) {
//        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
//    }
}
