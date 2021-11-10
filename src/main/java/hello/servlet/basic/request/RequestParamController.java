package hello.servlet.basic.request;

import hello.servlet.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username={}", username, age);
        log.info("age={}", age);
        response.getWriter().write("ok");
    }

    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParamV2(@RequestParam("username") String username1, @RequestParam("age") Integer age1) throws IOException {
        log.info("username={}", username1);
        log.info("age={}", age1);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(@RequestParam String username, @RequestParam Integer age) throws IOException {
        log.info("username={}", username);
        log.info("age={}", age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age) throws IOException {
        log.info("username={}", username);
        log.info("age={}", age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(@RequestParam(required = true) String username, @RequestParam(required = false) Integer age) throws IOException {
        log.info("username={}", username);
        log.info("age={}", age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(@RequestParam(required = true, defaultValue = "A") String username, @RequestParam(required = false, defaultValue = "0") int age) throws IOException {
        log.info("username={}", username);
        log.info("age={}", age);
        return "ok";
    }
    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paraMap) throws IOException {
        log.info("username={}", paraMap.get("username"));
        log.info("userage={}", paraMap.get("age"));
        return "ok";
    }
    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelattributeV1(@ModelAttribute HelloData helloData) throws IOException {
        log.info("username={}", helloData.getUsername());
        log.info("userage={}", helloData.getAge());
        return "ok";
    }
    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelattributeV2( HelloData helloData) throws IOException {
        log.info("username={}", helloData.getUsername());
        log.info("userage={}", helloData.getAge());
        return "ok";
    }
}
