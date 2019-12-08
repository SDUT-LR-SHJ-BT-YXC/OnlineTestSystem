package cn.OnlineTestSystem.service;

import cn.OnlineTestSystem.dao.ScoreanalyseDAO;
import cn.OnlineTestSystem.daoimpl.ScoreanalyseDAOImp;
import cn.OnlineTestSystem.domain.Scoreanalyse;

import java.util.List;

/**
 * @ClassName ScoreAnalyseService
 * @Desciption TODO
 * @Author shangjin
 * @Date 2019-12-08 18:19
 * @Version 1.0
 **/
public class ScoreAnalyseService {
    private ScoreanalyseDAOImp scoreanalyseDAOImp;

    public ScoreAnalyseService() {
        scoreanalyseDAOImp = new ScoreanalyseDAOImp();
    }
    public List<Scoreanalyse> getRecentScoreanalyseByUserId(Integer userid, Integer limit){
        return scoreanalyseDAOImp.findScoreanalyseByUserId(userid, limit);
    }
}
