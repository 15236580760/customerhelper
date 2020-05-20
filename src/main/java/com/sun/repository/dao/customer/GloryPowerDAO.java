package com.sun.repository.dao.customer;/*
 *ClassName:qiang
 *Pachage:com.sun.repository.dao.customer
 *Description:
 *@date:2020/5/148:58
 *@AUTHOR:15037290614
 */

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface GloryPowerDAO {
    //查询战力价格
    BigDecimal selectpowerprice(int start, int end);

    int selectcount(int start, int end);

    double selectmoney(int start);

    double selectmoneyb(int end);

    BigDecimal selectmoneycount(@Param("start") int start, @Param("end") int end);

    int selectstartpower(int start);

    int selectendpower(int end);

    double selectstartmoney(int start);

    double selectendmoney(int end);

    int selectstartcount(int start);

    int selectendcount(int end);

    int selectfirstendpower(int end);

}
