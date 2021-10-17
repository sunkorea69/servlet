package hello.servlet.web.frontcontroller.v4;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v4.ControllerV4;

import java.util.Map;

public class MemberSaveControllerV4 implements ControllerV4 {
   MemberRepository mr = MemberRepository.getInstance();

   @Override
   public String process(Map<String, String> paramMap, Map<String, Object> model) {
      String username = paramMap.get("username");
      int age = Integer.parseInt(paramMap.get("age"));

      Member mb = new Member(username, age);

      mr.save(mb);
      model.put("member", mb);

      return "save-result";
   }

   //   @Override
//   public ModelView process(Map<String, String> paramMap) {
//      String username = paramMap.get("username");
//      int age = Integer.parseInt(paramMap.get("age"));
//
//      Member mb = new Member(username, age);
//
//      mr.save(mb);
//
//      ModelView mv = new ModelView("save-result");
//      mv.getModel().put("member", mb);
//      return mv;
//   }
}
