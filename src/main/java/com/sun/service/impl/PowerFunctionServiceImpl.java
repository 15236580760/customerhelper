package com.sun.service.impl;/*
 *ClassName:qiang
 *Pachage:com.sun.service.impl
 *Description:
 *@date:2020/5/2011:10
 *@AUTHOR:15037290614
 *//*
 *com.sun.service.impl刘战强
 *2020/5/20
 */

import com.sun.entity.GloryPower;
import com.sun.repository.PowerFunctionRepsitory;
import com.sun.repository.dao.customer.GloryPowerDAO;
import com.sun.service.PowerFunctionService;
import com.sun.util.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PowerFunctionServiceImpl implements PowerFunctionService {

    @Autowired
    private PowerFunctionRepsitory powerfunctionrepsitory;
    @Autowired
    private GloryPowerDAO gloryPowerDAO;

    @Override
    public List<GloryPower> findAll() {


     return powerfunctionrepsitory.findAll();
    }



//    @Override
//    public void saveOrUpdate(GloryPowerForm gloryPowerForm) {
//        GloryPower gloryPower;
//        if ( gloryPowerForm.getId()){
//            gloryPower =new GloryPower();
//        }else {
//
//        }
//        gloryPower.setId(gloryPowerForm.getId());
//        gloryPower.setPower(gloryPowerForm.getPower());
//        gloryPower.setMoney(gloryPowerForm.getPower());
//        powerfunctionrepsitory.save(gloryPower);
//
//    }



    @Override
    public Object creatorupdate( int power, BigDecimal money) {
        int num = gloryPowerDAO.selectpowernum(power);
        if (num == 0) {
            gloryPowerDAO.creat(power, money);
            return "创建成功";
        } else if (num == 1) {
            gloryPowerDAO.update( power, money);
            return "修改数据成功";
        }
        return "数据出现异常";
    }

    @Override
    public Object delete(int power) {
        gloryPowerDAO.delete(power);
        int num1 = gloryPowerDAO.selectpowernum(power);
        if (num1==1){
            return "该条战力删除失败";
        }
        return "删除成功";
    }
}
