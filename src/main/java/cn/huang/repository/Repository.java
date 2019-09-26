package cn.huang.repository;


import cn.huang.bean.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author huangkuanyi huang_kuan_yi@163.com
 * @date 2019/9/25 10:45
 */
@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<UserInfo,Integer> {
    UserInfo findByUsername(String username);
}
