package cn.OnlineTestSystem.web.servlet;

import cn.OnlineTestSystem.domain.AllToJSON;
import cn.OnlineTestSystem.domain.User;
import cn.OnlineTestSystem.service.AdminManagementService;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * create by: yinxiaochen
 * description: TODO
 * create time: 2019/12/24 6:51
 */
@WebServlet("/SingleControlServlet")
public class SingleControlServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminManagementService service = new AdminManagementService();
        String QuestionType = request.getParameter("qtype");
        String QuestionText = request.getParameter("qtext");
        System.out.println(QuestionType);
        System.out.println(QuestionText);
     /*   if(QuestionType.equals("") || QuestionType.equals("单选题")){

        }else if(QuestionType.equals("多选题")){

        }else {

        }*/
        int page = Integer.parseInt(request.getParameter("page"));
        System.out.println(page);
        int limit = Integer.parseInt(request.getParameter("limit"));
        List<User> list = service.getLimitedUser(page, limit);
        for(int i = 0; i < list.size(); i++){
            int pw = list.get(i).getRole();
            if(pw == 0)
                list.get(i).setPower("用户");
            else if(pw == 1)
                list.get(i).setPower("管理员");
            else
                list.get(i).setPower("超级管理员");
        }
        AllToJSON<User> json = new AllToJSON<User>();
        json.setCode(0);
        json.setMsg("");
        json.setCount(service.getUserSize());
        json.setData(list);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(json));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
