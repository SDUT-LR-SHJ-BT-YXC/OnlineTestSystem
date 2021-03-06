package cn.OnlineTestSystem.web.servlet;

import cn.OnlineTestSystem.service.QuestionControlService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Ajax_DeleteQuestionServlet")
public class Ajax_DeleteQuestionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.setContentType("text/html;charset=utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String type = request.getParameter("type");
        QuestionControlService service = new QuestionControlService();
        if(type.equals("single")){
            service.delSingle(id);
        }else if(type.equals("multiple")){
            service.delMultiple(id);
        }else {
            service.delBlank(id);
        }
       // response.sendRedirect(request.getContextPath() + "/client/QuestionsControl.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
