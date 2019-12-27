package cn.OnlineTestSystem.dao;

import cn.OnlineTestSystem.domain.Qbank;

import java.util.List;

/**
 * @ClassName QbankDAO
 * @Desciption TODO
 * @Author shangjin
 * @Date 2019-11-28 20:39
 * @Version 1.0
 **/
public interface QbankDAO {
    public Boolean addQbank(Qbank qbank);
    public Boolean delQbankById(Integer id);
    public Boolean modifyQbank(Qbank qbank);
    public Qbank findQbankByName(String name);
    public Qbank findQbankById(Integer id);
    public List<Qbank> getAllQbank();
    public Boolean changeNum(Qbank qbank);
    public Integer getQbankNum();
    public List<Qbank> getLimitedQband(int page, int limit);
}
