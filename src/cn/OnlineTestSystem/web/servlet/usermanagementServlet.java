package cn.OnlineTestSystem.web.servlet;

import cn.OnlineTestSystem.domain.AllToJSON;
import cn.OnlineTestSystem.domain.Qbank;
import cn.OnlineTestSystem.service.ExaminationService;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName usermanagementServlet
 * @Desciption 用户管理
 * @Author yinxiaochen
 * @Date 2019-12-16 18:50
 * @Version 1.0
 **/

@WebServlet("/usermanagementServlet")
public class usermanagementServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*      ExaminationService service = new ExaminationService();
        List<Qbank> list = service.getAllQbank();
//        AllQbankToJSON json = new AllQbankToJSON();
        AllToJSON<Qbank> json = new AllToJSON<Qbank>();
        json.setCode(0);
        json.setMsg("");
        json.setCount(list.size());
        json.setData(list);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(json));*/


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
