package cn.OnlineTestSystem.service;

import cn.OnlineTestSystem.daoimpl.QbankDAOImpl;

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
}
