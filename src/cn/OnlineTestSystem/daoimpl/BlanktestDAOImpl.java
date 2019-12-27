package cn.OnlineTestSystem.daoimpl;

import cn.OnlineTestSystem.dao.BaseDAO;
import cn.OnlineTestSystem.dao.BlanktestDAO;
import cn.OnlineTestSystem.domain.Blanktest;
import cn.OnlineTestSystem.domain.Multiplechoice;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName BlanktestDAOImpl
 * @Desciption TODO
 * @Author shangjin
 * @Date 2019-11-29 16:14
 * @Version 1.0
 **/
public class BlanktestDAOImpl extends BaseDAO<Blanktest> implements BlanktestDAO {
    @Override
    /**
     * @Author: Shangjin
     * @Description:根据填空题ID查找填空题
     * @Param:
     * @Return:
     * @Date: 21:39 2019-11-29
     */
    public Blanktest findBlanktestById(Integer id) {
        String sql = "SELECT * FROM blanktest WHERE bquestion_id=?";
        try {
            return this.get(sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }

    @Override
    /**
     * @Author: Shangjin
     * @Description:根据科目ID查找填空题
     * @Param:
     * @Return:
     * @Date: 21:39 2019-11-29
     */
    public List<Blanktest> findBlanksByQbankId(Integer id) {
        String sql = "SELECT * FROM blanktest WHERE qbank_id=?";
        try {
            return  this.getForList(sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    /**
     * @Author: Shangjin
     * @Description:新增单个填空题
     * @Param:
     * @Return:
     * @Date: 21:40 2019-11-29
     */
    public Boolean addBlanktest(Blanktest test) {
        String sql = "INSERT INTO blanktest(question_text, std_answer, qbank_id) VALUES (?,?,?)";
        try {
            this.update(sql, test.getQuestionText(), test.getStdAnswer(), test.getQbankId());
            return  true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    /**
     * @Author: Shangjin
     * @Description:批量添加添加填空题
     * @Param:
     * @Return:
     * @Date: 21:40 2019-11-29
     */
    public Boolean addBlanktests(List<Blanktest> list) {
        Iterator<Blanktest> it = list.iterator();
        while(it.hasNext()){
            if(!this.addBlanktest(it.next())){
                return false;
            }
        }
        return true;
    }

    @Override
    /**
     * @Author: Shangjin
     * @Description:根据填空题ID删除填空题
     * @Param:
     * @Return:
     * @Date: 21:41 2019-11-29
     */
    public Boolean delBlanktestById(Integer id) {
        String sql = "DELETE FROM blanktest WHERE bquestion_id=?";
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
     * @Description:根据科目ID删除某一科目的所有填空题
     * @Param:
     * @Return:
     * @Date: 21:41 2019-11-29
     */
    public Boolean delBlanktestsByQbankId(Integer id) {
        String sql = "DELETE FROM blanktest WHERE qbank_id=?";
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
     * @Description:修改某道填空题，以本填空题ID为依据
     * @Param:
     * @Return:
     * @Date: 21:43 2019-11-29
     */
    public Boolean modifyBlanktest(Blanktest test) {
        String sql = "UPDATE blanktest SET question_text=?,std_answer=?,qbank_id=? WHERE bquestion_id=?";
        try {
            this.update(sql, test.getQuestionText(), test.getStdAnswer(), test.getQbankId(), test.getBquestionId());
            return  true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * @Author: Shangjin
     * @Description:从数据库中随机筛选n题目
     * @Param:
     * @Return:
     * @Date: 22:48 2019-12-03
     */
    @Override
    public List<Blanktest> findRandomBlanks(Integer qbankId, Integer n) {
        String sql = "SELECT * FROM blanktest WHERE qbank_id=? ORDER BY  RAND() LIMIT ?";
        try {
            return this.getForList(sql, qbankId, n);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }

    @Override
    /**
     * @Author: yinxiaochen
     * @Description: 获取填空表行数
     * @Param:
     * @Return:
     * @Date: 07:29 2019-12-27
     */
    public int getBlankCount() {
        String sql = "SELECT COUNT(*) FROM blanktest";
        try {
            Long c =  this.getForValue(sql);
            return c.intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    /**
     * @Author: yinxiaochen
     * @Description: 搜索获取有限填空信息
     * @Param: int start, int limit
     * @Return: List<Blanktest>
     * @Date: 7:32 2019-12-27
     */
    public List<Blanktest> getLimitedBlank(int start, int limit, String search) {
        String sql = "SELECT * FROM blanktest INNER JOIN qbank ON qbank.qbank_id=blanktest.qbank_id WHERE question_text LIKE '%" + search + "%' ORDER BY qbank.qbank_id LIMIT " + start + "," + limit;
        try {
            return this.getForList(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }

    @Override
    /**
     * create by: yinxiaochen
     * description: 按id删除填空题
     * create time: 06:15 2019-12-27
     *
     */
    public void delBlank(int id) {
        String sql = "DELETE FROM blanktest WHERE bquestion_id=?";
        try {
            this.update(sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
