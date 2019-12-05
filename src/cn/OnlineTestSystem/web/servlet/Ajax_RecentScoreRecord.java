package cn.OnlineTestSystem.web.servlet;

import cn.OnlineTestSystem.dao.ScoreanalyseDAO;
import cn.OnlineTestSystem.daoimpl.ScoreanalyseDAOImp;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Ajax_RecentScoreRecord")
public class Ajax_RecentScoreRecord extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String userid = request.getParameter("userid");
        //模拟用户
        String userid = "1";
        System.out.println("/Ajax_RecentScoreRecord");
        ScoreanalyseDAO scoreanalyseDAO = new ScoreanalyseDAOImp();
        scoreanalyseDAO.findScoreanalyseByUserId(Integer.parseInt(userid));
        String str = JSON.toJSONString(scoreanalyseDAO.findScoreanalyseByUserId(Integer.parseInt(userid)));
        response.getWriter().write(str);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
