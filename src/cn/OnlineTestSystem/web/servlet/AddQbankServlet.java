package cn.OnlineTestSystem.web.servlet;

import cn.OnlineTestSystem.service.ManageQbankService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName AddQbankServlet
 * @Desciption TODO
 * @Author liurong
 * @Date 2019/12/18  20:46
 * @Version 1.0
 **/
@WebServlet("/AddQbankServlet")
public class AddQbankServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String qname = request.getParameter("qname");
        ManageQbankService manageQbankService = new ManageQbankService();
        manageQbankService.AddQbank(qname);
        response.sendRedirect(request.getContextPath()+"/ManageQbankServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
