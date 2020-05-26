package com.sun.repository.dao.customer;/*
 *ClassName:qiang
 *Pachage:com.sun.repository.dao.customer
 *Description:
 *@date:2020/5/1514:31
 *@AUTHOR:15037290614
 *//*
 *com.sun.repository.dao.customer刘战强
 *2020/5/15
 */

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface GloryPowerDiscountDAO {

    //查询战力折扣价格
    BigDecimal selectdiscount(int num);

    //查询id是否存在
//    int select(int id);

    //删除这条信息
//    void delete(int grade);

    int select(double grade);

    void creat(double grade, double discount);

    void update(double grade, double discount);

    void delete(double grade);

    double selectdiscountnum(int num);

    //
//    void creat(int id, double grade, double discount);

//    void update(int id, double grade, double discount);


}
