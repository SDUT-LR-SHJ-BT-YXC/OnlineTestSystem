package cn.OnlineTestSystem.web.servlet;

import cn.OnlineTestSystem.domain.User;
import cn.OnlineTestSystem.service.UserService;
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

/**
 * @program: OnlineTestSystem
 * @description: ${description}
 * @author: liu yan
 * @create: 2019-12-23 14:06
 */
@WebServlet("/ForgetPasswordServlet")
public class ForgetPasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        UserService service = new UserService();

        if(!service.isExistEmail(email)){
            request.setAttribute("msg", "您输入的邮箱未注册！3秒钟后跳转登录界面。");
            request.getRequestDispatcher("/client/msg.jsp").forward(request, response);
            return;
        }
        Random random = new Random();
        Integer code = 0;
        for(int i = 0; i < 4; i++){
            code *= 10;
            code += random.nextInt(10);
        }
        String content = "您的修改密码验证码为：" + code.toString() + ",如果不是您本人操作请忽略本邮件。";
        try {
            SendEmailUtils.sendEmail(email, content);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession();
        session.setAttribute("useremail",email);
        response.sendRedirect(request.getContextPath() + "/client/changepassword.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
