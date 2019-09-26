package cn.huang.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

/**
 * @author huangkuanyi huang_kuan_yi@163.com
 * @date 2019/9/26 23:58
 */
public class JwtUtil {
    private static final long EXPIRE_TIME = 5 * 60 * 1000;
    //设置过期时间
    public static boolean verify(String token,String username,String password){

       try{
           //加载签名 Tokens specify this as "HS256".
           Algorithm algorithm=Algorithm.HMAC256(password);
           JWTVerifier jwtVerifier= JWT.require(algorithm).
                   withClaim("username",username).
                   build();
           DecodedJWT decodedJWT=jwtVerifier.verify(token);
           return true;
       }catch (Exception ex){
           return false;
       }
    }

    /**
     * 获取token中的 username对应的String
     * @param token
     * @return
     */
    public static String getUsername(String token){
        try{
            DecodedJWT decodedJWT=JWT.decode(token);
            return decodedJWT.getClaim("username").asString();
        }catch (Exception e){
            return null;
        }
    }

    /**
     * 签名函数
     * @param username
     * @param password
     * @return
     */
    public static String sign(String username,String password){
        Date date=new Date(System.currentTimeMillis()+EXPIRE_TIME);
        Algorithm algorithm=Algorithm.HMAC256(password);
        return JWT.create().withClaim("username",username).withExpiresAt(date).sign(algorithm);
    }
}
