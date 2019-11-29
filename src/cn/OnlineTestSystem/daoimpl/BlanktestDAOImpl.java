package cn.OnlineTestSystem.daoimpl;

import cn.OnlineTestSystem.dao.BaseDAO;
import cn.OnlineTestSystem.dao.BlanktestDAO;
import cn.OnlineTestSystem.domain.Blanktest;

import java.util.List;

/**
 * @ClassName BlanktestDAOImpl
 * @Desciption TODO
 * @Author shangjin
 * @Date 2019-11-29 16:14
 * @Version 1.0
 **/
public class BlanktestDAOImpl extends BaseDAO implements BlanktestDAO {
    @Override
    public Blanktest findBlanktestById(Integer id) {
        return null;
    }

    @Override
    public List<Blanktest> findBlanksByQbankId(Integer id) {
        return null;
    }

    @Override
    public Boolean addBlanktest(Blanktest test) {
        return null;
    }

    @Override
    public Boolean addBlanktests(List<Blanktest> list) {
        return null;
    }

    @Override
    public Boolean delBlanktestById(Integer id) {
        return null;
    }

    @Override
    public Boolean delBlanktestsByQbankId(Integer id) {
        return null;
    }

    @Override
    public Boolean modifyBlanktest(Blanktest test) {
        return null;
    }
}
