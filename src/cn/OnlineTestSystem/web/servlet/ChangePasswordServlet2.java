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
        UserService service = new UserService();
        HttpSession session = request.getSession();
        String newPassword = request.getParameter("password");
        User user = (User) session.getAttribute("user");
        if(user != null){
            // 已登录的用户修改密码请求
            user.setPassword(newPassword);
            service.modifyUser(user);
            session.removeAttribute("user");
        }
        else{
            //未登录的用户密码修改请求
            String email = (String) session.getAttribute("useremail");
            User user1 = service.getUser(email);
            service.modifyUser(user1);
            session.removeAttribute("email");
        }
        request.setCharacterEncoding("utf-8");

        request.setAttribute("msg", "修改密码成功！3秒后跳转登录页面.....");
        request.getRequestDispatcher("/client/msg.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
