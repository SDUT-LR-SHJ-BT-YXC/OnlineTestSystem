package cn.OnlineTestSystem.daoimpl;

import cn.OnlineTestSystem.dao.BaseDAO;
import cn.OnlineTestSystem.dao.WronganswerrecordDAO;
import cn.OnlineTestSystem.domain.Wronganswerrecord;

import java.util.List;

/**
 * @ClassName WronganswerrecordDAOImpl
 * @Desciption TODO
 * @Author shangjin
 * @Date 2019-11-29 16:23
 * @Version 1.0
 **/
public class WronganswerrecordDAOImpl extends BaseDAO<Wronganswerrecord> implements WronganswerrecordDAO {
    @Override
    public Boolean addWronganswerrecord(Wronganswerrecord wronganswerrecord) {
        return null;
    }

    @Override
    public Boolean addWronganswerrecords(List<Wronganswerrecord> list) {
        return null;
    }

    @Override
    public Boolean delWronganswerrecordById(Integer id) {
        return null;
    }

    @Override
    public Boolean delWronganswerrecordsByQuestionId(Integer id) {
        return null;
    }

    @Override
    public Boolean delWronganswerrecordsByUserId(Integer id) {
        return null;
    }

    @Override
    public Boolean modifyWronganswerrecord(Wronganswerrecord wronganswerrecord) {
        return null;
    }

    @Override
    public Wronganswerrecord fnidWronganswerrecordById(Integer id) {
        return null;
    }

    @Override
    public List<Wronganswerrecord> findWronganswerrecordsByUserId(Integer id) {
        return null;
    }

    @Override
    public List<Wronganswerrecord> findWronganswerrecordsByQuestionId(Integer id) {
        return null;
    }
}
