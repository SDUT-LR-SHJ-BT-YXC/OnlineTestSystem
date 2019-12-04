package cn.OnlineTestSystem.web.servlet;

import cn.OnlineTestSystem.domain.ExaminationPaper;
import cn.OnlineTestSystem.service.ExaminationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/ExaminationServlet")
public class ExaminationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ExaminationService examinationService = new ExaminationService();
        ExaminationPaper paper = examinationService.createExaminationPaper(Integer.parseInt(id), 10, 10, 10);
        HttpSession session = request.getSession();
        //Something ......

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
