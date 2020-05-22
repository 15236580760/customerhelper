package com.sun.entity.customer;

/**
 * @author 微冷的雨
 * @date 2020/5/19 8:47
 */
public class SysUser {

    private Integer uid;  //用户编号
    private String uname;  //用户名
    private String upwd;  //密码

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }
}
