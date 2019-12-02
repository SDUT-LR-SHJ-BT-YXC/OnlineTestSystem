package cn.OnlineTestSystem.web.servlet;

import cn.OnlineTestSystem.daoimpl.UserDAOImpl;

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
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String userid = (String) request.getParameter("user_id");
        String pwd  = (String)request.getParameter("password");

        int uid = Integer.parseInt(userid);
        UserDAOImpl userdimp = new UserDAOImpl();
        if(userdimp.findUserById(uid) == null || (!pwd.equals(userdimp.findUserById(uid).getPassword()))){
            PrintWriter out = response.getWriter();
            out.write("<script>alert('用户名不存在或密码错误！')</script>");
        } else{
            PrintWriter out = response.getWriter();
            out.write("<script>alert('登录成功')</script>");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
