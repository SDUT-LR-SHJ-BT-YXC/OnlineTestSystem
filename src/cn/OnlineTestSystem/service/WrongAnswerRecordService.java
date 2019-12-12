package cn.OnlineTestSystem.service;

import cn.OnlineTestSystem.daoimpl.QbankDAOImpl;
import cn.OnlineTestSystem.daoimpl.WronganswerrecordDAOImpl;
import cn.OnlineTestSystem.domain.*;
import cn.OnlineTestSystem.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

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
            if(Was.get(i).getQuestion_id() >= 1 && Was.get(i).getQuestion_id() < 30000){
                s++;  //单选题错题数加一

            } else if(Was.get(i).getQuestion_id() >= 30000 && Was.get(i).getQuestion_id() < 60000){
                m++;  //多选错题数加一

            } else {
                b++;

            }

        }
        sumwa.add(s);
        sumwa.add(m);
        sumwa.add(b);
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
        sumqs.add(s);
        sumqs.add(m);
        sumqs.add(b);
        return sumqs;
    }

    /*
     * 返回所有的题库
     * @Param: []
     * @Return: java.util.List<cn.OnlineTestSystem.domain.Qbank>
     * @Author: liurong
     * @Date: 2019/12/11 11:58
     */
    public List<Qbank> getAllQbank(){
        return qbankdimpl.getAllQbank();
    }

    /*
     * 返回某个题库的所有单选题错题记录
     * @Param: [qbank_id, user_id]
     * @Return: java.util.List<cn.OnlineTestSystem.domain.Wronganswerrecord>
     * @Author: liurong
     * @Date: 2019/12/12 13:50
     */
    public List<ShowWASrecord> getWASrecordsByQid(int qbank_id, int user_id){
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        List<ShowWASrecord> swa = new ArrayList<>();

        String sql = "select w.wrong_answer,w.time,t.answer1,t.answer2,t.answer3,t.answer4,t.question_text from wronganswerrecord w join (select squestion_id,question_text,answer1,answer2,answer3,answer4 from singlechoice where qbank_id = ?) t on w.question_id = t.squestion_id where user_id = ?";
        //        //System.out.println(sql);
        try{

            swa = queryRunner.query(sql, new BeanListHandler<ShowWASrecord>(ShowWASrecord.class),qbank_id,user_id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return swa;
    }

    /*
     * 返回某个题库的所有多选题错题记录
     * @Param: [qbank_id, user_id]
     * @Return: java.util.List<cn.OnlineTestSystem.domain.ShowWAMrecord>
     * @Author: liurong
     * @Date: 2019/12/12 22:06
     */
    public List<ShowWAMrecord> getWAMrecordByQid(int qbank_id,int user_id){
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        List<ShowWAMrecord> swa = new ArrayList<>();
        String sql = "select w.wrong_answer,w.time,t.answer1,t.answer2,t.answer3,t.answer4,t.question_text from wronganswerrecord w join (select mquestion_id,question_text,answer1,answer2,answer3,answer4 from multiplechoice where qbank_id = ?) t on w.question_id = t.mquestion_id where user_id = ?";
        //String sql = "select w.wrong_answer,w.time from wronganswerrecord w join (select mquestion_id,question_text,answer1,answer2,answer3,answer4 from multiplechoice where qbank_id = ?) t on w.question_id = t.mquestion_id where user_id = ?";
        try{

            swa = queryRunner.query(sql, new BeanListHandler<ShowWAMrecord>(ShowWAMrecord.class),qbank_id,user_id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return swa;
    }

    /*
     * 返回某个题库的所有填空题错题记录
     * @Param: [qbank_id, user_id]
     * @Return: java.util.List<cn.OnlineTestSystem.domain.ShowWABrecord>
     * @Author: liurong
     * @Date: 2019/12/12 22:09
     */
    public List<ShowWABrecord> getWABrecordByQid(int qbank_id,int user_id){
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        List<ShowWABrecord> swa = new ArrayList<>();
        String sql = "select w.wrong_answer,w.time,t.question_text from wronganswerrecord w join (select bquestion_id,question_text from blanktest where qbank_id = ?) t on w.question_id = t.bquestion_id where user_id = ?";

        try{

            swa = queryRunner.query(sql, new BeanListHandler<ShowWABrecord>(ShowWABrecord.class),qbank_id,user_id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return swa;
    }
}
