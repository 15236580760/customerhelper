package com.sun.service;/*
 *ClassName:qiang
 *Pachage:com.sun.service
 *Description:
 *@date:2020/5/2014:47
 *@AUTHOR:15037290614
 */

import com.sun.entity.GloryPowerDiscount;

import java.util.List;

public interface PowerDiscountService {
    List<GloryPowerDiscount> findAll();

    Object creatorupdate( double grade, double discount);


    Object delete(double grade);
}
