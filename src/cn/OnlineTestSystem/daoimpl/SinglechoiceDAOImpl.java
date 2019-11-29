package cn.OnlineTestSystem.daoimpl;

import cn.OnlineTestSystem.dao.BaseDAO;
import cn.OnlineTestSystem.dao.SinglechoiceDAO;
import cn.OnlineTestSystem.domain.Singlechoice;

import java.util.List;

/**
 * @ClassName SinglechoiceDAOImpl
 * @Desciption TODO
 * @Author shangjin
 * @Date 2019-11-29 16:21
 * @Version 1.0
 **/
public class SinglechoiceDAOImpl extends BaseDAO implements SinglechoiceDAO {
    @Override
    public Boolean addSinglechoice(Singlechoice singlechoice) {
        return null;
    }

    @Override
    public Boolean addSinglechoices(List<Singlechoice> list) {
        return null;
    }

    @Override
    public Boolean delSinglechoiceById(Integer id) {
        return null;
    }

    @Override
    public Boolean delSinglechoicesByQbankId(Integer id) {
        return null;
    }

    @Override
    public Boolean modifySinglechoice(Singlechoice singlechoice) {
        return null;
    }

    @Override
    public Singlechoice findSinglechoiceById(Integer id) {
        return null;
    }

    @Override
    public List<Singlechoice> findSinglechoiceByQbankId(Integer id) {
        return null;
    }
}
