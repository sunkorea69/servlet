package hello.servlet.web.frontcontroller.v2.controller;

import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2.ControllerV2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberListControllerV2 implements ControllerV2 {
    private MemberRepository m = MemberRepository.getInstance();

    @Override
    public  MyView process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("members", m.findAll());
        return new MyView("/WEB-INF/views/members.jsp");
    }
}
