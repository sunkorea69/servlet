package hello.servlet.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberFormControllerV3 {

    private MemberRepository mr = MemberRepository.getInstance();

    @RequestMapping(value = "/new-form", method = RequestMethod.GET)
    public String process() {
        return "new-form";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String process(@RequestParam ("username") String username, @RequestParam("age") int age, Model model) {
//        String username = requ.getParameter("username");
//        int age = Integer.parseInt(requ.getParameter("age"));

        Member mb = new Member(username, age);

        mr.save(mb);
        model.addAttribute("member", mb);
        return "save-result";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String find(Model model) {
        List<Member> lm = mr.findAll();
        model.addAttribute("members", lm);
        return "members";

    }
}
