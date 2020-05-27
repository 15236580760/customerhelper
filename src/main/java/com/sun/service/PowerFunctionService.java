package com.sun.service;/*
 *ClassName:qiang
 *Pachage:com.sun.service
 *Description:
 *@date:2020/5/2011:04
 *@AUTHOR:15037290614
 *//*
 *com.sun.service刘战强
 *2020/5/20
 */

import com.sun.entity.GloryPower;

import java.math.BigDecimal;
import java.util.List;

public interface PowerFunctionService {
    List<GloryPower> findAll();

//    void saveOrUpdate(GloryPowerForm gloryPowerForm);

    Object creatorupdate( int power, BigDecimal money);

    Object delete(int power);
}
