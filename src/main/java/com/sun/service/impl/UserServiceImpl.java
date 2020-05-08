package com.sun.service.impl;

import com.sun.service.UserService;
import com.sun.util.ResultVOUtil;
import com.sun.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Shou
 * @Title:
 * @Package
 * @Description:
 * @date 2020/5/611:00
 */
@Service
public class UserServiceImpl implements UserService {


    @Override
    public ResultVO checkUser(String userName, String userPwd) {



        return ResultVOUtil.success("null");
    }
}