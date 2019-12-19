package cn.OnlineTestSystem.web.servlet;

import cn.OnlineTestSystem.domain.Qbank;
import cn.OnlineTestSystem.service.ManageQbankService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ClassName EditQankServlet
 * @Desciption TODO
 * @Author liurong
 * @Date 2019/12/19  16:14
 * @Version 1.0
 **/
@WebServlet("/EditQankServlet")
public class EditQankServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String qbankid = request.getParameter("qbankId");
        int qbank_id = Integer.parseInt(qbankid);
        ManageQbankService manageQbankService = new ManageQbankService();
        Qbank qbank = new Qbank();
        qbank = manageQbankService.getQbankById(qbank_id);
        HttpSession session = request.getSession();
        session.setAttribute("ManageQbank",qbank);
        response.sendRedirect(request.getContextPath()+"/client/EditQbank.jsp");
    }
}
