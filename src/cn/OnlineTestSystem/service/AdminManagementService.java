package cn.OnlineTestSystem.service;

import cn.OnlineTestSystem.dao.AdminDAO;
import cn.OnlineTestSystem.daoimpl.AdminDAOImpl;
import cn.OnlineTestSystem.domain.Admin;

import java.util.List;

/**
 * @ClassName AdminManagementService
 * @Desciption TODO
 * @Author shangjin
 * @Date 2019-12-03 12:35
 * @Version 1.0
 **/
public class AdminManagementService {
    private AdminDAO adminDAO;

    public AdminManagementService() {
        this.adminDAO = new AdminDAOImpl();
    }
    /**
     * @Author: Shangjin
     * @Description:添加一个新的管理员
     * @Param:
     * @Return:
     * @Date: 12:41 2019-12-03
     */
    public boolean addAdmin(Admin admin){
        return  adminDAO.addAdmin(admin);
    }

    /**
     * @Author: Shangjin
     * @Description:通过id查找一个管理员
     * @Param:
     * @Return:
     * @Date: 12:41 2019-12-03
     */
    public Admin findAdminById(Integer id){
        return  adminDAO.findAdminById(id);
    }

    /**
     * @Author: Shangjin
     * @Description:通过名字查找管理员
     * @Param:
     * @Return:
     * @Date: 12:41 2019-12-03
     */
    public List<Admin> findAdminByName(String name){
        return adminDAO.findAdminsByName(name);
    }

    /**
     * @Author: Shangjin
     * @Description:t通过管理员id删除一个管理员
     * @Param:
     * @Return:
     * @Date: 12:43 2019-12-03
     */
    public boolean delAdmin(Integer id){
        return  adminDAO.delAdmin(id);
    }

    /**
     * @Author: Shangjin
     * @Description:更新管理员信息，以Admin类的adminId为依据
     * @Param:
     * @Return:
     * @Date: 12:45 2019-12-03
     */
    public boolean updateAdminInf(Admin admin){
        return adminDAO.modifyAdminInfo(admin);
    }
}
