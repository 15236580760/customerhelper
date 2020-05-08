package com.sun.service;

import com.sun.vo.ResultVO;

/**
 * @author Shou
 * @Title:
 * @Package
 * @Description:
 * @date 2020/5/611:00
 */
public interface UserService {
    ResultVO checkUser(String userName, String userPwd);
}
