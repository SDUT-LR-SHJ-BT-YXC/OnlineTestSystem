package cn.OnlineTestSystem.web.servlet;

import cn.OnlineTestSystem.daoimpl.UserDAOImpl;
import cn.OnlineTestSystem.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName LoginServlet
 * @Desciption TODO
 * @Author liurong
 * @Date 2019/12/2  19:36
 * @Version 1.0
 **/
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String userid = (String) request.getParameter("user_id");
        String pwd  = (String)request.getParameter("password");
        int uid = Integer.parseInt(userid);

        //判断登录是否成功
        UserService userService = new UserService();
        if(userService.isLogin(uid,pwd)){
            //登录成功，进入主页

            response.sendRedirect("");
        } else {
            //ajax显示用户名不存在或密码错误
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
