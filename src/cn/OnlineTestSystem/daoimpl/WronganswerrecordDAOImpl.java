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
    /**
     * @Author: Shangjin
     * @Description:添加一条错题记录
     * @Param:
     * @Return:
     * @Date: 22:01 2019-11-29
     */
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
    /**
     * @Author: Shangjin
     * @Description:批量添加错题记录
     * @Param:
     * @Return:
     * @Date: 22:02 2019-11-29
     */
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
    /**
     * @Author: Shangjin
     * @Description:根据错题记录ID删除某条错题记录
     * @Param:
     * @Return:
     * @Date: 22:02 2019-11-29
     */
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
    /**
     * @Author: Shangjin
     * @Description:通过习题ID删除某习题的所有错题记录
     * @Param:
     * @Return:
     * @Date: 22:02 2019-11-29
     */
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
    /**
     * @Author: Shangjin
     * @Description:通过用户ID删除某用户的所有错题记录
     * @Param:
     * @Return:
     * @Date: 22:03 2019-11-29
     */
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
    /**
     * @Author: Shangjin
     * @Description:修改某错题记录，以此错题记录ID为依据
     * @Param:
     * @Return:
     * @Date: 22:04 2019-11-29
     */
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
    /**
     * @Author: Shangjin
     * @Description:根据错题记录ID查找某条错题记录
     * @Param:
     * @Return:
     * @Date: 22:05 2019-11-29
     */
    public Wronganswerrecord findWronganswerrecordById(Integer id) {
        String sql = "SELECT * FROM wronganswerrecord WHERE record_id=?";
        try {
            return  this.get(sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    /**
     * @Author: Shangjin
     * @Description:根据用户ID查找此用户所有错题记录
     * @Param:
     * @Return:
     * @Date: 22:05 2019-11-29
     */
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
    /**
     * @Author: Shangjin
     * @Description:根据习题ID查找此习题的所有错题记录
     * @Param:
     * @Return:
     * @Date: 22:06 2019-11-29
     */
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
