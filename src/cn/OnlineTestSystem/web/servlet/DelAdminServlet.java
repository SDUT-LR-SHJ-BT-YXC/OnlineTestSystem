package cn.OnlineTestSystem.web.servlet;

import cn.OnlineTestSystem.service.AdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ClassName DelAdminServlet
 * @Desciption TODO
 * @Author liurong
 * @Date 2019/12/14  11:02
 * @Version 1.0
 **/
@WebServlet("/DelAdminServlet")
public class DelAdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String adminid = request.getParameter("admin_id");
        int admin_id = Integer.parseInt(adminid);
        AdminService adminService = new AdminService();
        if(adminService.DelAdminById(admin_id)){
            //删除成功
        } else {
            //删除失败
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
