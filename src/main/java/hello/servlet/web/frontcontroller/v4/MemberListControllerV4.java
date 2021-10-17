package hello.servlet.web.frontcontroller.v4;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v4.ControllerV4;

import java.util.List;
import java.util.Map;

public class MemberListControllerV4 implements ControllerV4 {
    private MemberRepository mr = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        List<Member> lm = mr.findAll();
        model.put("members", lm);
        return "members";
    }

    //    @Override
//    public ModelView process(Map<String, String> paramMap) {
//        List<Member> lm = mr.findAll();
//        ModelView mv = new ModelView("members");
//        mv.getModel().put("members", lm);
//        return mv;
//
//    }
}
