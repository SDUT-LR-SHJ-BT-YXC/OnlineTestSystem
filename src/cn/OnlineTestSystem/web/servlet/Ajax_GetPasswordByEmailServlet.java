package cn.OnlineTestSystem.web.servlet;

import cn.OnlineTestSystem.domain.User;
import cn.OnlineTestSystem.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Ajax_GetPasswordByEmailServlet")
public class Ajax_GetPasswordByEmailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        UserService service = new UserService();
        User user = service.getUser(email);
        if(user == null){
            response.getWriter().write("");
        }else
        {
            response.getWriter().write(user.getPassword());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
