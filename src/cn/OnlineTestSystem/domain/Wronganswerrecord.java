package cn.OnlineTestSystem.domain;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * @ClassName Wronganswerrecord
 * @Desciption TODO
 * @Author shangjin
 * @Date 2019-11-28 19:05
 * @Version 1.0
 **/
public class Wronganswerrecord {
    private Integer record_id;
    private Integer question_id;
    private String wrong_answer;
    private Timestamp time;
    private Integer user_id;

    public Wronganswerrecord(Integer record_id, Integer question_id, String wrong_answer, Timestamp time, Integer user_id) {
        this.record_id = record_id;
        this.question_id = question_id;
        this.wrong_answer = wrong_answer;
        this.time = time;
        this.user_id = user_id;
    }

    public Wronganswerrecord(Integer question_id, String wrong_answer, Timestamp time, Integer user_id) {
        this.question_id = question_id;
        this.wrong_answer = wrong_answer;
        this.time = time;
        this.user_id = user_id;
    }

    public Wronganswerrecord() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wronganswerrecord that = (Wronganswerrecord) o;
        return Objects.equals(record_id, that.record_id) &&
                Objects.equals(question_id, that.question_id) &&
                Objects.equals(wrong_answer, that.wrong_answer) &&
                Objects.equals(time, that.time) &&
                Objects.equals(user_id, that.user_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(record_id, question_id, wrong_answer, time, user_id);
    }

    @Override
    public String toString() {
        return "Wronganswerrecord{" +
                "record_id=" + record_id +
                ", question_id=" + question_id +
                ", wrong_answer='" + wrong_answer + '\'' +
                ", time=" + time +
                ", user_id=" + user_id +
                '}';
    }

    public Integer getRecord_id() {
        return record_id;
    }

    public void setRecord_id(Integer record_id) {
        this.record_id = record_id;
    }

    public Integer getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Integer question_id) {
        this.question_id = question_id;
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

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}
