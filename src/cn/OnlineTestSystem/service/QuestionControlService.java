package cn.OnlineTestSystem.service;

import cn.OnlineTestSystem.daoimpl.QbankDAOImpl;
import cn.OnlineTestSystem.daoimpl.SinglechoiceDAOImpl;
import cn.OnlineTestSystem.domain.Qbank;
import cn.OnlineTestSystem.domain.Singlechoice;

import java.util.List;

public class QuestionControlService {

    public SinglechoiceDAOImpl singledimpl = new SinglechoiceDAOImpl();
    public QbankDAOImpl qbankdimpl = new QbankDAOImpl();

    /**
     * create by: yinxiaochen
     * description: 获取single表
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
     * description: 获取single表大小
     * create time: 2019/12/24 9:26
     *
      * @Param: null
     * @return
     */
    public int getSingleSize(){
        return singledimpl.getSingleCount();
    }

    /**
     * create by: yinxiaochen
     * description: 按id删除一道单选题
     * create time: 2019/12/24 10:38
     *
      * @Param: null
     * @return
     */
    public void delSingle(int id){
        singledimpl.delSingle(id);
    }
}
