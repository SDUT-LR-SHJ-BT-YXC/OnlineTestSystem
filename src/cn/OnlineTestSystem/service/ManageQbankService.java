package cn.OnlineTestSystem.service;

import cn.OnlineTestSystem.daoimpl.QbankDAOImpl;
import cn.OnlineTestSystem.domain.Qbank;

/**
 * @ClassName ManageQbankService
 * @Desciption 关于题库的增删改查操作
 * @Author liurong
 * @Date 2019/12/17  15:58
 * @Version 1.0
 **/
public class ManageQbankService {
    private QbankDAOImpl qbankdaoImpl = new QbankDAOImpl();

    /*
     * 根据题库id删除对应题库
     * @Param: [qbank_id]
     * @Return: boolean
     * @Author: liurong
     * @Date: 2019/12/17 16:01
     */
    public boolean DelQbank(int qbank_id){
        return qbankdaoImpl.delQbankById(qbank_id);
    }

    /*
     * 增加题库
     * @Param: [qname]
     * @Return: boolean
     * @Author: liurong
     * @Date: 2019/12/18 20:51
     */
    public boolean AddQbank(String qname){
        Qbank qbank = new Qbank();
        qbank.setName(qname);
        qbank.setSingleChoiceNum(0);
        qbank.setMultipleChoiceNum(0);
        qbank.setBlanksNum(0);
        return qbankdaoImpl.addQbank(qbank);
    }

    /*
     * 根据id查找题库信息
     * @Param: [qbank_id]
     * @Return: cn.OnlineTestSystem.domain.Qbank
     * @Author: liurong
     * @Date: 2019/12/19 16:17
     */
    public Qbank getQbankById(int qbank_id){
        Qbank qbank = new Qbank();
        qbank = qbankdaoImpl.findQbankById(qbank_id);
        return qbank;
    }

    public boolean UpdateQname(int qbank_id,String name){
        Qbank qbank = new Qbank();
        qbank = qbankdaoImpl.findQbankById(qbank_id);
        qbank.setName(name);

        return qbankdaoImpl.modifyQbank(qbank);
    }
}
