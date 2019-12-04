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
    private String subject;
    private Integer score;

    public ExaminationPaper(List<Blanktest> blanktests, List<Singlechoice> singlechoices, List<Multiplechoice> multiplechoices, String subject, Integer score) {
        this.blanktests = blanktests;
        this.singlechoices = singlechoices;
        this.multiplechoices = multiplechoices;
        this.subject = subject;
        this.score = score;
    }

    public ExaminationPaper() {
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
