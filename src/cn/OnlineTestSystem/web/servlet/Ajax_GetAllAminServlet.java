package cn.OnlineTestSystem.web.servlet;

import cn.OnlineTestSystem.domain.Admin;
import cn.OnlineTestSystem.domain.AllToJSON;
import cn.OnlineTestSystem.service.AdminManagementService;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Ajax_GetAllAminServlet")
public class Ajax_GetAllAminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminManagementService service = new AdminManagementService();
        //获取所有Admin
        List<Admin> list = service.getAllAdmin();

        //将获取到的所有Admin类封装到layui数据表格可以显示到数据格式
        AllToJSON<Admin> json = new AllToJSON<Admin>();
        json.setData(list);
        json.setCode(0);
        json.setMsg("");
        json.setCount(list.size());

        response.getWriter().write(JSON.toJSONString(json));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
