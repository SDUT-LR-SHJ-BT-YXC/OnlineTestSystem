package cn.OnlineTestSystem.web.servlet;

import cn.OnlineTestSystem.domain.AllToJSON;
import cn.OnlineTestSystem.domain.Qbank;
import cn.OnlineTestSystem.service.ExaminationService;
import cn.OnlineTestSystem.service.QbankService;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ShowQbankServlet")
public class ShowQbankServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ExaminationService service = new ExaminationService();
        QbankService qservice = new QbankService();
        String limit = request.getParameter("limit");
        String page = request.getParameter("page");
        List<Qbank> list = qservice.getLimitedQbank(Integer.parseInt(page), Integer.parseInt(limit));
        AllToJSON<Qbank> json = new AllToJSON<Qbank>();
        json.setCode(0);
        json.setMsg("");
        json.setCount(qservice.getQbankNum());
        json.setData(list);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(json));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
