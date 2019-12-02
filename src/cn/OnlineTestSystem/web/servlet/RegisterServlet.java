package cn.OnlineTestSystem.web.servlet;

import cn.OnlineTestSystem.daoimpl.UserDAOImpl;
import cn.OnlineTestSystem.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName RegisterServlet
 * @Desciption 注册中的表单信息传递到这里，然后加入数据库中
 * @Author liurong
 * @Date 2019-12-02 17:36
 * @Version 1.0
 **/

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String nick_name = (String)request.getParameter("nick_name");
        String pwd = (String)request.getParameter("password");
        String pwd2 = (String)request.getParameter("password2");
        String email = (String)request.getParameter("email");
        if(!pwd.equals(pwd2)) {
            PrintWriter out = response.getWriter();
            out.write("<script>alert('两次输入密码不一致！')</script>");
            out.write("<script>location.href='/OnlineTestSystem/register.jsp'</script>");
        }
        //创建user实体类
        User user = new User();
        user.setEmail(email);
        user.setNickName(nick_name);
        user.setPassword(pwd);
        user.setRole(0);
        //将user添加到数据库中
        UserDAOImpl userimpl =  new UserDAOImpl();
        userimpl.addUser(user);

        //查找用户注册所分配的ID
        List<User> users =  new ArrayList<User>();
        users = userimpl.findUsersByEmail(email);
        PrintWriter out = response.getWriter();
        out.write("<script>alert('恭喜您，注册成功！您的ID为：'+users[0].getUserId())</script>");
        out.write("<script>location.href='/OnlineTestSystem/login.jsp'</script>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
