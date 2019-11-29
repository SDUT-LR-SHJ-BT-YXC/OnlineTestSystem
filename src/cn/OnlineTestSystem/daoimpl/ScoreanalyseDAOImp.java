package cn.OnlineTestSystem.daoimpl;

import cn.OnlineTestSystem.dao.BaseDAO;
import cn.OnlineTestSystem.dao.ScoreanalyseDAO;
import cn.OnlineTestSystem.domain.Scoreanalyse;

import java.util.List;

/**
 * @ClassName ScoreanalyseDAOImp
 * @Desciption TODO
 * @Author shangjin
 * @Date 2019-11-29 16:20
 * @Version 1.0
 **/
public class ScoreanalyseDAOImp extends BaseDAO implements ScoreanalyseDAO {
    @Override
    public Boolean addScoreanalyse(Scoreanalyse scoreanalyse) {
        return null;
    }

    @Override
    public Boolean delScoreanalyseById(Integer id) {
        return null;
    }

    @Override
    public Boolean delScoreanalyzeByUserId(Integer id) {
        return null;
    }

    @Override
    public Boolean delScoreanalyseByQbankId(Integer id) {
        return null;
    }

    @Override
    public Boolean modifyScoreanalyse(Scoreanalyse scoreanalyse) {
        return null;
    }

    @Override
    public Scoreanalyse findScoreanalyseById(Integer id) {
        return null;
    }

    @Override
    public List<Scoreanalyse> findScoreanalyseByUserId(Integer id) {
        return null;
    }

    @Override
    public List<Scoreanalyse> findScoreanalyseByQbankId(Integer id) {
        return null;
    }
}
