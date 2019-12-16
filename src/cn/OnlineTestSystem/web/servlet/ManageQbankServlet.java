package cn.OnlineTestSystem.web.servlet;

import cn.OnlineTestSystem.daoimpl.QbankDAOImpl;
import cn.OnlineTestSystem.domain.Qbank;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName ManageQbankServlet
 * @Desciption TODO
 * @Author liurong
 * @Date 2019/12/16  21:17
 * @Version 1.0
 **/
@WebServlet("/ManageQbankServlet")
public class ManageQbankServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        QbankDAOImpl qbankDAO = new QbankDAOImpl();
        //获取所有课程信息，转化为json文件
        List<Qbank> qbanks = qbankDAO.getAllQbank();
        JSONArray json = JSONArray.parseArray(JSON.toJSONString(qbanks));
        request.getSession().setAttribute("Qbankjson", json);
        System.out.println(request.getSession().getAttribute("json"));
        response.sendRedirect(request.getContextPath()+"/client/ManageQbank.jsp");
    }
}
