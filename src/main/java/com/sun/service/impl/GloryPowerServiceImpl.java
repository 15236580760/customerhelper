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

import com.sun.entity.GloryPower;

import com.sun.repository.dao.customer.GloryPowerDAO;
import com.sun.repository.dao.customer.GloryPowerDiscountDAO;
import com.sun.service.GloryPowerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


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

        BigDecimal bigDecimal = new BigDecimal(0);
        //所有的数据
        List<GloryPower> powerList=gloryPowerDAO.queryAll(start,end);

        BigDecimal startsmallmoney= new BigDecimal(gloryPowerDAO.selectstartmoney(start));//初始值的价格
        BigDecimal endbigmoney = gloryPowerDAO.selectbigmoney(end);//目标值的单价

        int startnum = start - gloryPowerDAO.selectstartsmallpower(start);//初始值和数据库中靠前的值 可能为0
         int endnum = end- gloryPowerDAO.selectbigpower(end); //目标值和数据库靠前的额值 可能为0

        BigDecimal endnummoney = new BigDecimal(endnum);//结尾金额单价
        BigDecimal num = new BigDecimal(end - start);
        BigDecimal startbigmoney = num.multiply(startsmallmoney);
//        int startbigpower = powerList.get(0).getPower()-start;
//        BigDecimal startbigpowermoney = new BigDecimal(startbigpower);
//        BigDecimal startbigpowermoneys= startbigpowermoney.multiply(powerList.get(0).getMoney());
        if (powerList.size()==0){
            BigDecimal result = num.multiply(startsmallmoney);
             return result;

        }else if (powerList.size()==1){
            if (endnum==0){
                return startbigmoney;
            }if (startnum==0){
                return endbigmoney.multiply(endnummoney);
            }
            return endbigmoney.add(startbigmoney);

//            BigDecimal startbigpower =new BigDecimal(powerList.get(0).getPower()-start);
//            BigDecimal startbigmoney = startbigpower.multiply(powerList.get(0).getMoney());//前面的价格
//            powerList.get(1).getPower()

        }else {
            int startbigpower = powerList.get(0).getPower()-start;
            BigDecimal startbigpowermoney = new BigDecimal(startbigpower);
            BigDecimal startbigpowermoneys= startbigpowermoney.multiply(powerList.get(0).getMoney());
            BigDecimal addsum =new BigDecimal(0);
            BigDecimal onemoney =new BigDecimal(0);
            for (int i = 0; i <powerList.size()-1;i++){
                int num1 = powerList.get(i + 1).getPower() - powerList.get(i).getPower();
                BigDecimal nummoney = new BigDecimal(num1);
                BigDecimal sum = powerList.get(i+1).getMoney();
                onemoney = sum.multiply(nummoney);
                addsum= addsum.add(onemoney);
            }
            int startyes = gloryPowerDAO.selectstartp(start);
            int endyes = gloryPowerDAO.selectendy(end);
            if (startyes==1){
                if (endyes==1){
                    return addsum;
                }
                return addsum.add(endbigmoney.multiply(endnummoney));
            }else if (startyes==0){
                if (endyes==0){
                    return addsum.add(startbigpowermoneys).add(endbigmoney.multiply(endnummoney));
//                    int startuppower = powerList.get(0).getPower()-start;
//                    BigDecimal startupmoeny= powerList.get(0).getMoney().multiply(BigDecimal.valueOf(startuppower));
//                    return addsum.add(startupmoeny);
                }else {
                    return addsum.add(startbigpowermoneys);
                }

            }
            return null;
//            return addsum.add(startbigmoney).add(endbigmoney.multiply(endnummoney));
        }
//        for (int i = 0; i < powerList.size()-1; i++) {
//            // 如果当前值没有跨越区段 价位都一个价钱
//            if(0 == powerList.size()){
//                BigDecimal num = new BigDecimal(end - start);
//                return powerList.get(i).getMoney().multiply(num);
//                sum += (powerList.get(i).getPower() - powerList.get(i -1).getPower()) * powerList.get(i).getMoney();
//
//            } else if(1 == powerList.size()) {//当只跨越一个区段，直接进行计算
//
//            }else {//当跨越两个以上，包含两个区段的时候
//                sum += (powerList.get(i + 1).getPower() - powerList.get(i).getPower()) * powerList.get(i + 1).getMoney();
//            }
//
//        }


//        ArrayList list = gloryPowerDAO.selectpower(start, end);
//        ArrayList listup = gloryPowerDAO.selectpowerup(start, end);
//        ArrayList moneylist = gloryPowerDAO.selectmoneylist(start, end);
//
//        for (int i = 0; i < list.size(); i++) {
//            for (int j = 0; j < listup.size(); j++) {
//                for (int k = 0; k < moneylist.size(); k++) {
//                    BigDecimal powermoney = (BigDecimal) moneylist.get(k);
//                    BigDecimal listpower = (BigDecimal) list.get(i);
//                    BigDecimal listpowerup = (BigDecimal) listup.get(j);
//                    BigDecimal numpower = (listpower.subtract(listpowerup)).multiply(powermoney);
//                    bigDecimal.add(numpower);
//                }
//            }
//        }
//        bigDecimal 就是算出来总阶段的价格


//        /**
//         * count ——查询条数
//         */
//        int count = gloryPowerDAO.selectcount(start, end);
//
//        double powerpricea = gloryPowerDAO.selectmoney(start);
//        double powerpriceb = gloryPowerDAO.selectmoneyb(end);
//        BigDecimal powerpriceA = new BigDecimal(powerpricea);
//        BigDecimal powerpriceB = new BigDecimal(powerpriceb);
//        //不在范围内 就返回0
//        int other =0;
//        BigDecimal others = new BigDecimal(other);
//
//        int startA = gloryPowerDAO.selectstartpower(start) - start;
//        int endA = gloryPowerDAO.selectendpower(end) - end;
//        int endB = 1000 - endA;
//        int num = end - start;
//        //确定一个固定量1000
//        int numa = 1000;
//        BigDecimal bigDecimal = new BigDecimal(numa);
//        //折扣价格
//        BigDecimal selectdiscount = gloryPowerDiscountDAO.selectdiscount(num);
//
//        System.out.println("数据库查出的数据：powerpricea=" + powerpricea + "powerpriceb" + powerpriceb);
//        System.out.println("powerpriceA==" + powerpriceA + "powerpriceB==" + powerpriceB);
//        System.out.println("startA===" + startA + "endA===" + endA + "num===" + num);
//        //当前的战力值在同一个范围时 （end - start）*小于start第一个值得金额
//        if (count == 0) {
//            System.out.println("我是count=0");
////            BigDecimal arr = new BigDecimal(end - start);
//            BigDecimal powerpriceC = powerpriceA.multiply(BigDecimal.valueOf(num));
////            double iso =gloryPowerDiscountDAO.selectdiscountnum(num);
//            BigDecimal discount = gloryPowerDiscountDAO.selectdiscount(num);
//
//            //BigDecimal discount = new BigDecimal(discount);
//            BigDecimal discountprice = powerpriceC.multiply(discount);
//            return discountprice;
//
//            //当战力值相隔时候
//        } else if (count == 1) {
//            System.out.println("我是count1");
//            BigDecimal priceA = powerpriceA.multiply(BigDecimal.valueOf(startA));
//            if (endA==1000){
//                BigDecimal priceB = powerpriceB.multiply(bigDecimal);
//                BigDecimal price = priceA.add(priceB);
//                BigDecimal discountprice = price.multiply(selectdiscount);
//                return discountprice;
//            }else {
//
//                BigDecimal priceB = powerpriceB.multiply(BigDecimal.valueOf(endB));
//                BigDecimal price = priceA.add(priceB);
//                BigDecimal discountnum = gloryPowerDiscountDAO.selectdiscount(num);
////            BigDecimal discountrice = new BigDecimal(discountnum);
//                BigDecimal discountprice = discountnum.multiply(price);
//                return discountprice;
//            }
//
//
//            //当战力值中间隔段时
//        } else {
//            System.out.println("count总条数：" + count);
//
//            BigDecimal addprice = gloryPowerDAO.selectmoneycount(start, end).multiply(bigDecimal);
////                double powerpriceE = addprice * 1000 +powerpriceA*startA+powerpriceB*endA;
//            int startpower = start - gloryPowerDAO.selectstartcount(start);
//            int endpower = gloryPowerDAO.selectendcount(end) - end;
//            int firstendpower = end - gloryPowerDAO.selectfirstendpower(end);
//            //结尾得为整千数
//            if (firstendpower == 0) {
//
//                BigDecimal firstendmoney = powerpriceB.multiply(bigDecimal);//末尾价格总价格
//                System.out.println("结尾的钱数：" + firstendmoney);
//                BigDecimal startprice = powerpriceA.multiply(BigDecimal.valueOf(startpower));
//                if (startpower == 0) {
//
//                    BigDecimal price = addprice;
////                        BigDecimal price = addprice.subtract(startprice).add(firstendmoney);
//                    BigDecimal discountprice = price.multiply(selectdiscount);
//                    return discountprice;
////
//
//                } else if (startpower > 0) {
//
//                    BigDecimal price = addprice.subtract(startprice);
//                    BigDecimal discountprice = price.multiply(selectdiscount);
//                    return discountprice;
//                }
//
//
//
//            } else {
//                //当结尾段数不在整千数时
//                BigDecimal firstendmoney = powerpriceB.multiply(BigDecimal.valueOf(endpower));
//                //当目前值为整数
//                BigDecimal oneendmoney = powerpriceB.multiply(BigDecimal.valueOf(firstendpower));
//                if (startpower==0){
//                    BigDecimal startprice = powerpriceA;
//                    BigDecimal price = addprice.subtract(startprice).add(oneendmoney);
//                    BigDecimal discountprice = selectdiscount.multiply(price);
//                    return discountprice;
//                }
//
//                BigDecimal startprice = powerpriceA.multiply(BigDecimal.valueOf(startpower));
//                BigDecimal price = addprice.subtract(startprice).add(firstendmoney);
//                //double firstendmoney = firstendpower * powerpriceB;
//                System.out.println("结尾的钱数：" + firstendmoney);
//                BigDecimal discountprice = selectdiscount.multiply(price);
//                return discountprice;
//            }
//        }

//        return null;
    }



    @Override
    public int selectbigpowerone(int start) {
        return gloryPowerDAO.selectbigpowerone(start);
    }

    @Override
    public int selectsmallpower(int start) {
        return gloryPowerDAO.selectsmallpower(start);
    }


}

