package hello.servlet.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {
    private Logger log = LoggerFactory.getLogger(getClass());
    @RequestMapping({"hello-basic", "hello-go"})
    public String helloBasic() {
        log.info("helloBasic");
        return "ok";
    }
    @RequestMapping(value = "mapping-get-v1", method = RequestMethod.GET)
    public String mappingGetV1() {
        log.info("mappingGetV1");
        return "ok";
    }
    @GetMapping(value = "/mapping-get-v2")
    public String mappingGetV2() {
        log.info("mapping-get-v2");
        return "ok";
    }
    @GetMapping(value = "/mapping/{userId}")
    public String mappingPath(@PathVariable String userId) {
        log.info("mappingPath user={}", userId);
        return "ok";
    }
    @GetMapping(value = "/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable String orderId) {
        String ls = "AA";
        log.info("mappingPath user={} orderId", userId, orderId, ls);
        return "ok";
    }
    @GetMapping(value = "/mapping-param", params= "mode=debug")
    public String mappingParam() {
        log.info("mappingParam");
        return "ok";
    }
    @GetMapping(value = "/mapping-header", headers= "mode=debug")
    public String mappingHeaders() {
        log.info("mappingHeader");
        return "ok";
    }
    @PostMapping(value = "/mapping-consume", consumes = "application/json")
    public String mappingConsumes() {
        log.info("mappingConsumes");
        return "ok";
    }

}
