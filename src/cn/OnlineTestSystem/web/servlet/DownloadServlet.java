package cn.OnlineTestSystem.web.servlet;

import cn.OnlineTestSystem.domain.Qbank;
import cn.OnlineTestSystem.domain.Wronganswerrecord;
import cn.OnlineTestSystem.service.DownloadService;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName DownloadServlet
 * @Desciption TODO
 * @Author liurong
 * @Date 2019/12/12  22:13
 * @Version 1.0
 **/
@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DownloadService downloadService = new DownloadService();
        List<Qbank> qbanks = new ArrayList<>();
        qbanks = downloadService.getAllQbank();
        HttpSession session = request.getSession();
        session.setAttribute("DownQbank",qbanks);
        response.sendRedirect(request.getContextPath() + "/client/download.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
