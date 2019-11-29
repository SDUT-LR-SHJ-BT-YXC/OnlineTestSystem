package cn.OnlineTestSystem.daoimpl;

import cn.OnlineTestSystem.dao.BaseDAO;
import cn.OnlineTestSystem.dao.BlanktestDAO;
import cn.OnlineTestSystem.domain.Blanktest;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName BlanktestDAOImpl
 * @Desciption TODO
 * @Author shangjin
 * @Date 2019-11-29 16:14
 * @Version 1.0
 **/
public class BlanktestDAOImpl extends BaseDAO<Blanktest> implements BlanktestDAO {
    @Override
    public Blanktest findBlanktestById(Integer id) {
        String sql = "SELECT * FROM blanktest WHERE bquestion_id=?";
        try {
            return this.get(sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }

    @Override
    public List<Blanktest> findBlanksByQbankId(Integer id) {
        String sql = "SELECT * FROM blanktest WHERE qbank_id=?";
        try {
            return  this.getForList(sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean addBlanktest(Blanktest test) {
        String sql = "INSERT INTO blanktest(question_text, std_answer, qbank_id) VALUES (?,?,?)";
        try {
            this.update(sql, test.getQuestionText(), test.getStdAnswer(), test.getQbankId());
            return  true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean addBlanktests(List<Blanktest> list) {
        Iterator<Blanktest> it = list.iterator();
        while(it.hasNext()){
            if(!this.addBlanktest(it.next())){
                return false;
            }
        }
        return true;
    }

    @Override
    public Boolean delBlanktestById(Integer id) {
        String sql = "DELETE FROM blanktest WHERE bquestion_id=?";
        try {
            this.update(sql, id);
            return  true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean delBlanktestsByQbankId(Integer id) {
        String sql = "DELETE FROM blanktest WHERE qbank_id=?";
        try {
            this.update(sql, id);
            return  true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean modifyBlanktest(Blanktest test) {
        String sql = "UPDATE blanktest SET question_text=?,std_answer=?,qbank_id=? WHERE bquestion_id=?";
        try {
            this.update(sql, test.getQuestionText(), test.getStdAnswer(), test.getQbankId(), test.getBquestionId());
            return  true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
