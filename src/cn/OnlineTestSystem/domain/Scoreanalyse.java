package cn.OnlineTestSystem.domain;

import java.sql.Timestamp;

/**
 * @ClassName Scoreanalyse
 * @Desciption TODO
 * @Author shangjin
 * @Date 2019-11-28 19:02
 * @Version 1.0
 **/
public class Scoreanalyse {
    private Integer scoreRecordId;
    private Integer score;
    private Timestamp time;
    private Integer userId;
    private Integer qbankId;

    public Scoreanalyse(Integer scoreRecordId, Integer score, Timestamp time, Integer userId, Integer qbankId) {
        this.scoreRecordId = scoreRecordId;
        this.score = score;
        this.time = time;
        this.userId = userId;
        this.qbankId = qbankId;
    }

    public Scoreanalyse() {
    }

    public Integer getScoreRecordId() {
        return scoreRecordId;
    }

    public void setScoreRecordId(Integer scoreRecordId) {
        this.scoreRecordId = scoreRecordId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
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

    public Integer getQbankId() {
        return qbankId;
    }

    public void setQbankId(Integer qbankId) {
        this.qbankId = qbankId;
    }
}
