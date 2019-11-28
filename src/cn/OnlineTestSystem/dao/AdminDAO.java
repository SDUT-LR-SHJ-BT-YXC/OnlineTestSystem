package cn.OnlineTestSystem.dao;

import cn.OnlineTestSystem.domain.Admin;

import java.util.List;

/**
 * @ClassName AdminDAO
 * @Desciption TODO
 * @Author shangjin
 * @Date 2019-11-28 19:36
 * @Version 1.0
 **/
public interface AdminDAO {
    public Admin findAdminById(Integer id);
    public List<Admin> findAdminsByName(String name);
    public Boolean addAdmin(Admin admin);
    public Boolean delAdmin(Integer id);
    public Boolean modifyAdminInfo(Admin admin);
}
