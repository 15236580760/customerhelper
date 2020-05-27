package com.sun.service.impl;/*
 *ClassName:qiang
 *Pachage:com.sun.service.impl
 *Description:
 *@date:2020/5/2014:48
 *@AUTHOR:15037290614
 *//*
 *com.sun.service.impl刘战强
 *2020/5/20
 */

import com.sun.entity.GloryPowerDiscount;
import com.sun.repository.PowerDiscountRepsitory;
import com.sun.repository.dao.customer.GloryPowerDiscountDAO;
import com.sun.service.PowerDiscountService;
import com.sun.util.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PowerDiscountServiceImpl implements PowerDiscountService {
    @Autowired
    PowerDiscountRepsitory powerDiscountRepsitory;
    @Autowired
    GloryPowerDiscountDAO powerDiscountDAO;

    @Override
    public List<GloryPowerDiscount> findAll() {
        return powerDiscountRepsitory.findAll();
    }

    @Override
    public Object creatorupdate( double grade, double discount) {
        int num = powerDiscountDAO.select(grade);
        if (num==0){
            powerDiscountDAO.creat(grade,discount);
            return "创建成功";
        }if (num==1) {
            powerDiscountDAO.update(  grade,  discount);
            return "修改成功";
        }

        return ResultVOUtil.error("添加失败");
    }

    @Override
    public Object delete(double grade) {
        powerDiscountDAO.delete(grade);
        int num = powerDiscountDAO.select(grade);
        if (num==1){
            return "删除失败";
        }
        return "删除成功";
    }



}
