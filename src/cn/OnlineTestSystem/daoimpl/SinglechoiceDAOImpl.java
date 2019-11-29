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
    public List<Singlechoice> findSinglechoiceByQbankId(Integer id) {
        String sql = "SELECT * FROM singlechoice WHERE qbank_id=?";
        try {
            return this.getForList(sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
