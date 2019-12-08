package cn.OnlineTestSystem.web.servlet;

import cn.OnlineTestSystem.domain.*;
import cn.OnlineTestSystem.service.ExaminationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/CheckAnswerServlet")
public class CheckAnswerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        ExaminationPaper paper = (ExaminationPaper) session.getAttribute("paper");

        ArrayList<String> rawbanswer = new ArrayList<String>();
        ArrayList<String> rawsanswer = new ArrayList<String>();
        ArrayList<String> rawmanswer = new ArrayList<String>();
        for(int i = 0; i < paper.getBlanktests().size(); i++){
            rawbanswer.add(request.getParameter("b"+ i));
            //System.out.println(request.getParameter("b" + i));
        }
        for(int i = 0; i < paper.getSinglechoices().size(); i++){
            rawsanswer.add(request.getParameter("s" + i));
            //System.out.println(request.getParameter("s" + i));
        }
        for(int i = 0; i < paper.getMultiplechoices().size(); i++){
            String str[] = request.getParameterValues("m" + i);
            //System.out.println(str);
            StringBuffer sb = new StringBuffer();
            if(str != null){
                for(int j = 0; j < str.length; j++){
                    sb.append(str[j]);
                }
            }else{
                sb.append("");
            }
            rawmanswer.add(sb.toString());
        }
        ExaminationService service = new ExaminationService();
        Scoreanalyse scoreanalyse = service.getScore(paper, rawbanswer, rawsanswer, rawmanswer);
        session.removeAttribute("endtime");
        session.setAttribute("rawbanswer", rawbanswer);
        session.setAttribute("rawsanswer", rawsanswer);
        session.setAttribute("rawmanswer", rawmanswer);
        session.setAttribute("analyse", scoreanalyse);
        response.sendRedirect(request.getContextPath() + "/client/examinationresult.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
