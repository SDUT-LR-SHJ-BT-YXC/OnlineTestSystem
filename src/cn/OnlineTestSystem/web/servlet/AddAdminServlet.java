package cn.OnlineTestSystem.web.servlet;

import cn.OnlineTestSystem.domain.Admin;
import cn.OnlineTestSystem.service.AdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ClassName AddAdminServlet
 * @Desciption TODO
 * @Author liurong
 * @Date 2019/12/14  10:35
 * @Version 1.0
 **/
@WebServlet("/AddAdminServlet")
public class AddAdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String password = request.getParameter("password");
        String admin_name = request.getParameter("admin_name");
        if(password == null || admin_name == null){
            //添加失败，
            response.sendRedirect(request.getContextPath()+"/client/addAdmin.jsp");
        } else {

            AdminService adminService = new AdminService();
            Admin admin = new Admin();
            admin.setAdminName(admin_name);
            admin.setPassword(password);
            if(adminService.AddAdmin(admin)){
                //添加成功
            } else {
                //添加失败
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
