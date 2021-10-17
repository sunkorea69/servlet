package hello.servlet.web.frontcontroller.v5.adapter;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v5.MyHandeAdapter;
import org.eclipse.jdt.internal.compiler.ast.InstanceOfExpression;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV3HandlerAdapter implements MyHandeAdapter {

    @Override
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV3);
    }

    @Override
    public ModelView handle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws ServletException, IOException {
        ControllerV3 controllerV3 = (ControllerV3) handler;
        Map<String, String> mm = new HashMap<>();
        req.getParameterNames().asIterator().forEachRemaining(s -> mm.put(s, req.getParameter(s)));
        return controllerV3.process(mm);
    }
}
