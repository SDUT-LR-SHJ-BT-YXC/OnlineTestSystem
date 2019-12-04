package cn.OnlineTestSystem.service;

import cn.OnlineTestSystem.dao.MultiplechoiceDAO;
import cn.OnlineTestSystem.daoimpl.BlanktestDAOImpl;
import cn.OnlineTestSystem.daoimpl.MultiplechoiceDAOImpl;
import cn.OnlineTestSystem.daoimpl.SinglechoiceDAOImpl;
import cn.OnlineTestSystem.domain.ExaminationPaper;

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
    private Integer blankTestNum;
    private Integer singleTestNum;
    private Integer multipleChoiceTestNum;
    private Integer qbankId;
    public ExaminationService(Integer blankTestNum, Integer singleTestNum, Integer multipleChoiceTestNum, Integer qbankId) {
        this.blank = new BlanktestDAOImpl();
        this.single = new SinglechoiceDAOImpl();
        this.multiple = new MultiplechoiceDAOImpl();
        this.blankTestNum = blankTestNum;
        this.singleTestNum = singleTestNum;
        this.multipleChoiceTestNum = multipleChoiceTestNum;
        this.qbankId = qbankId;
    }

    /**
     * @Author: Shangjin
     * @Description:根据传入的科目id，生成一张试卷
     * @Param:
     * @Return:
     * @Date: 22:34 2019-12-03
     */
    public ExaminationPaper createExaminationPaper(){
        ExaminationPaper paper = new ExaminationPaper();

        return null;
    }
}
