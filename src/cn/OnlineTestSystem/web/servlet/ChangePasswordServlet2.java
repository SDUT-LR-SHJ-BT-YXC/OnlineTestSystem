package cn.OnlineTestSystem.web.servlet;

import cn.OnlineTestSystem.domain.User;
import cn.OnlineTestSystem.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/ChangePasswordServlet2")
public class ChangePasswordServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String newPassword = request.getParameter("password");
        user.setPassword(newPassword);
        UserService service = new UserService();
        service.modifyUser(user);
        request.setCharacterEncoding("utf-8");
        session.removeAttribute("user");
        request.setAttribute("msg", "修改密码成功！3秒后跳转登录页面.....");
        request.getRequestDispatcher("/client/msg.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
