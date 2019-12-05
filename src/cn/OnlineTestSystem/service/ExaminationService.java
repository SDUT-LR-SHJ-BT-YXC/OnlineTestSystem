package cn.OnlineTestSystem.service;

import cn.OnlineTestSystem.dao.MultiplechoiceDAO;
import cn.OnlineTestSystem.daoimpl.BlanktestDAOImpl;
import cn.OnlineTestSystem.daoimpl.MultiplechoiceDAOImpl;
import cn.OnlineTestSystem.daoimpl.QbankDAOImpl;
import cn.OnlineTestSystem.daoimpl.SinglechoiceDAOImpl;
import cn.OnlineTestSystem.domain.Blanktest;
import cn.OnlineTestSystem.domain.ExaminationPaper;
import cn.OnlineTestSystem.domain.Qbank;
import cn.OnlineTestSystem.domain.Singlechoice;

import java.util.List;

/**
 * @ClassName ExaminationService
 * @Desciption TODO
 * @Author shangjin
 * @Date 2019-12-03 22:25
 * @Version 1.0
 **/
public class ExaminationService {
    private MultiplechoiceDAOImpl multiple;
    private SinglechoiceDAOImpl single;
    private BlanktestDAOImpl blank;
    private QbankDAOImpl qbankDAO;
    private Integer blankTestNum;
    private Integer singleTestNum;
    private Integer multipleChoiceTestNum;
    private Integer qbankId;

    public ExaminationService() {
        this.blank = new BlanktestDAOImpl();
        this.single = new SinglechoiceDAOImpl();
        this.multiple = new MultiplechoiceDAOImpl();
        this.qbankDAO = new QbankDAOImpl();
    }

    /**
     * @Author: Shangjin
     * @Description:根据传入的科目id,各个题的数目，生成一张试卷
     * @Param:
     * @Return:
     * @Date: 22:34 2019-12-03
     */
    public ExaminationPaper createExaminationPaper(Integer qbankId, Integer blankTestNum, Integer singleTestNum, Integer multipleChoiceTestNum){
        ExaminationPaper paper = new ExaminationPaper();
        this.blankTestNum = blankTestNum;
        this.singleTestNum = singleTestNum;
        this.multipleChoiceTestNum = multipleChoiceTestNum;
        this.qbankId = qbankId;
        Qbank qbank = qbankDAO.findQbankById(qbankId);
        Integer Bnum = qbank.getBlanksNum();
        Integer Snum = qbank.getSingleChoiceNum();
        Integer Mnum = qbank.getMultipleChoiceNum();
        if(Bnum <= blankTestNum){
            paper.setBlanktests(blank.findBlanksByQbankId(qbankId));
        }
        else{
            paper.setBlanktests(blank.findRandomBlanks(qbankId, blankTestNum));
        }
        if(Snum <= singleTestNum){
            paper.setSinglechoices(single.findSinglechoiceByQbankId(qbankId));
        }
        else{
            paper.setSinglechoices(single.findRandomSinglechoices(qbankId, singleTestNum));
        }
        if(Mnum <= multipleChoiceTestNum){
            paper.setMultiplechoices(multiple.findMultiplechoicesByQbankId(qbankId));
        }
        else{
            paper.setMultiplechoices(multiple.findRandomChoices(qbankId, multipleChoiceTestNum));
        }
        return  paper;
    }
    /**
     * @Author: Shangjin
     * @Description:获取所有科目信息
     * @Param:
     * @Return:
     * @Date: 19:45 2019-12-04
     */
    public List<Qbank> getAllQbank(){
        return qbankDAO.getAllQbank();
    }
}
