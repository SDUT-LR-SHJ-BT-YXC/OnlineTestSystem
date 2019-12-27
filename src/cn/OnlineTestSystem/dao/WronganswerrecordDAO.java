package cn.OnlineTestSystem.dao;

import cn.OnlineTestSystem.domain.Wronganswerrecord;

import java.util.List;

/**
 * @ClassName WronganswerrecordDAO
 * @Desciption TODO
 * @Author shangjin
 * @Date 2019-11-28 21:06
 * @Version 1.0
 **/
public interface WronganswerrecordDAO {
    public  Boolean addWronganswerrecord(Wronganswerrecord wronganswerrecord);
    public Boolean addWronganswerrecords(List<Wronganswerrecord> list);
    public Boolean delWronganswerrecordById(Integer id);
    public Boolean delWronganswerrecordsByQuestionId(Integer id);
    public Boolean delWronganswerrecordsByUserId(Integer id);
    public Boolean modifyWronganswerrecord(Wronganswerrecord wronganswerrecord);
    public Wronganswerrecord findWronganswerrecordById(Integer id);
    public List<Wronganswerrecord> findWronganswerrecordsByUserId(Integer id);
    public List<Wronganswerrecord> findWronganswerrecordsByQuestionId(Integer id);
    public Wronganswerrecord findWronganswerrecordsByQuestionIdAndUserId(Integer questionid, Integer userId);
}
