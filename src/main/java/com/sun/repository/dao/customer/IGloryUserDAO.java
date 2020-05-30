package com.sun.repository.dao.customer;

import com.sun.entity.customer.GloryUser;
import org.springframework.stereotype.Repository;

/**
 * @author 微冷的雨
 * @date 2020/5/28 8:52
 */
//用户DAO接口层
@Repository
public interface IGloryUserDAO {
    //01、定义一个登陆的方法
    public GloryUser isLogin(GloryUser gloryUser);
}
