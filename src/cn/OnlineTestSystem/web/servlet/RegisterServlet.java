package cn.OnlineTestSystem.web.servlet;

import cn.OnlineTestSystem.daoimpl.UserDAOImpl;
import cn.OnlineTestSystem.domain.User;
import cn.OnlineTestSystem.service.UserService;

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

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String nick_name = (String)request.getParameter("nick_name");
        String pwd = (String)request.getParameter("password");
        String pwd2 = (String)request.getParameter("password2");
        String email = (String)request.getParameter("email");
        if(!pwd.equals(pwd2)) {
            //ajax显示两次密码不一致
        }
        //创建user实体类
        User user = new User();
        user.setEmail(email);
        user.setNickName(nick_name);
        user.setPassword(pwd);
        user.setRole(0);

        UserService userService = new UserService();
        //判断邮箱是否重复
        if(userService.isExistEmail(email)){
            System.out.println(userService.isExistEmail(email));
            //ajax显示邮箱重复
        } else {
            //注册成功，显示它的用户Id,
            if(userService.Register(user)){
                if(userService.findUserId(email) == -1){
                    //失败
                } else {
                    int user_id = userService.findUserId(email);
                    //ajax显示用户注册所获得的userID
                    request.getRequestDispatcher("/client/login.jsp").forward(request, response);
                }
            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
