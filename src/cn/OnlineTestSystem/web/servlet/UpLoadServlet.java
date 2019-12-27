package cn.OnlineTestSystem.web.servlet;

import cn.OnlineTestSystem.domain.*;
import cn.OnlineTestSystem.service.UpLoadService;
import com.alibaba.fastjson.JSON;
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
import javax.servlet.http.HttpSession;
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
        HttpSession session = request.getSession();
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");
        List<Multiplechoice> MuList = new ArrayList<>();
        List<Singlechoice> SinList = new ArrayList<>();
        List<Blanktest> BlanList = new ArrayList<>();
        Multiplechoice multiplechoice;
        Singlechoice singlechoice;
        Blanktest blanktest;
        if(!ServletFileUpload.isMultipartContent(request)){
            return;
        }
        try {
            int flag=0;
            String FileName = null;
            String filename = null;
            List<FileItem> list = upload.parseRequest(request);
            for (FileItem item :list){
                    //获取文件输入流
                    InputStream in = item.getInputStream();
                    //获取工作簿
                    Workbook workbook = WorkbookFactory.create(in);
                    //获取表格
                    Sheet sheetAt = workbook.getSheetAt(0);
                    //遍历表格数据
                    for(Row row: sheetAt) {
                        if (row.getRowNum() == 0&&row.getCell(0).toString().equals("multiplechoice")) {
                            flag = 1;
                            FileName = item.getName();
                            String namesplit[] = FileName.split("\\.");
                            filename = namesplit[0];
                            System.out.println("切割后文件名"+filename);
                            continue;
                        }
                        else if(row.getRowNum() == 0&&row.getCell(0).toString().equals("singlechoice")){
                            flag = 2;
                            FileName = item.getName();
                            String namesplit[] = FileName.split("\\.");
                            filename = namesplit[0];
                            System.out.println("切割后文件名"+filename);
                            continue;
                        }
                        else if (row.getRowNum() ==0&&row.getCell(0).toString().equals("blanktest")){
                            flag = 3;
                            FileName = item.getName();
                            String namesplit[] = FileName.split("\\.");
                            filename = namesplit[0];
                            System.out.println("切割后文件名"+filename);
                            continue;
                        }

                        //上传文件为多选题
                        if(flag == 1){
                            multiplechoice = new Multiplechoice();
                            row.getCell(1).setCellType(CellType.NUMERIC);
                            int mquestion_id = (int)row.getCell(1).getNumericCellValue();
                            multiplechoice.setMquestionId(mquestion_id);

                            row.getCell(2).setCellType(CellType.STRING);
                            String question_text = row.getCell(2).getStringCellValue();
                            multiplechoice.setQuestionText(question_text);

                            row.getCell(3).setCellType(CellType.STRING);
                            String answer1 = row.getCell(3).getStringCellValue();
                            multiplechoice.setAnswer1(answer1);

                            row.getCell(4).setCellType(CellType.STRING);
                            String answer2 = row.getCell(4).getStringCellValue();
                            multiplechoice.setAnswer2(answer2);

                            row.getCell(5).setCellType(CellType.STRING);
                            String answer3 = row.getCell(5).getStringCellValue();
                            multiplechoice.setAnswer3(answer3);

                            row.getCell(6).setCellType(CellType.STRING);
                            String answer4 = row.getCell(6).getStringCellValue();
                            multiplechoice.setAnswer4(answer4);

                            row.getCell(7).setCellType(CellType.STRING);
                            String std_answer = row.getCell(7).getStringCellValue();
                            multiplechoice.setStdAnswer(std_answer);

                            int qbank_id = (int)row.getCell(8).getNumericCellValue();
                            multiplechoice.setQbankId(qbank_id);

                            MuList.add(multiplechoice);
                        }
                        //上传文件为单选题
                        else if(flag == 2){
                            System.out.println("上传单选题！！！！");
                            singlechoice = new Singlechoice();
                            row.getCell(1).setCellType(CellType.NUMERIC);
                            int mquestion_id = (int)row.getCell(1).getNumericCellValue();
                            System.out.println(mquestion_id);
                            singlechoice.setSquestionId(mquestion_id);

                            row.getCell(2).setCellType(CellType.STRING);
                            String squestion_text = row.getCell(2).getStringCellValue();
                            singlechoice.setQuestionText(squestion_text);
                            System.out.println(squestion_text);

                            row.getCell(3).setCellType(CellType.STRING);
                            String answer1 = row.getCell(3).getStringCellValue();
                            singlechoice.setAnswer1(answer1);

                            row.getCell(4).setCellType(CellType.STRING);
                            String answer2 = row.getCell(4).getStringCellValue();
                            singlechoice.setAnswer2(answer2);

                            row.getCell(5).setCellType(CellType.STRING);
                            String answer3 = row.getCell(5).getStringCellValue();
                            singlechoice.setAnswer3(answer3);

                            row.getCell(6).setCellType(CellType.STRING);
                            String answer4 = row.getCell(6).getStringCellValue();
                            singlechoice.setAnswer4(answer4);

                            row.getCell(7).setCellType(CellType.STRING);
                            String std_answer = row.getCell(7).getStringCellValue();
                            singlechoice.setStdAnswer(std_answer);

                            int qbank_id = (int)row.getCell(8).getNumericCellValue();
                            singlechoice.setQbankId(qbank_id);

                            SinList.add(singlechoice);

                        }
                        //上传文件为填空
                        else if(flag == 3){
                            blanktest = new Blanktest();
                            row.getCell(1).setCellType(CellType.NUMERIC);
                            int bquestion_id = (int)row.getCell(1).getNumericCellValue();
                            blanktest.setBquestionId(bquestion_id);
                            row.getCell(2).setCellType(CellType.STRING);
                            String question_text = row.getCell(2).getStringCellValue();
                            blanktest.setQuestionText(question_text);
                            row.getCell(3).setCellType(CellType.STRING);
                            String std_answer = row.getCell(3).getStringCellValue();
                            blanktest.setStdAnswer(std_answer);
                            int qbank_id = (int)row.getCell(4).getNumericCellValue();
                            blanktest.setQbankId(qbank_id);
                            BlanList.add(blanktest);

                        }

                    }
            }
            UpLoadService upLoadService = new UpLoadService();
            UploadRes res = new UploadRes();
            if(flag ==1){
                System.out.println("添加多选题！！！");
                boolean mul = upLoadService.addMultiplechoices(MuList,filename);
                if(mul==true){
                    res.setCode(0);
                }
                else {
                    res.setCode(1);
                }
                res.setMsg("");
                response.getWriter().write(JSON.toJSONString(res));
            }
            else if(flag ==2){
                System.out.println("添加单选题！！！");
                boolean sig = upLoadService.addSinglechoices(SinList,filename);
                if(sig==true){
                    res.setCode(0);
                }
                else {
                    res.setCode(1);
                }
                res.setMsg("");
                response.getWriter().write(JSON.toJSONString(res));
            }
            else if(flag ==3){
                System.out.println("添加填空题！！！");
                boolean ban = upLoadService.addBlankTests(BlanList,filename);
                if(ban==true){
                    res.setCode(0);
                }
                else {
                    res.setCode(1);
                }
                res.setMsg("");
                response.getWriter().write(JSON.toJSONString(res));
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
