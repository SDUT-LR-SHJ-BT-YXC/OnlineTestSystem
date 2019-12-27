package cn.OnlineTestSystem.web.servlet;

import cn.OnlineTestSystem.domain.User;
import cn.OnlineTestSystem.utils.SendEmailUtils;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;

@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        Random random = new Random();
        Integer code = 0;
        for(int i = 0; i < 4; i++){
            code *= 10;
            code += random.nextInt(10);
            if(code == 0){
                code += 1;
            }
        }
        String content = "您的修改密码验证码为：" + code.toString() + ",如果不是您本人操作请忽略本邮件。";
        try {
            SendEmailUtils.sendEmail(user.getEmail(), content);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        session.setAttribute("code", code);
        System.out.println(code);
        response.sendRedirect(request.getContextPath() + "/client/changepassword.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
