package cn.OnlineTestSystem.web.servlet;

import cn.OnlineTestSystem.domain.Qbank;
import cn.OnlineTestSystem.domain.User;
import cn.OnlineTestSystem.service.WrongAnswerRecordService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName WrongAnswerRecordServlet
 * @Desciption TODO
 * @Author liurong
 * @Date 2019/12/5  20:51
 * @Version 1.0
 **/
@WebServlet("/WrongAnswerRecordServlet")
public class WrongAnswerRecordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //jsp中需要题库的数量，以及题库名称，计算每个题库错误数占题库总题量的比例
        //需要加入session（每个题库所对应的的错题总数，分别加入session中）
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        WrongAnswerRecordService wrongAnswerRecordService = new WrongAnswerRecordService();
        int sumQbank = wrongAnswerRecordService.getSumQbank();
        List<Integer> WrongAnswerSum = wrongAnswerRecordService.getSumWA(user.getUserId());
        List<Integer> QbankSum = wrongAnswerRecordService.getSumQ();
        List<Qbank> qbanks = wrongAnswerRecordService.getAllQbank();
        System.out.println("WAsum.."+WrongAnswerSum.get(0)+".."+WrongAnswerSum.get(1)+"fff"+WrongAnswerSum.get(2));

        session.setAttribute("WAsum",WrongAnswerSum);
        session.setAttribute("Qsum",QbankSum);
        session.setAttribute("WAqbanks",qbanks);
        response.sendRedirect(request.getContextPath()+"/client/WrongAnswerRecord.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
