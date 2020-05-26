package com.sun.repository.dao.customer;

import com.sun.entity.customer.SysUser;

/**
 * @author 微冷的雨
 * @date 2020/5/19 8:49
 */
//用户DAO
public interface ISysUserDAO {
    //01.定义一个用户登录的方法
    public SysUser isLogin(SysUser info);
}
