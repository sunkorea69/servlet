package hello.servlet.springmvc.old;

import hello.servlet.web.frontcontroller.ModelView;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Component("/springmvc/old-controller")
public class OldController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("OldController.handleRequestkkk");
        ModelView mv = new ModelView("new-form");
        Map<String, Object> m = new HashMap<>();
        mv.setModel(m);
        return new ModelAndView("new-form");
    }
}
