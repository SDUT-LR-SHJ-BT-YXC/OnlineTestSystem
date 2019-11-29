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
    public Boolean delScoreanalyseById(Integer id) {
        String sql = "DELETE scoreanalyse WHERE score_record_id=?";
        try {
            this.update(sql, id);
            return  true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean delScoreanalyzeByUserId(Integer id) {
        String sql = "DELETE scoreanalyse WHERE user_id=?";
        try {
            this.update(sql, id);
            return  true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean delScoreanalyseByQbankId(Integer id) {
        String sql = "DELETE scoreanalyse WHERE qbank_id=?";
        try {
            this.update(sql, id);
            return  true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
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
