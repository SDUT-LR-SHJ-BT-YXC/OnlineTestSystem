package cn.OnlineTestSystem.service;

import cn.OnlineTestSystem.daoimpl.AdminDAOImpl;
import cn.OnlineTestSystem.domain.Admin;

/**
 * @ClassName AdminService
 * @Desciption 增加、删除管理员
 * @Author liurong
 * @Date 2019/12/14  10:41
 * @Version 1.0
 **/
public class AdminService {
    private AdminDAOImpl adminimpl = new AdminDAOImpl();

    /*
     * 增加一个管理员
     * @Param: [admin]
     * @Return: boolean
     * @Author: liurong
     * @Date: 2019/12/14 10:46
     */
    public boolean AddAdmin(Admin admin){

        boolean suc = false;
        suc = adminimpl.addAdmin(admin);
        return suc;
    }

    /*
     * 通过管理员id删除管理员
     * @Param: [Admin_id]
     * @Return: boolean
     * @Author: liurong
     * @Date: 2019/12/14 10:48
     */
    public boolean DelAdminById(int Admin_id){
        boolean suc = false;
        suc = adminimpl.delAdmin(Admin_id);
        return suc;
    }
}
