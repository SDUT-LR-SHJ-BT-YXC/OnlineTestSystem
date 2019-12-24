package cn.OnlineTestSystem.service;

import cn.OnlineTestSystem.dao.SinglechoiceDAO;
import cn.OnlineTestSystem.daoimpl.SinglechoiceDAOImpl;
import cn.OnlineTestSystem.daoimpl.UserDAOImpl;
import cn.OnlineTestSystem.domain.Singlechoice;

import java.util.List;

public class QuestionControlService {

    public SinglechoiceDAOImpl singledimpl = new SinglechoiceDAOImpl();

    /**
     * create by: yinxiaochen
     * description:
     * create time: 2019/12/24 9:19
     *
      * @Param: null
     */
    public List<Singlechoice> getLimitedSingle(int page, int limit, String search){
        int start = limit * (page - 1);
        List<Singlechoice> list = singledimpl.getLimitedSingle(start, limit, search);
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
        return singledimpl.getSingleCount();
    }
}
