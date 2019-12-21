package cn.OnlineTestSystem.web.servlet;

import cn.OnlineTestSystem.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/ChangeRoleServlet")
public class ChangeRoleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        int userid = Integer.parseInt(request.getParameter("id"));
        System.out.println(userid);
        UserService usr = new UserService();
        usr.changeRole(userid);
        response.sendRedirect(request.getContextPath() + "/client/adminpage.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
