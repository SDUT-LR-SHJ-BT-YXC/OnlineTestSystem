package cn.OnlineTestSystem.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName WrongAnswerRecordServlet
 * @Desciption TODO
 * @Author liurong
 * @Date 2019/12/5  20:51
 * @Version 1.0
 **/
@WebServlet(name = "WrongAnswerRecordServlet")
public class WrongAnswerRecordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //jsp中需要题库的数量，以及题库名称，计算每个题库错误数占题库总题量的比例
        //需要加入session（每个题库所对应的的错题总数，分别加入session中）
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
