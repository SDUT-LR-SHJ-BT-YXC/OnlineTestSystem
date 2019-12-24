package cn.OnlineTestSystem.domain;

/**
 * @ClassName Singlechoice
 * @Desciption TODO
 * @Author shangjin
 * @Date 2019-11-28 19:10
 * @Version 1.0
 **/
public class Singlechoice {
    private Integer squestionId;
    private String questionText;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String stdAnswer;
    private Integer qbankId;//1-29999
    private String name;

    public Singlechoice() {
    }

    public Singlechoice(Integer squestionId, String questionText, String answer1, String answer2, String answer3, String answer4, String stdAnswer, Integer qbankId, String name) {
        this.squestionId = squestionId;
        this.questionText = questionText;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.stdAnswer = stdAnswer;
        this.qbankId = qbankId;
        this.name = name;
    }

    public Integer getSquestionId() {
        return squestionId;
    }

    public void setSquestionId(Integer squestionId) {
        this.squestionId = squestionId;
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
        return stdAnswer.toUpperCase();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
