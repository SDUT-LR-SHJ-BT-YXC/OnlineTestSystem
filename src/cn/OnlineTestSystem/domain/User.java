package cn.OnlineTestSystem.domain;

/**
 * @ClassName User
 * @Desciption TODO
 * @Author shangjin
 * @Date 2019-11-28 19:08
 * @Version 1.0
 **/
public class User {
    private String nickName;
    private String email;
    private Integer userId;
    private String password;
    private Integer role;

    public User() {
    }

    public User(String nickName, String email, Integer userId, String password, Integer role) {
        this.nickName = nickName;
        this.email = email;
        this.userId = userId;
        this.password = password;
        this.role = role;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
