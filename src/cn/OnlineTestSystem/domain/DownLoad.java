package cn.OnlineTestSystem.domain;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName DownLoad
 * @Desciption TODO
 * @Author liurong
 * @Date 2019/12/13  20:32
 * @Version 1.0
 **/
public class DownLoad {

    public static void download(String path,List<Singlechoice> singlechoiceList,List<Multiplechoice> multiplechoices,List<Blanktest> b ) throws IOException {

//        String path = "/OnlineTestSystem/download/"+qbank_id+".txt";

        FileWriter fileWriter = new FileWriter(path);

        int index = 1;//tihao
       //输出单选题
        for (Singlechoice singlechoice : singlechoiceList) {
            fileWriter.write(index+"");
            index++;
            fileWriter.write(".");
            fileWriter.write(singlechoice.getQuestionText());
            fileWriter.write("\r\n");
            fileWriter.write("A.");
            fileWriter.write(singlechoice.getAnswer1());
            fileWriter.write("\r\n");
            fileWriter.write("B.");
            fileWriter.write(singlechoice.getAnswer2());
            fileWriter.write("\r\n");
            fileWriter.write("C.");
            fileWriter.write(singlechoice.getAnswer3());
            fileWriter.write("\r\n");
            fileWriter.write("D.");
            fileWriter.write(singlechoice.getAnswer4());
            fileWriter.write("\r\n");
            fileWriter.write("正确答案：");
            fileWriter.write(singlechoice.getStdAnswer());
            fileWriter.write("\r\n");
            fileWriter.flush();

        }

        //输出多选题
        for (Multiplechoice multiplechoice : multiplechoices) {
            fileWriter.write(index+"");
            index++;
            fileWriter.write(".");
            fileWriter.write(multiplechoice.getQuestionText());
            fileWriter.write("\r\n");
            fileWriter.write("A.");
            fileWriter.write(multiplechoice.getAnswer1());
            fileWriter.write("\r\n");
            fileWriter.write("B.");
            fileWriter.write(multiplechoice.getAnswer2());
            fileWriter.write("\r\n");
            fileWriter.write("C.");
            fileWriter.write(multiplechoice.getAnswer3());
            fileWriter.write("\r\n");
            fileWriter.write("D.");
            fileWriter.write(multiplechoice.getAnswer4());
            fileWriter.write("\r\n");
            fileWriter.write("正确答案：");
            fileWriter.write(multiplechoice.getStdAnswer());
            fileWriter.write("\r\n");
            fileWriter.flush();

        }

        //输出填空题
        for (Blanktest blanktest : b) {
            fileWriter.write(index+"");
            index++;
            fileWriter.write(".");
            fileWriter.write(blanktest.getQuestionText());
            fileWriter.write("\r\n");

            fileWriter.write("正确答案：");
            fileWriter.write(blanktest.getStdAnswer());
            fileWriter.write("\r\n");
            fileWriter.flush();

        }
        fileWriter.close();

    }
}
