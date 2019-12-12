package cn.OnlineTestSystem.web.servlet;

import cn.OnlineTestSystem.domain.*;
import cn.OnlineTestSystem.service.WrongAnswerRecordService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ShowWAServlet
 * @Desciption TODO
 * @Author liurong
 * @Date 2019/12/11  22:39
 * @Version 1.0
 **/
@WebServlet("/ShowWAServlet")
public class ShowWAServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.setContentType("text/html;charset=utf-8");
        String qbankId = request.getParameter("qbank_id");
        HttpSession session = request.getSession();
        int qbank_id = Integer.parseInt(qbankId);
        User user = (User) session.getAttribute("user");
        int user_id = user.getUserId();
        List<ShowWASrecord> was = new ArrayList<>();
        List<ShowWAMrecord> wam = new ArrayList<>();
        List<ShowWABrecord> wab = new ArrayList<>();
        WrongAnswerRecordService wrongAnswerRecordService = new WrongAnswerRecordService();
        was = wrongAnswerRecordService.getWASrecordsByQid(qbank_id,user_id);
        wam = wrongAnswerRecordService.getWAMrecordByQid(qbank_id,user_id);
        wab = wrongAnswerRecordService.getWABrecordByQid(qbank_id,user_id);
        //System.out.println("aaaa"+was.size());

        //System.out.println("liurongjiushigedidi");
        //根据题库ID查看此题库所有错题
        session.setAttribute("ShowWAS",was);
        session.setAttribute("ShowWAM",wam);
        session.setAttribute("ShowWAB",wab);
        response.sendRedirect(request.getContextPath()+"/client/ShowWA.jsp");
}
}
