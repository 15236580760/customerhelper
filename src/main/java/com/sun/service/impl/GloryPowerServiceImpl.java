package com.sun.service.impl;/*
 *ClassName:qiang
 *Pachage:com.sun.service.impl
 *Description:
 *@date:2020/5/1316:13
 *@AUTHOR:15037290614
 *//*
 *com.sun.service.impl刘战强
 *2020/5/13
 */

import com.sun.repository.dao.customer.GloryPowerDAO;
import com.sun.repository.dao.customer.GloryPowerDiscountDAO;
import com.sun.service.GloryPowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class GloryPowerServiceImpl implements GloryPowerService {
    //原价表格
    @Autowired
    GloryPowerDAO gloryPowerDAO;
    //折扣表格
    @Autowired
    GloryPowerDiscountDAO gloryPowerDiscountDAO;

    @Override
    //查询战力打折后的价格
    public BigDecimal selectprice(int start, int end) {
        /**
         * count ——查询条数
         */
        int count = gloryPowerDAO.selectcount(start, end);

        double powerpricea = gloryPowerDAO.selectmoney(start);
        double powerpriceb = gloryPowerDAO.selectmoneyb(end);
        BigDecimal powerpriceA = new BigDecimal(powerpricea);
        BigDecimal powerpriceB = new BigDecimal(powerpriceb);
        //不在范围内 就返回0
        int other =0;
        BigDecimal others = new BigDecimal(other);

        int startA = gloryPowerDAO.selectstartpower(start) - start;
        int endA = gloryPowerDAO.selectendpower(end) - end;
        int endB = 1000 - endA;
        int num = end - start;
        //确定一个固定量1000
        int numa = 1000;
        BigDecimal bigDecimal = new BigDecimal(numa);
        //折扣价格
        BigDecimal selectdiscount = gloryPowerDiscountDAO.selectdiscount(num);

        System.out.println("数据库查出的数据：powerpricea=" + powerpricea + "powerpriceb" + powerpriceb);
        System.out.println("powerpriceA==" + powerpriceA + "powerpriceB==" + powerpriceB);
        System.out.println("startA===" + startA + "endA===" + endA + "num===" + num);
        //当前的战力值在同一个范围时 （end - start）*小于start第一个值得金额
        if (count == 0) {
            System.out.println("我是count=0");
//            BigDecimal arr = new BigDecimal(end - start);
            BigDecimal powerpriceC = powerpriceA.multiply(BigDecimal.valueOf(num));
            BigDecimal discount = gloryPowerDiscountDAO.selectdiscount(num);
            //BigDecimal discount = new BigDecimal(discount);
            BigDecimal discountprice = powerpriceC.multiply(discount);
            return discountprice;

            //当战力值相隔时候
        } else if (count == 1) {
            System.out.println("我是count1");
            BigDecimal priceA = powerpriceA.multiply(BigDecimal.valueOf(startA));
            if (endA==1000){
                BigDecimal priceB = powerpriceB.multiply(bigDecimal);
                BigDecimal price = priceA.add(priceB);
                BigDecimal discountprice = price.multiply(selectdiscount);
                return discountprice;
            }else {

                BigDecimal priceB = powerpriceB.multiply(BigDecimal.valueOf(endB));
                BigDecimal price = priceA.add(priceB);
                BigDecimal discountnum = gloryPowerDiscountDAO.selectdiscount(num);
//            BigDecimal discountrice = new BigDecimal(discountnum);
                BigDecimal discountprice = discountnum.multiply(price);
                return discountprice;
            }


            //当战力值中间隔段时
        } else {
            System.out.println("count总条数：" + count);

            BigDecimal addprice = gloryPowerDAO.selectmoneycount(start, end).multiply(bigDecimal);
//                double powerpriceE = addprice * 1000 +powerpriceA*startA+powerpriceB*endA;
            int startpower = start - gloryPowerDAO.selectstartcount(start);
            int endpower = gloryPowerDAO.selectendcount(end) - end;
            int firstendpower = end - gloryPowerDAO.selectfirstendpower(end);
            //结尾得为整千数
            if (firstendpower == 0) {

                BigDecimal firstendmoney = powerpriceB.multiply(bigDecimal);//末尾价格总价格
                System.out.println("结尾的钱数：" + firstendmoney);
                BigDecimal startprice = powerpriceA.multiply(BigDecimal.valueOf(startpower));
                if (startpower == 0) {

                    BigDecimal price = addprice;
//                        BigDecimal price = addprice.subtract(startprice).add(firstendmoney);
                    BigDecimal discountprice = price.multiply(selectdiscount);
                    return discountprice;
//

                } else if (startpower > 0) {

                    BigDecimal price = addprice.subtract(startprice);
                    BigDecimal discountprice = price.multiply(selectdiscount);
                    return discountprice;
                }



            } else {
                //当结尾段数不在整千数时
                BigDecimal firstendmoney = powerpriceB.multiply(BigDecimal.valueOf(endpower));
                //当目前值为整数
                BigDecimal oneendmoney = powerpriceB.multiply(BigDecimal.valueOf(firstendpower));
                if (startpower==0){
                    BigDecimal startprice = powerpriceA;
                    BigDecimal price = addprice.subtract(startprice).add(oneendmoney);
                    BigDecimal discountprice = selectdiscount.multiply(price);
                    return discountprice;
                }

                BigDecimal startprice = powerpriceA.multiply(BigDecimal.valueOf(startpower));
                BigDecimal price = addprice.subtract(startprice).add(firstendmoney);
                //double firstendmoney = firstendpower * powerpriceB;
                System.out.println("结尾的钱数：" + firstendmoney);
                BigDecimal discountprice = selectdiscount.multiply(price);
                return discountprice;
            }
        }

    return others;
    }
}

