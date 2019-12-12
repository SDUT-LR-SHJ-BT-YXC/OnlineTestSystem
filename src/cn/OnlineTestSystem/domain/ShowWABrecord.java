package cn.OnlineTestSystem.domain;

import java.sql.Timestamp;

/**
 * @ClassName ShowWABrecord
 * @Desciption TODO
 * @Author liurong
 * @Date 2019/12/12  22:01
 * @Version 1.0
 **/
public class ShowWABrecord {
    private String question_text;
    private String wrong_answer;

    @Override
    public String toString() {
        return "ShowWABrecord{" +
                "question_text='" + question_text + '\'' +
                ", wrong_answer='" + wrong_answer + '\'' +
                ", time=" + time +
                '}';
    }

    private Timestamp time;

    public ShowWABrecord(String question_text, String wrong_answer, Timestamp time) {
        this.question_text = question_text;
        this.wrong_answer = wrong_answer;
        this.time = time;
    }

    public ShowWABrecord() {
    }

    public String getQuestion_text() {
        return question_text;
    }

    public void setQuestion_text(String question_text) {
        this.question_text = question_text;
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
