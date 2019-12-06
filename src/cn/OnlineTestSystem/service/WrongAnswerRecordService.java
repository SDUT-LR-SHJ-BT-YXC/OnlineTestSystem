package cn.OnlineTestSystem.service;

import cn.OnlineTestSystem.daoimpl.QbankDAOImpl;
import cn.OnlineTestSystem.daoimpl.WronganswerrecordDAOImpl;
import cn.OnlineTestSystem.domain.Qbank;
import cn.OnlineTestSystem.domain.Wronganswerrecord;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName WrongAnswerRecordService
 * @Desciption 关于错题记录的调用方法
 * @Author liurong
 * @Date 2019/12/6  13:25
 * @Version 1.0
 **/
public class WrongAnswerRecordService {

    /*
     *  返回题库总数目
     * @Param: []
     * @Return: int
     * @Author: liurong
     * @Date: 2019/12/6 13:26
     */
    public QbankDAOImpl qbankdimpl = new QbankDAOImpl();
    public WronganswerrecordDAOImpl WAimpl = new WronganswerrecordDAOImpl();

    public int getSumQbank(){
        return qbankdimpl.getAllQbank().size();
    }

    /*
     * 根据用户ID查找每个类型单独的错题总数
     * @Param: [user_id]
     * @Return: java.util.List<java.lang.Integer>
     * @Author: liurong
     * @Date: 2019/12/6 19:57
     */
    public List<Integer> getSumWA(int user_id){
        List<Wronganswerrecord> Was = new ArrayList<>();
        List<Integer> sumwa = new ArrayList<>();
        int s = 0;
        int m = 0;
        int b = 0;
        Was = WAimpl.findWronganswerrecordsByUserId(user_id);
        for(int i = 0; i < Was.size(); i++){
            if(Was.get(i).getQuestionId() >= 1 && Was.get(i).getQuestionId() < 30000){
                s++;  //单选题错题数加一
                sumwa.set(0,s);
            } else if(Was.get(i).getQuestionId() >= 30000 && Was.get(i).getQuestionId() < 60000){
                m++;  //多纤体错题数加一
                sumwa.set(1,m);
            } else {
                b++;
                sumwa.set(2, b);
            }
        }
        return sumwa;
    }

    /*
     * 获得题库中单选题、多选题、填空题总数
     * @Param: []
     * @Return: java.util.List<java.lang.Integer>
     * @Author: liurong
     * @Date: 2019/12/6 20:14
     */
    public List<Integer> getSumQ(){
        List<Integer> sumqs = new ArrayList<>();
        int s = 0;
        int m = 0;
        int b = 0;
        List<Qbank> qbanks = new ArrayList<>();
        qbanks = qbankdimpl.getAllQbank();
        for(int i = 0; i < qbanks.size(); i++){
            s += qbanks.get(i).getSingleChoiceNum();
            m += qbanks.get(i).getMultipleChoiceNum();
            b += qbanks.get(i).getBlanksNum();
        }
        sumqs.set(0,s);
        sumqs.set(1,m);
        sumqs.set(2,b);
        return sumqs;
    }


}
