package cn.OnlineTestSystem.service;

import cn.OnlineTestSystem.daoimpl.QbankDAOImpl;
import cn.OnlineTestSystem.domain.Qbank;

import java.util.List;

/**
 * @ClassName QbankService
 * @Desciption TODO
 * @Author shangjin
 * @Date 2019-12-13 14:57
 * @Version 1.0
 **/
public class QbankService {
    private QbankDAOImpl dao;

    public QbankService() {
        dao = new QbankDAOImpl();
    }

    /**
     * @Author: Shangjin
     * @Description: 获取所有题库信息
     * @Param:
     * @Return:
     * @Date: 14:59 2019-12-13
     */
    public List<Qbank> getAllQbank(){
        return  dao.getAllQbank();
    }

    /**
     * @Author: Shangjin
     * @Description: 根据id获取相应题库
     * @Param:
     * @Return:
     * @Date: 15:00 2019-12-13
     */
    public Qbank findQbankById(Integer id){
        return  dao.findQbankById(id);
    }

    /**
     * @Author: Shangjin
     * @Description: 根据名字获取相应题库
     * @Param:
     * @Return:
     * @Date: 15:02 2019-12-13
     */
    public Qbank findQbankByName(String name){
        return dao.findQbankByName(name);
    }

    /**
     * @Author: Shangjin
     * @Description: 修改题库信息，被修改的题库ID为传入Qbank参数的ID属性
     * @Param:
     * @Return:
     * @Date: 15:03 2019-12-13
     */
    public boolean modifyQbank(Qbank qbank){
        return  dao.modifyQbank(qbank);
    }

    /**
     * @Author: Shangjin
     * @Description: 根据题库ID删除某题库
     * @Param:
     * @Return:
     * @Date: 15:05 2019-12-13
     */
    public boolean delQbankById(Integer id){
        return  dao.delQbankById(id);
    }

    /**
     * @Author: Shangjin
     * @Description: 新建一个题库
     * @Param:
     * @Return:
     * @Date: 15:06 2019-12-13
     */
    public boolean addQbank(Qbank qbank){
        return  dao.addQbank(qbank);
    }

    /**
     * @Author: Shangjin
     * @Description: 获取题库数目
     * @Param:
     * @Return:
     * @Date: 15:06 2019-12-27
     */
    public Integer getQbankNum(){
        return  dao.getQbankNum();
    }

    /**
     * @Author: Shangjin
     * @Description: 获取限定区间的题库信息
     * @Param:
     * @Return:
     * @Date: 15:06 2019-12-27
     */
    public List<Qbank> getLimitedQbank(int page, int limit){
        int start = limit * (page - 1);
        return dao.getLimitedQband(start, limit);
    }
}
