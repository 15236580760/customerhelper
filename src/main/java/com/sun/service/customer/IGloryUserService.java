package com.sun.service.customer;

import com.sun.entity.customer.GloryUser;

/**
 * @author 微冷的雨
 * @date 2020/5/28 8:57
 */
//用户服务接口层
public interface IGloryUserService {
    //01、定义一个登陆的方法
    public GloryUser isLogin(GloryUser gloryUser);
}
