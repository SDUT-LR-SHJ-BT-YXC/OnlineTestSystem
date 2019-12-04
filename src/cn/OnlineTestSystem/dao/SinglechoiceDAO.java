package cn.OnlineTestSystem.dao;
import cn.OnlineTestSystem.domain.Singlechoice;

import java.util.List;

/**
 * @ClassName SinglechoiceDAO
 * @Desciption TODO
 * @Author shangjin
 * @Date 2019-11-28 21:01
 * @Version 1.0
 **/
public interface SinglechoiceDAO {
    public Boolean addSinglechoice(Singlechoice singlechoice);
    public Boolean addSinglechoices(List<Singlechoice> list);
    public Boolean delSinglechoiceById(Integer id);
    public Boolean delSinglechoicesByQbankId(Integer id);
    public Boolean modifySinglechoice(Singlechoice singlechoice);
    public Singlechoice findSinglechoiceById(Integer id);
    public List<Singlechoice> findSinglechoiceByQbankId(Integer id);
    public List<Singlechoice> findRandomSinglechoices(Integer qbankId, Integer n);
}
