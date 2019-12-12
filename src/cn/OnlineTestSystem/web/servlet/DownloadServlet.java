package cn.OnlineTestSystem.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

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

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String filename = request.getParameter("filename");

        String path = this.getServletContext().getRealPath("download/"+filename);

        response.setHeader("Content-Disposition", "attachment;filename="+filename);
        String mimeType = this.getServletContext().getMimeType(filename);
        response.setContentType(mimeType);

        System.out.println(path);
        //response.reset();
        ServletOutputStream out = response.getOutputStream();

        FileInputStream in = new FileInputStream(path);
        byte[] buffer = new byte[1024];
        int len = 0;
        while((len=in.read(buffer)) != -1) {
            out.write(buffer,0,len);
        }
        in.close();
    }
}
