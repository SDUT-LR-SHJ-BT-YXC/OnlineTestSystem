package cn.OnlineTestSystem.domain;

import java.util.List;

/**
 * @ClassName AllQbankToJSON
 * @Desciption TODO
 * @Author shangjin
 * @Date 2019-12-04 20:14
 * @Version 1.0
 **/
public class AllQbankToJSON {
    private Integer code;
    private String msg;
    private Integer count;
    private List<Qbank> data;

    public AllQbankToJSON() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Qbank> getData() {
        return data;
    }

    public void setData(List<Qbank> data) {
        this.data = data;
    }
}
