package cn.OnlineTestSystem.domain;

/**
 * @ClassName Qbank
 * @Desciption TODO
 * @Author shangjin
 * @Date 2019-11-28 18:59
 * @Version 1.0
 **/
public class Qbank {
    private int qbankId;
    private String  name;
    private Integer singleChoiceNum;
    private Integer multipleChoiceNum;
    private Integer blanksNum;

    public Qbank(int qbankId, String name, Integer singleChoiceNum, Integer multipleChoiceNum, Integer blanksNum) {
        this.qbankId = qbankId;
        this.name = name;
        this.singleChoiceNum = singleChoiceNum;
        this.multipleChoiceNum = multipleChoiceNum;
        this.blanksNum = blanksNum;
    }

    public Qbank() {
    }

    public int getQbankId() {
        return qbankId;
    }

    public void setQbankId(int qbankId) {
        this.qbankId = qbankId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSingleChoiceNum() {
        return singleChoiceNum;
    }

    public void setSingleChoiceNum(Integer singleChoiceNum) {
        this.singleChoiceNum = singleChoiceNum;
    }

    public Integer getMultipleChoiceNum() {
        return multipleChoiceNum;
    }

    public void setMultipleChoiceNum(Integer multipleChoiceNum) {
        this.multipleChoiceNum = multipleChoiceNum;
    }

    public Integer getBlanksNum() {
        return blanksNum;
    }

    public void setBlanksNum(Integer blanksNum) {
        this.blanksNum = blanksNum;
    }
}
