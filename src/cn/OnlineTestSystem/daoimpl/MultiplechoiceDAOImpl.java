package cn.OnlineTestSystem.daoimpl;

import cn.OnlineTestSystem.dao.BaseDAO;
import cn.OnlineTestSystem.dao.MultiplechoiceDAO;
import cn.OnlineTestSystem.domain.Blanktest;
import cn.OnlineTestSystem.domain.Multiplechoice;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName MultiplechoiceDAOImpl
 * @Desciption TODO
 * @Author shangjin
 * @Date 2019-11-29 16:14
 * @Version 1.0
 **/
public class MultiplechoiceDAOImpl extends BaseDAO<Multiplechoice> implements MultiplechoiceDAO {
    @Override
    /**
     * @Author: Shangjin
     * @Description:根据多选题ID查找某道多选题
     * @Param:
     * @Return:
     * @Date: 21:43 2019-11-29
     */
    public Multiplechoice findMultiplechoiceById(Integer id) {
        String sql = "SELECT * FROM multiplechoice WHERE mquestion_id=?";
        try {
            return this.get(sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    /**
     * @Author: Shangjin
     * @Description:根据题库ID查找某个科目的全部填空题
     * @Param:
     * @Return:
     * @Date: 21:44 2019-11-29
     */
    public List<Multiplechoice> findMultiplechoicesByQbankId(Integer id) {
        String sql = "SELECT * FROM multiplechoice WHERE qbank_id=?";
        try {
            return this.getForList(sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    /**
     * @Author: Shangjin
     * @Description:添加单个多选题
     * @Param:
     * @Return:
     * @Date: 21:44 2019-11-29
     */
    public Boolean addMultiplechoice(Multiplechoice multiplechoice) {
        String sql = "INSERT INTO multiplechoice(question_text, answer1, answer2, answer3, answer4, std_answer," +
                "qbank_id) VALUES(?,?,?,?,?,?,?)";
        try {
            this.update(sql, multiplechoice.getQuestionText(), multiplechoice.getAnswer1(), multiplechoice.getAnswer2()
            ,multiplechoice.getAnswer3(), multiplechoice.getAnswer4(), multiplechoice.getStdAnswer(), multiplechoice.getQbankId());
            return  true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  false;
    }

    @Override
    /**
     * @Author: Shangjin
     * @Description:批量添加多选题
     * @Param:
     * @Return:
     * @Date: 21:45 2019-11-29
     */
    public Boolean addMultiplechoices(List<Multiplechoice> list) {
        Iterator<Multiplechoice> it = list.iterator();
        while(it.hasNext()){
            if(!addMultiplechoice(it.next())){
                return  false;
            }
        }
        return  true;
    }

    @Override
    /**
     * @Author: Shangjin
     * @Description:根据多选题ID删除某道多选题
     * @Param:
     * @Return:
     * @Date: 21:45 2019-11-29
     */
    public Boolean delMultiplechoiceById(Integer id) {
        String sql = "DELETE  FROM multiplechoice WHERE mquestion_id=?";
        try {
            this.update(sql, id);
            return  true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    /**
     * @Author: Shangjin
     * @Description:根据科目ID删除所有某科目多选题
     * @Param:
     * @Return:
     * @Date: 21:46 2019-11-29
     */
    public Boolean delMultiplechoicesByQbankId(Integer id) {
        String sql = "DELETE  FROM multiplechoice WHERE qbank_id=?";
        try {
            this.update(sql, id);
            return  true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    /**
     * @Author: Shangjin
     * @Description:修改某道多选题，以多选题ID为依据
     * @Param:
     * @Return:
     * @Date: 21:46 2019-11-29
     */
    public Boolean modifyMultiplechoice(Multiplechoice test) {
        String sql = "UPDATE multiplechoice SET question_text=?,answer1=?,answer2=?,answer3=?,answer4=?,std_answer=?,qbank_id=? WHERE mquestion_id=?";
        try {
            this.update(sql, test.getQuestionText(), test.getAnswer1(), test.getAnswer2()
            ,test.getAnswer3(), test.getAnswer4(), test.getStdAnswer(), test.getQbankId(), test.getMquestionId());
            return  true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
