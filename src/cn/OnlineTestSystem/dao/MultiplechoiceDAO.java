package cn.OnlineTestSystem.dao;

import cn.OnlineTestSystem.domain.Blanktest;
import cn.OnlineTestSystem.domain.Multiplechoice;

import java.util.List;

/**
 * @ClassName MultiplechoiceDAO
 * @Desciption TODO
 * @Author shangjin
 * @Date 2019-11-28 19:57
 * @Version 1.0
 **/
public interface MultiplechoiceDAO {
    public Multiplechoice findMultiplechoiceById(Integer id);
    public List<Multiplechoice> findMultiplechoicesByQbankId(Integer id);
    public Boolean addMultiplechoice(Multiplechoice multiplechoice);
    public Boolean addMultiplechoices(List<Multiplechoice> list);
    public Boolean delMultiplechoiceById(Integer id);
    public Boolean delMultiplechoicesByQbankId(Integer id);
    public Boolean modifyMultiplechoice(Multiplechoice test);
    public List<Multiplechoice> findLimitedChoices(Integer qbankId, Integer s, Integer length);
}
