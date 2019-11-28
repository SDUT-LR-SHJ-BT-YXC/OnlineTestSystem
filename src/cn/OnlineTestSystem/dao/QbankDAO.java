package cn.OnlineTestSystem.dao;

import cn.OnlineTestSystem.domain.Qbank;
import com.sun.org.apache.xpath.internal.operations.Bool;

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
}
