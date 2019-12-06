package cn.OnlineTestSystem.web.servlet;

import cn.OnlineTestSystem.dao.ScoreanalyseDAO;
import cn.OnlineTestSystem.daoimpl.ScoreanalyseDAOImp;
import cn.OnlineTestSystem.domain.User;
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
        //模拟用户
        Integer userid = 1;
//        User user = (User) request.getSession().getAttribute("user");
//        Integer userid = user.getUserId();

        ScoreanalyseDAO scoreanalyseDAO = new ScoreanalyseDAOImp();
        scoreanalyseDAO.findScoreanalyseByUserId(userid);
        String str = JSON.toJSONString(scoreanalyseDAO.findScoreanalyseByUserId(userid));
        response.getWriter().write(str);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
