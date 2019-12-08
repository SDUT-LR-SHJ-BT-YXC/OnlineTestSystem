package cn.OnlineTestSystem.domain;

import java.util.List;

/**
 * @ClassName ExaminationPaper
 * @Desciption TODO
 * @Author shangjin
 * @Date 2019-12-03 22:29
 * @Version 1.0
 **/
public class ExaminationPaper {
    private List<Blanktest> blanktests;
    private List<Singlechoice> singlechoices;
    private List<Multiplechoice> multiplechoices;
    private Integer subject;
    private Integer score;
    private Integer userid;
    private String qbankname;

    public ExaminationPaper() {
    }

    public String getQbankname() {
        return qbankname;
    }

    public void setQbankname(String qbankname) {
        this.qbankname = qbankname;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }



    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public List<Blanktest> getBlanktests() {
        return blanktests;
    }

    public void setBlanktests(List<Blanktest> blanktests) {
        this.blanktests = blanktests;
    }

    public List<Singlechoice> getSinglechoices() {
        return singlechoices;
    }

    public void setSinglechoices(List<Singlechoice> singlechoices) {
        this.singlechoices = singlechoices;
    }

    public List<Multiplechoice> getMultiplechoices() {
        return multiplechoices;
    }

    public void setMultiplechoices(List<Multiplechoice> multiplechoices) {
        this.multiplechoices = multiplechoices;
    }

    public Integer getSubject() {
        return subject;
    }

    public void setSubject(Integer subject) {
        this.subject = subject;
    }
}
