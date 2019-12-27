package cn.OnlineTestSystem.service;

import cn.OnlineTestSystem.daoimpl.BlanktestDAOImpl;
import cn.OnlineTestSystem.daoimpl.MultiplechoiceDAOImpl;
import cn.OnlineTestSystem.daoimpl.QbankDAOImpl;
import cn.OnlineTestSystem.daoimpl.SinglechoiceDAOImpl;
import cn.OnlineTestSystem.domain.Blanktest;
import cn.OnlineTestSystem.domain.Multiplechoice;
import cn.OnlineTestSystem.domain.Qbank;
import cn.OnlineTestSystem.domain.Singlechoice;

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
    private QbankDAOImpl daoq;
    public UpLoadService(){
        this.dao = new MultiplechoiceDAOImpl();
        this.daos = new SinglechoiceDAOImpl();
        this.daob = new BlanktestDAOImpl();
        this.daoq = new QbankDAOImpl();
    }
    /**
     * @Author: baitao
     * @Description:添加多选题
     * @Param:
     * @Return:
     * @Date: 2019-12-24
     */
    public Boolean addMultiplechoices(List<Multiplechoice> list,String QbankName){
        for(int i=0;i<list.size();i++){
            Qbank qbank = new Qbank();
            int Qbankid = list.get(i).getQbankId();
            if(daoq.findQbankById(Qbankid) == null){
                qbank.setQbankId(Qbankid);
                qbank.setName(QbankName);
                qbank.setMultipleChoiceNum(0);
                qbank.setSingleChoiceNum(0);
                qbank.setBlanksNum(0);
                daoq.addQbank(qbank);
            }
        }
        return dao.addMultiplechoices(list);
    }
    /**
     * @Author: baitao
     * @Description:添加单选题
     * @Param:
     * @Return:
     * @Date: 2019-12-24
     */
    public Boolean addSinglechoices(List<Singlechoice> list,String QbankName){
        for(int i=0;i<list.size();i++){
            Qbank qbank = new Qbank();
            int Qbankid = list.get(i).getQbankId();
            if(daoq.findQbankById(Qbankid) == null){
                qbank.setQbankId(Qbankid);
                qbank.setName(QbankName);
                qbank.setMultipleChoiceNum(0);
                qbank.setSingleChoiceNum(0);
                qbank.setBlanksNum(0);
                daoq.addQbank(qbank);
            }
        }
        return daos.addSinglechoices(list);
    }
    /**
     * @Author: baitao
     * @Description:添加填空题
     * @Param:
     * @Return:
     * @Date: 2019-12-24
     */
    public Boolean addBlankTests(List<Blanktest> list,String QbankName){
        for(int i=0;i<list.size();i++){
            Qbank qbank = new Qbank();
            int Qbankid = list.get(i).getQbankId();
            if(daoq.findQbankById(Qbankid) == null){
                qbank.setQbankId(Qbankid);
                qbank.setName(QbankName);
                qbank.setMultipleChoiceNum(0);
                qbank.setSingleChoiceNum(0);
                qbank.setBlanksNum(0);
                daoq.addQbank(qbank);
            }
        }
        return daob.addBlanktests(list);
    }

}
