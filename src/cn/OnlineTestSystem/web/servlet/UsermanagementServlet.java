package cn.OnlineTestSystem.web.servlet;

import cn.OnlineTestSystem.domain.AllToJSON;
import cn.OnlineTestSystem.domain.User;
import cn.OnlineTestSystem.service.AdminManagementService;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName UsermanagementServlet
 * @Desciption 用户管理
 * @Author yinxiaochen
 * @Date 2019-12-16 18:50
 * @Version 1.0
 **/

@WebServlet("/UsermanagementServlet")
public class UsermanagementServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminManagementService service = new AdminManagementService();
        List<User> list = service.getAllUser();
        for(int i = 0; i < list.size(); i++){
            int pw = list.get(i).getRole();
            if(pw == 0)
                list.get(i).setPower("用户");
            else if(pw == 1)
                list.get(i).setPower("管理员");
            else
                list.get(i).setPower("超级管理员");
        }
        AllToJSON<User> json = new AllToJSON<User>();
        json.setCode(0);
        json.setMsg("");
        json.setCount(list.size());
        json.setData(list);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(json));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
