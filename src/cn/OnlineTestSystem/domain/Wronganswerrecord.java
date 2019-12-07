package cn.OnlineTestSystem.domain;

import java.sql.Timestamp;

/**
 * @ClassName Wronganswerrecord
 * @Desciption TODO
 * @Author shangjin
 * @Date 2019-11-28 19:05
 * @Version 1.0
 **/
public class Wronganswerrecord {
    private Integer recordId;
    private Integer questionId;
    private String wrongAnswer;
    private Timestamp time;
    private Integer userId;

    public Wronganswerrecord(Integer recordId, Integer questionId, String wrongAnswer, Timestamp time, Integer userId) {
        this.recordId = recordId;
        this.questionId = questionId;
        this.wrongAnswer = wrongAnswer;
        this.time = time;
        this.userId = userId;
    }

    public Wronganswerrecord(Integer questionId, String wrongAnswer, Timestamp time, Integer userId) {
        this.questionId = questionId;
        this.wrongAnswer = wrongAnswer;
        this.time = time;
        this.userId = userId;
    }

    public Wronganswerrecord() {
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getWrongAnswer() {
        return wrongAnswer;
    }

    public void setWrongAnswer(String wrongAnswer) {
        this.wrongAnswer = wrongAnswer;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
