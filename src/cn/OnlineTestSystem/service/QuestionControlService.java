package cn.OnlineTestSystem.service;

import cn.OnlineTestSystem.domain.Singlechoice;
import cn.OnlineTestSystem.domain.User;

import java.util.List;

public class QuestionControlService {

    private Singlechoice dao;

    public QuestionControlService(){
        dao = new Singlechoice();
    }

    /**
     * create by: yinxiaochen
     * description:
     * create time: 2019/12/24 9:19
     *
      * @Param: null
     */
    public List<Singlechoice> getLimitedSingle(int page, int limit, String search){
        int start = limit * (page - 1);
        List<Singlechoice> list = dao.getLimitedUser(start, limit);
        return list;
    }
    /**
     * create by: yinxiaochen
     * description:
     * create time: 2019/12/24 9:26
     *
      * @Param: null
     * @return
     */
    public int getSingleSize(){
        return 0;
    }
}
