package hello.servlet.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@Slf4j
@Controller
public class RequestBodyStringController {

    @PostMapping("/request-string-body-v1")
    public void requestStringBodyV1 (HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        log.info("msg={}{}", messageBody, messageBody);
        response.getWriter().write("OK");
    }
    @PostMapping("/request-string-body-v2")
    public void requestStringBodyV1 (InputStream inputStream, Writer writer) throws IOException {
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        log.info("msg={}{}", messageBody, messageBody);
        writer.write("OK");
    }

    @PostMapping("/request-string-body-v3")
    public HttpEntity<String> requestStringBodyV3 (HttpEntity<String> httpEntity) throws IOException {
        String messageBody = httpEntity.getBody();
        log.info("msg={}{}", messageBody, messageBody);
        return new HttpEntity<>("ok");
    }
    @ResponseBody
    @PostMapping("/request-string-body-v4")
    public HttpEntity<String> requestStringBodyV4 (@RequestBody String messageBody) throws IOException {
        log.info("msg={}{}", messageBody, messageBody);
        return new HttpEntity<>("ok");
    }
}
