package com.sun.service.customer;

import com.sun.entity.customer.GloryUser;
import com.sun.vo.ResultVO;

/**
 * @author Shou
 * @Title:
 * @Package
 * @Description:
 * @date 2020/5/611:00
 */
public interface UserService {
//    ResultVO checkUser(String userName, String userPwd);


    ResultVO adduser(GloryUser gloryUser);

    int checkUser(String userName, String userPwd);
}
