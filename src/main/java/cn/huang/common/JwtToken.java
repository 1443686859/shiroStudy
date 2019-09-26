package cn.huang.common;

import org.apache.shiro.authc.AuthenticationToken;


/**
 * @author huangkuanyi huang_kuan_yi@163.com
 * @date 2019/9/26 23:55
 */
public class JwtToken implements AuthenticationToken {
    private String token;

    public  JwtToken(String token){
        this.token=token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
