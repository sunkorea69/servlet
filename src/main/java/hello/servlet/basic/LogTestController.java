package hello.servlet.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {
//    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("log-test")
    public String logTest() {
        String name = "Spring";

        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.warn("warring");
        log.error("error");
        String ls_a = "L04";
        if (!ls_a.equals("L02") && !ls_a.equals("L03") ){
            System.out.println('A');
        }

        return "ok";
    }
}
