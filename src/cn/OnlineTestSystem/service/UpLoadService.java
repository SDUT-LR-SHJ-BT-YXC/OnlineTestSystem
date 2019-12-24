package cn.OnlineTestSystem.service;

import cn.OnlineTestSystem.daoimpl.MultiplechoiceDAOImpl;
import cn.OnlineTestSystem.domain.Multiplechoice;
import java.util.List;

public class UpLoadService {
    private MultiplechoiceDAOImpl dao;
    public UpLoadService(){ dao = new MultiplechoiceDAOImpl();}
    public Boolean addMultiplechoices(List<Multiplechoice> list){
        return dao.addMultiplechoices(list);
    }
}
