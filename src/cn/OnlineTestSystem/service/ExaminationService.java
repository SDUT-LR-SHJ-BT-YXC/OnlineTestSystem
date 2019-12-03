package cn.OnlineTestSystem.service;

import cn.OnlineTestSystem.dao.MultiplechoiceDAO;
import cn.OnlineTestSystem.daoimpl.BlanktestDAOImpl;
import cn.OnlineTestSystem.daoimpl.MultiplechoiceDAOImpl;
import cn.OnlineTestSystem.daoimpl.SinglechoiceDAOImpl;
import cn.OnlineTestSystem.domain.ExaminationPaper;

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
    /**
     * @Author: Shangjin
     * @Description:根据传入的科目id，生成一张试卷
     * @Param:
     * @Return:
     * @Date: 22:34 2019-12-03
     */
    public ExaminationPaper createExaminationPaper(Integer id){
        return  null;
    }
}
