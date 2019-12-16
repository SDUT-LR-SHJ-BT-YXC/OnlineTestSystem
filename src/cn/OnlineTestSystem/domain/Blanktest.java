package cn.OnlineTestSystem.domain;


/**
 * @ClassName Blanktest
 * @Desciption TODO
 * @Author shangjin
 * @Date 2019-11-28 19:14
 * @Version 1.0
 **/
public class Blanktest {
    private Integer bquestionId;
    private String questionText;
    private String stdAnswer;
    private Integer qbankId;// >= 60000

    public Blanktest(Integer bquestionId, String questionText, String stdAnswer, Integer qbankId) {
        this.bquestionId = bquestionId;
        this.questionText = questionText;
        this.stdAnswer = stdAnswer;
        this.qbankId = qbankId;
    }

    public Blanktest() {
    }

    public Integer getBquestionId() {
        return bquestionId;
    }

    public void setBquestionId(Integer bquestionId) {
        this.bquestionId = bquestionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getStdAnswer() {
        return stdAnswer;
    }

    public void setStdAnswer(String stdAnswer) {
        this.stdAnswer = stdAnswer;
    }

    public Integer getQbankId() {
        return qbankId;
    }

    public void setQbankId(Integer qbankId) {
        this.qbankId = qbankId;
    }
}
