package cn.OnlineTestSystem.daoimpl;

import cn.OnlineTestSystem.dao.BaseDAO;
import cn.OnlineTestSystem.dao.QbankDAO;
import cn.OnlineTestSystem.domain.Qbank;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName QbankDAOImpl
 * @Desciption TODO
 * @Author shangjin
 * @Date 2019-11-29 16:16
 * @Version 1.0
 **/
public class QbankDAOImpl extends BaseDAO<Qbank> implements QbankDAO {

    @Override
    /**
     * @Author: Shangjin
     * @Description:增加一个科目
     * @Param:
     * @Return:
     * @Date: 21:49 2019-11-29
     */
    public Boolean addQbank(Qbank qbank) {
        String sql = "INSERT INTO qbank(qbank_id, name, single_choice_num, multiple_choice_num, blanks_num) VALUES(?,?,?,?,?)";
        try {
            this.update(sql,qbank.getQbankId(),qbank.getName(), qbank.getSingleChoiceNum(), qbank.getMultipleChoiceNum(), qbank.getBlanksNum());
            return  true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    /**
     * @Author: Shangjin
     * @Description:根据科目ID删除某科目
     * @Param:
     * @Return:
     * @Date: 21:49 2019-11-29
     */
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
    /**
     * @Author: Shangjin
     * @Description:修改某科目的题库信息，以本科目的ID为依据
     * @Param:
     * @Return:
     * @Date: 21:49 2019-11-29
     */
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
    /**
     * @Author: Shangjin
     * @Description:通过科目名字获取此科目的题库信息
     * @Param:
     * @Return:
     * @Date: 21:50 2019-11-29
     */
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
    /**
     * @Author: Shangjin
     * @Description:通过科目ID查找某科目题库信息
     * @Param:
     * @Return:
     * @Date: 21:51 2019-11-29
     */
    public Qbank findQbankById(Integer id) {
        String sql = "SELECT * FROM  qbank WHERE qbank_id=?";
        try {
            return  this.get(sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Qbank> getAllQbank() {
        String sql = "SELECT * FROM  qbank";
        try {
            return  this.getForList(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }

    @Override
    /**
     * @Author: yinxiaochen
     * @Description:修改某科目的题目数量信息，以本科目的ID为依据
     * @Param:
     * @Return:{
     * @Date: 11:00 2019-12-24
     */
    public Boolean changeNum(Qbank qbank) {
        String sql = "UPDATE qbank SET single_choice_num=?, multiple_choice_num=?, blanks_num=? WHERE qbank_id=?";
        try {
            this.update(sql, qbank.getSingleChoiceNum(), qbank.getMultipleChoiceNum(), qbank.getBlanksNum(), qbank.getQbankId());
            return  true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
