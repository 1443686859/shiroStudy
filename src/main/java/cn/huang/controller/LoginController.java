package cn.huang.controller;

import cn.huang.bean.User;
import com.sun.org.glassfish.external.statistics.annotations.Reset;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.RequestWrapper;


/**
 * @author huangkuanyi huang_kuan_yi@163.com
 * @date 2019/9/24 22:41
 */

@RestController
public class LoginController {
/*
 @RequestMapping(value = "/login",method = RequestMethod.POST)
  */
    @PostMapping("/login")
    public User login(String username, String password){
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        Subject currentUser = SecurityUtils.getSubject();
            currentUser.login(token);
        if(currentUser.isAuthenticated()){
            System.out.println("认证成功");
            return currentUser();
        }else{
            token.clear();
            return null;
        }
    }
    private User currentUser(){
        User currentUser = (User) SecurityUtils.getSubject().getPrincipal();
        return  currentUser;
    }
}
