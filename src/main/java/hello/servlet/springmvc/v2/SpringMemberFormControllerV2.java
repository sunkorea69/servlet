package hello.servlet.springmvc.v2;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/springmvc/v2/members")
public class SpringMemberFormControllerV2 {

    private MemberRepository mr = MemberRepository.getInstance();

    @RequestMapping("/new-form")
    public ModelAndView process() {
        return new ModelAndView("new-form");
    }

    @RequestMapping("/save")
    public ModelAndView process(HttpServletRequest requ, HttpServletResponse resp) {
        String username = requ.getParameter("username");
        int age = Integer.parseInt(requ.getParameter("age"));

        Member mb = new Member(username, age);

        mr.save(mb);

        ModelAndView mv = new ModelAndView("save-result");
        mv.getModel().put("member", mb);
        return mv;
    }

    @RequestMapping
    public ModelAndView find() {
        List<Member> lm = mr.findAll();
        ModelAndView mv = new ModelAndView("members");
        mv.getModel().put("members", lm);
        return mv;

    }
}
