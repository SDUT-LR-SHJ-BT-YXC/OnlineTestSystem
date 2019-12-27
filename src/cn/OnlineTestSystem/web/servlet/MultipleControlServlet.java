package cn.OnlineTestSystem.web.servlet;

import cn.OnlineTestSystem.domain.AllToJSON;
import cn.OnlineTestSystem.domain.Multiplechoice;
import cn.OnlineTestSystem.domain.Singlechoice;
import cn.OnlineTestSystem.service.QuestionControlService;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/MultipleControlServlet")
public class MultipleControlServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionControlService service = new QuestionControlService();
        String QuestionText = "";
        if(request.getParameter("qtext") != null)
            QuestionText = request.getParameter("qtext");
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        List<Multiplechoice> list = service.getLimitedMultiple(page, limit, QuestionText);
        AllToJSON<Multiplechoice> json = new AllToJSON<Multiplechoice>();
        json.setCode(0);
        json.setMsg("");
        json.setCount(service.getMultipleSize());
        json.setData(list);
        response.setContentType("text/html;charset=utf-8");
        request.getSession().setAttribute("QCmark", '2');
        response.getWriter().write(JSON.toJSONString(json));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
