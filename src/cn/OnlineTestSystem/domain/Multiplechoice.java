package cn.OnlineTestSystem.domain;

/**
 * @ClassName Multiplechoice
 * @Desciption TODO
 * @Author shangjin
 * @Date 2019-11-28 19:17
 * @Version 1.0
 **/
public class Multiplechoice {
    private Integer mquestionId;
    private String questionText;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String stdAnswer;
    private Integer qbankId;//30000—59999

    public Multiplechoice(Integer mquestionId, String questionText, String answer1, String answer2, String answer3, String answer4, String stdAnswer, Integer qbankId) {
        this.mquestionId = mquestionId;
        this.questionText = questionText;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.stdAnswer = stdAnswer;
        this.qbankId = qbankId;
    }

    public Multiplechoice() {
    }

    public Integer getMquestionId() {
        return mquestionId;
    }

    public void setMquestionId(Integer mquestionId) {
        this.mquestionId = mquestionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
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
