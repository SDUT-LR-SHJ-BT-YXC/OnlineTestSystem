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
 * @ClassName EditQbankServlet2
 * @Desciption TODO
 * @Author liurong
 * @Date 2019/12/19  16:29
 * @Version 1.0
 **/
@WebServlet("/EditQbankServlet2")
public class EditQbankServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String qname = request.getParameter("qname");
        HttpSession session = request.getSession();
        Qbank qbank = (Qbank) session.getAttribute("ManageQbank");
        ManageQbankService manageQbankService = new ManageQbankService();
        if(manageQbankService.UpdateQname(qbank.getQbankId(),qname)){
            response.sendRedirect(request.getContextPath()+"/ManageQbankServlet");
        }
    }
}
