package cn.OnlineTestSystem.daoimpl;

import cn.OnlineTestSystem.dao.BaseDAO;
import cn.OnlineTestSystem.dao.QbankDAO;
import cn.OnlineTestSystem.domain.Qbank;

import java.sql.SQLException;

/**
 * @ClassName QbankDAOImpl
 * @Desciption TODO
 * @Author shangjin
 * @Date 2019-11-29 16:16
 * @Version 1.0
 **/
public class QbankDAOImpl extends BaseDAO<Qbank> implements QbankDAO {

    @Override
    public Boolean addQbank(Qbank qbank) {
        String sql = "INSERT INTO qbank(name, single_choice_num, multiple_choice_num, blanks_num) VALUES(?,?,?,?)";
        try {
            this.update(sql,qbank.getName(), qbank.getSingleChoiceNum(), qbank.getMultipleChoiceNum(), qbank.getBlanksNum());
            return  true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean delQbankById(Integer id) {
        String sql = "DELETE FROM qbank WHERE qbank_id=?";
        try {
            this.update(sql, id);
            return  true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean modifyQbank(Qbank qbank) {
        String sql = "UPDATE qbank SET name=? WHERE qbank_id=?";
        try {
            this.update(sql, qbank.getName(), qbank.getQbankId());
            return  true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Qbank findQbankByName(String name) {
        String sql = "SELECT * FROM  qbank WHERE name=?";
        try {
            return  this.get(sql, name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Qbank findQbankById(Integer id) {
        String sql = "SELECT * FROM  qbank WHERE qbank_id=?";
        try {
            return  this.get(sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
