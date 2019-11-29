package cn.OnlineTestSystem.daoimpl;

import cn.OnlineTestSystem.dao.BaseDAO;
import cn.OnlineTestSystem.dao.WronganswerrecordDAO;
import cn.OnlineTestSystem.domain.Wronganswerrecord;

import java.sql.SQLException;
import java.util.Iterator;
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
        String sql = "INSERT INTO wronganswerrecord(question_id, wrong_answer, time, user_id) VALUES (?, ?, ?,?)";
        try {
            this.update(sql, wronganswerrecord.getQuestionId(), wronganswerrecord.getWrongAnswer(), wronganswerrecord.getTime(),
                    wronganswerrecord.getUserId());
            return  true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean addWronganswerrecords(List<Wronganswerrecord> list) {
        Iterator<Wronganswerrecord> it = list.iterator();
        while(it.hasNext()){
            if(!this.addWronganswerrecord(it.next())){
                return  false;
            }
        }
        return true;
    }

    @Override
    public Boolean delWronganswerrecordById(Integer id) {
        String sql = "DELETE FROM wronganswerrecord WHERE record_id=?";
        try {
            this.update(sql, id);
            return  true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean delWronganswerrecordsByQuestionId(Integer id) {
        String sql = "DELETE FROM wronganswerrecord WHERE question_id=?";
        try {
            this.update(sql, id);
            return  true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean delWronganswerrecordsByUserId(Integer id) {
        String sql = "DELETE FROM wronganswerrecord WHERE user_id=?";
        try {
            this.update(sql, id);
            return  true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean modifyWronganswerrecord(Wronganswerrecord wronganswerrecord) {
        String sql = "UPDATE wronganswerrecord SET question_id=?,wrong_answer=?, time=?,user_id=? WHERE record_id=?";
        try {
            this.update(sql, wronganswerrecord.getQuestionId(), wronganswerrecord.getWrongAnswer(), wronganswerrecord.getTime(),
                    wronganswerrecord.getUserId(), wronganswerrecord.getRecordId());
            return  true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Wronganswerrecord fnidWronganswerrecordById(Integer id) {
        String sql = "SELECT * FROM wronganswerrecord WHERE record_id=?";
        try {
            return  this.get(sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Wronganswerrecord> findWronganswerrecordsByUserId(Integer id) {
        String sql = "SELECT * FROM wronganswerrecord WHERE user_id=?";
        try {
            return this.getForList(sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Wronganswerrecord> findWronganswerrecordsByQuestionId(Integer id) {
        String sql = "SELECT * FROM wronganswerrecord WHERE question_id=?";
        try {
            return this.getForList(sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
