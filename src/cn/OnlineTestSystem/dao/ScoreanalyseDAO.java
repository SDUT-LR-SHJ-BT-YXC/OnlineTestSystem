package cn.OnlineTestSystem.dao;

import cn.OnlineTestSystem.domain.Scoreanalyse;

import java.util.List;

/**
 * @ClassName ScoreanalyseDAO
 * @Desciption TODO
 * @Author shangjin
 * @Date 2019-11-28 20:44
 * @Version 1.0
 **/
public interface ScoreanalyseDAO {
    public Boolean addScoreanalyse(Scoreanalyse scoreanalyse);
    public Boolean delScoreanalyseById(Integer id);
    public Boolean delScoreanalyzeByUserId(Integer id);
    public Boolean delScoreanalyseByQbankId(Integer id);
    public Boolean modifyScoreanalyse(Scoreanalyse scoreanalyse);
    public Scoreanalyse findScoreanalyseById(Integer id);
    public List<Scoreanalyse> findScoreanalyseByUserId(Integer id);
    public List<Scoreanalyse> findScoreanalyseByQbankId(Integer id);
}
