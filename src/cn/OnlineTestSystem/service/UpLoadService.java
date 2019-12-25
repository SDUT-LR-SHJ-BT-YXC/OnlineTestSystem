package cn.OnlineTestSystem.service;

import cn.OnlineTestSystem.daoimpl.BlanktestDAOImpl;
import cn.OnlineTestSystem.daoimpl.MultiplechoiceDAOImpl;
import cn.OnlineTestSystem.daoimpl.SinglechoiceDAOImpl;
import cn.OnlineTestSystem.domain.Blanktest;
import cn.OnlineTestSystem.domain.Multiplechoice;
import cn.OnlineTestSystem.domain.Singlechoice;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;
/**
 * @ClassName UpLoadService
 * @Desciption 上传文件
 * @Author baitao
 * @Date 2019-12-24 14:00
 * @Version 1.0
 **/
public class UpLoadService {
    private MultiplechoiceDAOImpl dao;
    private SinglechoiceDAOImpl daos;
    private BlanktestDAOImpl daob;
    public UpLoadService(){
        this.dao = new MultiplechoiceDAOImpl();
        this.daos = new SinglechoiceDAOImpl();
        this.daob = new BlanktestDAOImpl();
    }
    /**
     * @Author: baitao
     * @Description:添加多选题
     * @Param:
     * @Return:
     * @Date: 2019-12-24
     */
    public Boolean addMultiplechoices(List<Multiplechoice> list){
        return dao.addMultiplechoices(list);
    }
    /**
     * @Author: baitao
     * @Description:添加单选题
     * @Param:
     * @Return:
     * @Date: 2019-12-24
     */
    public Boolean addSinglechoices(List<Singlechoice> list){
        return daos.addSinglechoices(list);
    }
    /**
     * @Author: baitao
     * @Description:添加填空题
     * @Param:
     * @Return:
     * @Date: 2019-12-24
     */
    public Boolean addBlankTests(List<Blanktest> list){
        return daob.addBlanktests(list);
    }

}
