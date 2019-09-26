package cn.huang.config;


import cn.huang.realm.Myrealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author huangkuanyi huang_kuan_yi@163.com
 * @date 2019/9/24 22:03
 */
@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean webFilter(){
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
        Map<String,String> filterChainMap=new LinkedHashMap<>();
        filterChainMap.put("/login","anon");
        filterChainMap.put("/**","authc");
       shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainMap);
        shiroFilterFactoryBean.setSecurityManager(securityManager());
        return shiroFilterFactoryBean;
    }
    @Bean
    public DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        securityManager.setRealm(myRealm());
        return  securityManager;
    }
    @Bean
    public Myrealm myRealm(){
        return new Myrealm();
    }
    @Bean
    //cookie管理对象 记住我功能
    public CookieRememberMeManager  rememberMeManager(){
    CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
    cookieRememberMeManager.setCookie(rememberMeCookie());
    return cookieRememberMeManager;
}
    @Bean
    public  Cookie rememberMeCookie() {
        System.out.println("rememberMeCookie");
        SimpleCookie simpleCookie=new SimpleCookie("rememberMe");
        simpleCookie.setMaxAge(10800);
        return simpleCookie;
    }


}
