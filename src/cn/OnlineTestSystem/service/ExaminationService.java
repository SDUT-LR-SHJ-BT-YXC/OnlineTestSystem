package cn.OnlineTestSystem.service;

import cn.OnlineTestSystem.dao.MultiplechoiceDAO;
import cn.OnlineTestSystem.daoimpl.*;
import cn.OnlineTestSystem.domain.*;
import java.sql.Timestamp;
import java.util.ArrayList;
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
    public ExaminationPaper createExaminationPaper(Integer userid, Integer qbankId, Integer blankTestNum, Integer singleTestNum, Integer multipleChoiceTestNum){
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
        paper.setSubject(qbankId);
        paper.setUserid(userid);
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

    /**
     * @Author: Shangjin
     * @Description:生成错题记录， 生成成绩记录
     * @Param:
     * @Return:
     * @Date: 17:17 2019-12-07
     */
    public Scoreanalyse getScore(ExaminationPaper paper, ArrayList<String> rb, ArrayList<String> rs, ArrayList<String> rm){
        List<Blanktest> btest = paper.getBlanktests();
        List<Singlechoice> stest = paper.getSinglechoices();
        List<Multiplechoice> mtest = paper.getMultiplechoices();
        WronganswerrecordDAOImpl recordDAO = new WronganswerrecordDAOImpl();

        int score = 0;
        //批改填空题
        java.sql.Timestamp time = new java.sql.Timestamp(System.currentTimeMillis());
        for(int i = 0; i < btest.size(); i++){
            Blanktest test = btest.get(i);
            if(test.getStdAnswer() == rb.get(i)){
                score += 2;
            }else{
                Wronganswerrecord record = new Wronganswerrecord(test.getBquestionId(), rb.get(i),time, paper.getUserid());
                recordDAO.addWronganswerrecord(record);
            }
        }

        //批改选择题
        for(int i = 0; i < stest.size(); i++){
            Singlechoice test = stest.get(i);
            if(test.getStdAnswer() == rs.get(i)){
                score += 3;
            }else{
                Wronganswerrecord record = new Wronganswerrecord(test.getSquestionId(), rb.get(i), time, paper.getUserid());
                recordDAO.addWronganswerrecord(record);
            }
        }

        //批改多选题
        for(int i = 0; i < mtest.size(); i++){
            Multiplechoice test = mtest.get(i);
            if(test.getStdAnswer() == rm.get(i)){
                score += 5;
            }else{
                Wronganswerrecord record = new Wronganswerrecord(test.getMquestionId(), rb.get(i), time, paper.getUserid());
                recordDAO.addWronganswerrecord(record);
            }
        }

        //添加成绩记录
        Scoreanalyse scoreanalyse = new Scoreanalyse(score, time, paper.getUserid(), paper.getSubject());
        ScoreanalyseDAOImp scoreanalyseDAOImp = new ScoreanalyseDAOImp();
        scoreanalyseDAOImp.addScoreanalyse(scoreanalyse);
        return  scoreanalyse;
    }
}
