package hello.servlet.web.frontcontroller.v2.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2.ControllerV2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberSaveControllerV2 implements ControllerV2 {


    private MemberRepository m = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Member mm = new Member();
        mm.setUsername(req.getParameter("username"));
        mm.setAge(Integer.parseInt(req.getParameter("age")));
        m.save(mm);
        req.setAttribute("member1", mm);

        MyView mv = new MyView("/WEB-INF/views/save-result.jsp");
        return mv;
    }

}
