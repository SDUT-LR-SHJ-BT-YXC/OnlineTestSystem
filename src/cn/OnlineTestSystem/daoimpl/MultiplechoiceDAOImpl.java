package cn.OnlineTestSystem.daoimpl;

import cn.OnlineTestSystem.dao.BaseDAO;
import cn.OnlineTestSystem.dao.MultiplechoiceDAO;
import cn.OnlineTestSystem.domain.Blanktest;
import cn.OnlineTestSystem.domain.Multiplechoice;

import java.util.List;

/**
 * @ClassName MultiplechoiceDAOImpl
 * @Desciption TODO
 * @Author shangjin
 * @Date 2019-11-29 16:14
 * @Version 1.0
 **/
public class MultiplechoiceDAOImpl extends BaseDAO implements MultiplechoiceDAO {
    @Override
    public Multiplechoice findMultiplechoiceById(Integer id) {
        return null;
    }

    @Override
    public List<Multiplechoice> findMultiplechoicesByQbankId(Integer id) {
        return null;
    }

    @Override
    public Boolean addMultiplechoice(Multiplechoice multiplechoice) {
        return null;
    }

    @Override
    public Boolean addMultiplechoices(List<Multiplechoice> list) {
        return null;
    }

    @Override
    public Boolean delMultiplechoiceById(Integer id) {
        return null;
    }

    @Override
    public Boolean delMultiplechoicesByQbankId(Integer id) {
        return null;
    }

    @Override
    public Boolean modifyMultiplechoice(Blanktest test) {
        return null;
    }
}
