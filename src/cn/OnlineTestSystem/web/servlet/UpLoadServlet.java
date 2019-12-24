package cn.OnlineTestSystem.web.servlet;

import cn.OnlineTestSystem.domain.Multiplechoice;
import cn.OnlineTestSystem.domain.Qbank;
import cn.OnlineTestSystem.service.UpLoadService;
import jdk.internal.util.xml.impl.Input;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/UpLoadServlet")
public class UpLoadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("UPLOAD===================");
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");
        List<Multiplechoice> MuList = new ArrayList<>();
        Multiplechoice multiplechoice = new Multiplechoice();
        if(!ServletFileUpload.isMultipartContent(request)){
            return;
        }
        try {
            List<FileItem> list = upload.parseRequest(request);
            for (FileItem item :list){
                    String filename = item.getName();
                    System.out.println("文件名"+filename);
                    //获取文件输入流
                    InputStream in = item.getInputStream();
                    //获取工作簿
                    Workbook workbook = WorkbookFactory.create(in);
                    //获取表格
                    Sheet sheetAt = workbook.getSheetAt(0);
                    //遍历表格数据
                    for(Row row: sheetAt) {
                        multiplechoice = new Multiplechoice();
                        if (row.getRowNum() == 0)
                            continue;
                        int mquestion_id = (int)row.getCell(0).getNumericCellValue();
                        System.out.println("-----------"+mquestion_id);
                        multiplechoice.setMquestionId(mquestion_id);
                        row.getCell(1).setCellType(CellType.STRING);
                        String question_text = row.getCell(1).getStringCellValue();
                        multiplechoice.setQuestionText(question_text);
                        System.out.println("-----------"+question_text);
                        row.getCell(2).setCellType(CellType.STRING);
                        String answer1 = row.getCell(2).getStringCellValue();
                        multiplechoice.setAnswer1(answer1);
                        System.out.println("-----------"+answer1);
                        row.getCell(3).setCellType(CellType.STRING);
                        String answer2 = row.getCell(3).getStringCellValue();
                        multiplechoice.setAnswer2(answer2);
                        System.out.println("-----------"+answer2);
                        row.getCell(4).setCellType(CellType.STRING);
                        String answer3 = row.getCell(4).getStringCellValue();
                        multiplechoice.setAnswer3(answer3);
                        System.out.println("-----------"+answer3);
                        row.getCell(5).setCellType(CellType.STRING);
                        String answer4 = row.getCell(5).getStringCellValue();
                        multiplechoice.setAnswer4(answer4);
                        System.out.println("-----------"+answer4);
                        row.getCell(6).setCellType(CellType.STRING);
                        String std_answer = row.getCell(6).getStringCellValue();
                        multiplechoice.setStdAnswer(std_answer);
                        System.out.println("-----------"+std_answer);
                        int qbank_id = (int)row.getCell(7).getNumericCellValue();
                        multiplechoice.setQbankId(qbank_id);
                        System.out.println("-----------"+qbank_id);
                        MuList.add(multiplechoice);
                    }
            }
            UpLoadService upLoadService = new UpLoadService();
            upLoadService.addMultiplechoices(MuList);
            System.out.println("上传成功"+MuList.size());

        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        response.sendRedirect(request.getContextPath() + "/client/adminpage.jsp");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
