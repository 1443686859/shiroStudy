package cn.huang.controller;

import cn.huang.bean.UserInfo;
import cn.huang.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @author huangkuanyi huang_kuan_yi@163.com
 * @date 2019/9/25 11:42
 */
@RestController
@RequestMapping("/user")
public class UserInfoController {
    @Autowired
    private Repository repository;

    @RequestMapping(value = "/userlist",method = RequestMethod.POST)
    public List<UserInfo> listAll(){
        return  repository.findAll();
    }


}
