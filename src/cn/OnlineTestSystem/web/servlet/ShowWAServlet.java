package cn.OnlineTestSystem.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ClassName ShowWAServlet
 * @Desciption TODO
 * @Author liurong
 * @Date 2019/12/11  22:39
 * @Version 1.0
 **/
@WebServlet("/ShowWAServlet")
public class ShowWAServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        String qbankId = request.getParameter("qbank_id");
        HttpSession session = request.getSession();
        int qbank_id = Integer.parseInt(qbankId);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
