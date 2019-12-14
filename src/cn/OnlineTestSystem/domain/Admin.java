package cn.OnlineTestSystem.domain;

/**
 * @ClassName Admin
 * @Desciption TODO
 * @Author shangjin
 * @Date 2019-11-28 18:57
 * @Version 1.0
 **/
public class Admin {
    private Integer admin_id;
    private String password;
    private String admin_name;

    public Admin() {
    }

    public Integer getAdminId() {
        return admin_id;
    }

    public void setAdminId(Integer adminId) {
        this.admin_id = adminId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdminName() {
        return admin_name;
    }

    public void setAdminName(String adminName) {
        this.admin_name = adminName;
    }
}
