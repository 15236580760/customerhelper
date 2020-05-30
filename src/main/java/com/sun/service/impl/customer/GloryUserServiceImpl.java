package com.sun.service.impl.customer;

import com.sun.entity.customer.GloryUser;
import com.sun.repository.dao.customer.IGloryUserDAO;
import com.sun.service.customer.IGloryUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 微冷的雨
 * @date 2020/5/28 8:58
 */
@Service("gloryUserService")
public class GloryUserServiceImpl implements IGloryUserService {
    //植入DAO
    @Autowired
    private IGloryUserDAO gloryUserDAO;

    @Override
    public GloryUser isLogin(GloryUser gloryUser) {
        //登陆的方法
        return gloryUserDAO.isLogin(gloryUser);
    }
}
