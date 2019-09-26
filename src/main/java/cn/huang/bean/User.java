package cn.huang.bean;

import javax.security.auth.Subject;
import java.util.List;

/**
 * @author huangkuanyi huang_kuan_yi@163.com
 * @date 2019/9/24 21:15
 */
public class User{
    private String username;
    private String password;
    private String salt;
    private List<String> permis;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public List<String> getPermis() {
        return permis;
    }

    public void setPermis(List<String> permis) {
        this.permis = permis;
    }
}
