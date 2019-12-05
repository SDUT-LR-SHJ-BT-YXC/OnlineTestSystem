package cn.OnlineTestSystem.web.servlet;

import cn.OnlineTestSystem.domain.ExaminationPaper;
import cn.OnlineTestSystem.service.ExaminationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/ExaminationServlet")
public class ExaminationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String id = request.getParameter("id");
        ExaminationService examinationService = new ExaminationService();
        ExaminationPaper paper = examinationService.createExaminationPaper(Integer.parseInt(id), 10, 10, 10);
        HttpSession session = request.getSession();
        session.setAttribute("paper", paper);
        Cookie cookie = new Cookie("JSESSIONID", session.getId());
        cookie.setMaxAge(60 * 40);
        response.addCookie(cookie);
        request.getRequestDispatcher(request.getContextPath() + "/client/Examination.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
