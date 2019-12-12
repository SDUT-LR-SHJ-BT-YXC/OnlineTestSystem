package cn.OnlineTestSystem.domain;

import java.sql.Timestamp;

/**
 * @ClassName ShowWAMrecord
 * @Desciption 用于记录错题记录中的多选题信息
 * @Author liurong
 * @Date 2019/12/12  21:59
 * @Version 1.0
 **/
public class ShowWAMrecord {
    private String question_text;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String wrong_answer;
    private Timestamp time;

    public ShowWAMrecord(String question_text, String answer1, String answer2, String answer3, String answer4, String wrong_answer, Timestamp time) {
        this.question_text = question_text;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.wrong_answer = wrong_answer;
        this.time = time;
    }

    public ShowWAMrecord() {
    }

    public String getQuestion_text() {
        return question_text;
    }

    public void setQuestion_text(String question_text) {
        this.question_text = question_text;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public String getWrong_answer() {
        return wrong_answer;
    }

    public void setWrong_answer(String wrong_answer) {
        this.wrong_answer = wrong_answer;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
