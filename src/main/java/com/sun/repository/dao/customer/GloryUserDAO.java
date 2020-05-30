package com.sun.repository.dao.customer;/*
 *ClassName:qiang
 *Pachage:com.sun.repository.dao.customer
 *Description:
 *@date:2020/5/2714:24
 *@AUTHOR:15037290614
 */

import com.sun.vo.ResultVO;
import org.springframework.stereotype.Repository;

@Repository
public interface GloryUserDAO {
    void adduser(String id, String name, String  phone, String passadd, String email);

    int selectname(String name);


    int selectuser(String userName, String passMd5);
}
