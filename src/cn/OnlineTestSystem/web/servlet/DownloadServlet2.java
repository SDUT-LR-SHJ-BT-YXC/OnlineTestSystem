package cn.OnlineTestSystem.web.servlet;

import cn.OnlineTestSystem.domain.Blanktest;
import cn.OnlineTestSystem.domain.DownLoad;
import cn.OnlineTestSystem.domain.Multiplechoice;
import cn.OnlineTestSystem.domain.Singlechoice;
import cn.OnlineTestSystem.service.DownloadService;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName DownloadServlet2
 * @Desciption 从数据库中获取题库数据
 * @Author liurong
 * @Date 2019/12/13  20:17
 * @Version 1.0
 **/
@WebServlet("/DownloadServlet2")
public class DownloadServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("jinlaile");
        System.out.println("*****"+request.getContextPath());
        String qbankid = request.getParameter("qbank_id");
        int qbank_id = Integer.parseInt(qbankid);
        DownloadService downloadService = new DownloadService();
        List<Singlechoice> singlechoices = new ArrayList<>();
        List<Multiplechoice> multiplechoices = new ArrayList<>();
        List<Blanktest> blanktests = new ArrayList<>();
        //获得题库的单选题和多选题以及填空题
        singlechoices = downloadService.getALLSingleByQid(qbank_id);
        multiplechoices = downloadService.getALLMultipleByQid(qbank_id);
        blanktests = downloadService.getALLBlankByQid(qbank_id);
        String path = this.getServletContext().getRealPath("/download/"+qbank_id+".txt");
        //System.out.println("jinlaiele2");
        DownLoad.download(path,singlechoices,multiplechoices,blanktests);
        response.setHeader("Content-Disposition", "attachment;filename="+qbank_id+".txt");
        String mimeType = this.getServletContext().getMimeType(qbank_id+".txt");
        response.setContentType(mimeType);

        //System.out.println(path);
        //response.reset();
        ServletOutputStream out = response.getOutputStream();
        FileInputStream in = new FileInputStream(path);
        byte[] buffer = new byte[1024];
        int len = 0;
        while((len=in.read(buffer)) != -1) {
            out.write(buffer,0,len);
        }
        in.close();
        out.close();
    }
}
