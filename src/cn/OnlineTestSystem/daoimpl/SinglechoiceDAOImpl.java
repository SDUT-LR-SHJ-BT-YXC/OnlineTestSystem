package cn.OnlineTestSystem.daoimpl;

import cn.OnlineTestSystem.dao.BaseDAO;
import cn.OnlineTestSystem.dao.SinglechoiceDAO;
import cn.OnlineTestSystem.domain.Singlechoice;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName SinglechoiceDAOImpl
 * @Desciption TODO
 * @Author shangjin
 * @Date 2019-11-29 16:21
 * @Version 1.0
 **/
public class SinglechoiceDAOImpl extends BaseDAO<Singlechoice> implements SinglechoiceDAO {
    @Override
    /**
     * @Author: Shangjin
     * @Description:添加一道单选题
     * @Param:
     * @Return:
     * @Date: 21:56 2019-11-29
     */
    public Boolean addSinglechoice(Singlechoice singlechoice) {
        String sql = "INSERT INTO singlechoice(question_text, answer1, answer2, answer3, answer4, std_answer, qbank_id) VALUES (?,?,?,?,?,?,?)";
        try {
            this.update(sql, singlechoice.getQuestionText(), singlechoice.getAnswer1(), singlechoice.getAnswer2(),
                    singlechoice.getAnswer3(), singlechoice.getAnswer4(), singlechoice.getStdAnswer(), singlechoice.getQbankId());
            return  true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    /**
     * @Author: Shangjin
     * @Description:批量添加多选题
     * @Param:
     * @Return:
     * @Date: 21:57 2019-11-29
     */
    public Boolean addSinglechoices(List<Singlechoice> list) {
        Iterator<Singlechoice> it = list.iterator();
        while(it.hasNext()){
            if(!this.addSinglechoice(it.next())){
                return  false;
            }
        }
        return true;
    }

    @Override
    /**
     * @Author: Shangjin
     * @Description:通过单选题ID查找某道单选题
     * @Param:
     * @Return:
     * @Date: 21:57 2019-11-29
     */
    public Boolean delSinglechoiceById(Integer id) {
        String sql = "DELETE FROM singlechoice WHERE squestion_id=?";
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
     * @Description:根据科目ID查找所有此科目的单选题
     * @Param:
     * @Return:
     * @Date: 21:58 2019-11-29
     */
    public Boolean delSinglechoicesByQbankId(Integer id) {
        String sql = "DELETE FROM singlechoice WHERE qbank_id=?";
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
     * @Description:修改某道单选题，以此单选题的ID为依据
     * @Param:
     * @Return:
     * @Date: 21:58 2019-11-29
     */
    public Boolean modifySinglechoice(Singlechoice singlechoice) {
        String sql = "UPDATE singlechoice SET question_text=?, answer1=?, answer2=?, answer3=?, answer4=?, std_answer=?,qbank_id=? WHERE squestion_id=?";
        try {
            this.update(sql, singlechoice.getQuestionText(), singlechoice.getAnswer1(), singlechoice.getAnswer2(),
                    singlechoice.getAnswer3(), singlechoice.getAnswer4(), singlechoice.getStdAnswer(), singlechoice.getQbankId(),
                    singlechoice.getSquestionId());
            return  true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    /**
     * @Author: Shangjin
     * @Description:通过某道单选题ID查找一道单选题
     * @Param:
     * @Return:
     * @Date: 21:58 2019-11-29
     */
    public Singlechoice findSinglechoiceById(Integer id) {
        String sql = "SELECT * FROM singlechoice WHERE squestion_id=?";
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
     * @Description:通过科目ID查找此科目的所有单选题
     * @Param:
     * @Return:
     * @Date: 21:59 2019-11-29
     */
    public List<Singlechoice> findSinglechoiceByQbankId(Integer id) {
        String sql = "SELECT * FROM singlechoice WHERE qbank_id=?";
        try {
            return this.getForList(sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Author: Shangjin
     * @Description:从数据库中筛选某个区间的习题
     * @Param:
     * @Return:
     * @Date: 22:51 2019-12-03
     */
    @Override
    public List<Singlechoice> findRandomSinglechoices(Integer qbankId, Integer n) {
        String sql = "SELECT * FROM singlechoice WHERE qbank_id=? ORDER BY  RAND() LIMIT ?";
        try {
            return this.getForList(sql,qbankId, n);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }
}
