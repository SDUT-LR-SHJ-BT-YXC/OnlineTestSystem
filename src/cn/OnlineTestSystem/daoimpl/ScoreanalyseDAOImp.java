package cn.OnlineTestSystem.daoimpl;

import cn.OnlineTestSystem.dao.BaseDAO;
import cn.OnlineTestSystem.dao.ScoreanalyseDAO;
import cn.OnlineTestSystem.domain.Scoreanalyse;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName ScoreanalyseDAOImp
 * @Desciption TODO
 * @Author shangjin
 * @Date 2019-11-29 16:20
 * @Version 1.0
 **/
public class ScoreanalyseDAOImp extends BaseDAO<Scoreanalyse> implements ScoreanalyseDAO {
    @Override
    /**
     * @Author: Shangjin
     * @Description:添加一个新的成绩记录
     * @Param:
     * @Return:
     * @Date: 21:51 2019-11-29
     */
    public Boolean addScoreanalyse(Scoreanalyse scoreanalyse) {
        String sql = "INSERT INTO scoreanalyse(score, time, user_id, qbank_id) VALUES (?,?,?,?)";
        try {
            this.update(sql, scoreanalyse.getScore(), scoreanalyse.getTime(), scoreanalyse.getUserId(), scoreanalyse.getQbankId());
            return  true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    /**
     * @Author: Shangjin
     * @Description:根据成绩记录ID删除此成绩记录
     * @Param:
     * @Return:
     * @Date: 21:52 2019-11-29
     */
    public Boolean delScoreanalyseById(Integer id) {
        String sql = "DELETE FROM scoreanalyse WHERE score_record_id=?";
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
     * @Description:根据用户名字删除某用户的所有成绩记录
     * @Param:
     * @Return:
     * @Date: 21:53 2019-11-29
     */
    public Boolean delScoreanalyzeByUserId(Integer id) {
        String sql = "DELETE FROM scoreanalyse WHERE user_id=?";
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
     * @Description:根据科目ID删除所有此科目的成绩记录
     * @Param:
     * @Return:
     * @Date: 21:53 2019-11-29
     */
    public Boolean delScoreanalyseByQbankId(Integer id) {
        String sql = "DELETE FROM scoreanalyse WHERE qbank_id=?";
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
     * @Description:修改某条成绩记录，以此成绩记录ID依据
     * @Param:
     * @Return:
     * @Date: 21:54 2019-11-29
     */
    public Boolean modifyScoreanalyse(Scoreanalyse scoreanalyse) {
        String sql = "UPDATE scoreanalyse SET score=?, time=?,user_id=?,qbank_id=? WHERE score_record_id=?";
        try {
            this.update(sql, scoreanalyse.getScore(), scoreanalyse.getTime(), scoreanalyse.getUserId(), scoreanalyse.getQbankId(),
                    scoreanalyse.getScoreRecordId());
            return  true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    /**
     * @Author: Shangjin
     * @Description:通过ID查找成绩记录
     * @Param:
     * @Return:
     * @Date: 21:54 2019-11-29
     */
    public Scoreanalyse findScoreanalyseById(Integer id) {
        String sql = "SELECT * FROM scoreanalyse WHERE score_record_id=?";
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
     * @Description:根据用户ID查找所有此用户的成绩记录
     * @Param:
     * @Return:
     * @Date: 21:55 2019-11-29
     */
    public List<Scoreanalyse> findScoreanalyseByUserId(Integer id) {
        String sql = "SELECT * FROM scoreanalyse WHERE user_id=?";
        try {
            return  this.getForList(sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Scoreanalyse> findScoreanalyseByUserId(Integer id, Integer limit) {
        String sql = "SELECT * FROM scoreanalyse WHERE user_id=? ORDER BY time desc limit 0 ,?";
        try {
            return  this.getForList(sql, id, limit);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    /**
     * @Author: Shangjin
     * @Description:根据科目ID查找此科目的所有成绩记录
     * @Param:
     * @Return:
     * @Date: 21:56 2019-11-29
     */
    public List<Scoreanalyse> findScoreanalyseByQbankId(Integer id) {
        String sql = "SELECT * FROM scoreanalyse WHERE qbank_id=?";
        try {
            return  this.getForList(sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
