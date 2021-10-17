package hello.servlet.springmvc.v1;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.apache.coyote.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Controller
public class SpringMemberSaveControllerV1 {

    private MemberRepository mr = MemberRepository.getInstance();

    @RequestMapping("/springmvc/v1/members/save")
    public ModelAndView process(HttpServletRequest requ, HttpServletResponse resp) {
        String username = requ.getParameter("username");
        int age = Integer.parseInt(requ.getParameter("age"));

        Member mb = new Member(username, age);

        mr.save(mb);

        ModelAndView mv = new ModelAndView("save-result");
        mv.getModel().put("member", mb);
        return mv;
    }

}
