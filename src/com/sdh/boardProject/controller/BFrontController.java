package com.sdh.boardProject.controller;

import com.sdh.boardProject.command.Command;
import com.sdh.boardProject.command.MemberJoinCommand;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("*.do")
public class BFrontController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        action(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        action(req, resp);
    }

    public void action(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String viewPage = null;
        Command command = null;

        String url = req.getRequestURI();
        String conPath = req.getContextPath();
        String com =url.substring(conPath.length());

        if(com.equals("memberJoin.do")) {
            command = new MemberJoinCommand();
            command.execute(req, resp);
            viewPage = "memberJoinOk.jsp";
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
        dispatcher.forward(req, resp);
    }
}
