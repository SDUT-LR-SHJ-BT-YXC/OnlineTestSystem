package cn.OnlineTestSystem.domain;

/**
 * @ClassName Admin
 * @Desciption TODO
 * @Author shangjin
 * @Date 2019-11-28 18:57
 * @Version 1.0
 **/
public class Admin {
    private Integer adminId;
    private String password;
    private String adminName;

    public Admin() {
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
}
