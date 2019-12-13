package cn.OnlineTestSystem.service;

import cn.OnlineTestSystem.daoimpl.BlanktestDAOImpl;
import cn.OnlineTestSystem.daoimpl.MultiplechoiceDAOImpl;
import cn.OnlineTestSystem.daoimpl.QbankDAOImpl;
import cn.OnlineTestSystem.daoimpl.SinglechoiceDAOImpl;
import cn.OnlineTestSystem.domain.Blanktest;
import cn.OnlineTestSystem.domain.Multiplechoice;
import cn.OnlineTestSystem.domain.Qbank;
import cn.OnlineTestSystem.domain.Singlechoice;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName DownloadService
 * @Desciption 实现题库动态下载
 * @Author liurong
 * @Date 2019/12/13  20:07
 * @Version 1.0
 **/
public class DownloadService {
    private QbankDAOImpl qbankimpl = new QbankDAOImpl();
    /*
     * 返回题库已有题库
     * @Param: []
     * @Return: java.util.List<cn.OnlineTestSystem.domain.Qbank>
     * @Author: liurong
     * @Date: 2019/12/13 20:10
     */
    public List<Qbank> getAllQbank(){
        List<Qbank> qbanks = new ArrayList<>();
        qbanks = qbankimpl.getAllQbank();
        return qbanks;
    }

    /*
     * 根据题库ID查找所有的单选题
     * @Param: [qbank_id]
     * @Return: java.util.List<cn.OnlineTestSystem.domain.Singlechoice>
     * @Author: liurong
     * @Date: 2019/12/13 20:23
     */
    public List<Singlechoice> getALLSingleByQid(int qbank_id){
        List<Singlechoice> singlechoices = new ArrayList<>();
        SinglechoiceDAOImpl singlechoiceimpl = new SinglechoiceDAOImpl();
        singlechoices = singlechoiceimpl.findSinglechoiceByQbankId(qbank_id);
        return singlechoices;
    }

    /*
     * 根据题库ID查找所有的多选题
     * @Param: [qbank_id]
     * @Return: java.util.List<cn.OnlineTestSystem.domain.Multiplechoice>
     * @Author: liurong
     * @Date: 2019/12/13 20:24
     */
    public List<Multiplechoice> getALLMultipleByQid(int qbank_id){
        List<Multiplechoice> multiplechoices = new ArrayList<>();
        MultiplechoiceDAOImpl multiplechoiceDAO = new MultiplechoiceDAOImpl();
        multiplechoices = multiplechoiceDAO.findMultiplechoicesByQbankId(qbank_id);
        return multiplechoices;
    }

    /*
     * 根据题库ID查找所有的填空题
     * @Param: [qbank_id]
     * @Return: java.util.List<cn.OnlineTestSystem.domain.Blanktest>
     * @Author: liurong
     * @Date: 2019/12/13 20:26
     */
    public List<Blanktest> getALLBlankByQid(int qbank_id){
        List<Blanktest> blanktests = new ArrayList<>();
        BlanktestDAOImpl blanktestDAO = new BlanktestDAOImpl();
        blanktests = blanktestDAO.findBlanksByQbankId(qbank_id);
        return blanktests;
    }
}
