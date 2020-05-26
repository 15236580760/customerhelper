package com.sun.service;/*
 *ClassName:qiang
 *Pachage:com.sun.service
 *Description:
 *@date:2020/5/1315:59
 *@AUTHOR:15037290614
 *//*
 *com.sun.service刘战强
 *2020/5/13
 */

import com.sun.vo.ResultVO;

import java.math.BigDecimal;

public interface GloryPowerService {
    //查询价格
    BigDecimal selectprice(int start, int end);



    int selectsmallpower(int start);

    int selectbigpowerone(int start);

    //ResultVO selectprice(int start, int end);
}
