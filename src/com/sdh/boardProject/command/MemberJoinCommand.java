package com.sdh.boardProject.command;

import com.sdh.boardProject.dao.MemberDao;
import com.sdh.boardProject.dto.MemberDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberJoinCommand implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {

        String memberId = req.getParameter("memberId");
        String memberPw = req.getParameter("memberPw");
        String memeberName = req.getParameter("memberName");
        String memberPhone = req.getParameter("memberPhone");
        String memberEmail = req.getParameter("memberEmail");

        MemberDao memberDao = new MemberDao();
        MemberDto memberDto = new MemberDto();
        memberDao.memberJoin(memberDto);

        req.setAttribute("memberName", memberDto.getMemberName());
    }
}
