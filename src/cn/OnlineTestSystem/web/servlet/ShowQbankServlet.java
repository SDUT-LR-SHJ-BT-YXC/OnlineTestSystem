package cn.OnlineTestSystem.web.servlet;

import cn.OnlineTestSystem.domain.AllQbankToJSON;
import cn.OnlineTestSystem.domain.Qbank;
import cn.OnlineTestSystem.service.ExaminationService;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/ShowQbankServlet")
public class ShowQbankServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ExaminationService service = new ExaminationService();
        List<Qbank> list = service.getAllQbank();
        AllQbankToJSON json = new AllQbankToJSON();
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
