package cn.OnlineTestSystem.dao;

import cn.OnlineTestSystem.domain.Blanktest;

import java.util.List;

/**
 * @ClassName BlanktestDAO
 * @Desciption TODO
 * @Author shangjin
 * @Date 2019-11-28 19:58
 * @Version 1.0
 **/
public interface BlanktestDAO {
    public Blanktest findBlanktestById(Integer id);
    public List<Blanktest> findBlanksByQbankId(Integer id);
    public Boolean addBlanktest(Blanktest test);
    public Boolean addBlanktests(List<Blanktest> list);
    public Boolean delBlanktestById(Integer id);
    public Boolean delBlanktestsByQbankId(Integer id);
    public Boolean modifyBlanktest(Blanktest test);
    public List<Blanktest> findRandomBlanks(Integer qbankId, Integer n);
    public int getBlankCount();
    public void delBlank(int id);
    public List<Blanktest> getLimitedBlank(int start, int limit, String search);
}
