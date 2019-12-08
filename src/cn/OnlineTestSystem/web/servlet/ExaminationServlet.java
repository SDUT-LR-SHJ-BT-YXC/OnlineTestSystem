package cn.OnlineTestSystem.web.servlet;

import cn.OnlineTestSystem.domain.ExaminationPaper;
import cn.OnlineTestSystem.domain.User;
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
        HttpSession session = request.getSession();
        ExaminationService examinationService = new ExaminationService();
        User user = (User) session.getAttribute("user");
        ExaminationPaper paper = examinationService.createExaminationPaper(user.getUserId(), Integer.parseInt(id), 10, 10, 10);
        session.setAttribute("paper", paper);
        Cookie cookie = new Cookie("JSESSIONID", session.getId());
        cookie.setMaxAge(60 * 40);
        long endtime = System.currentTimeMillis() + 30 * 60 * 1000;
        session.setAttribute("endtime", endtime);
        response.addCookie(cookie);
        response.sendRedirect(request.getContextPath() + "/client/Examination.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
