package com.sun.controller;/*
 *ClassName:qiang
 *Pachage:com.sun.controller
 *Description:
 *@date:2020/5/139:31
 *@AUTHOR:15037290614
 *//*
 *com.sun.controller刘战强
 *2020/5/13
 */

import com.sun.repository.dao.customer.GloryPowerDiscountDAO;
import com.sun.service.GloryPowerService;
import com.sun.service.PowerDiscountService;
import com.sun.util.ResultVOUtil;
import com.sun.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.DecimalFormat;

@RestController
@RequestMapping("/glorypricehandler")
@Slf4j
@Api(tags = "荣耀战力计算")
public class GloryPriceHandler {

    @Autowired
    GloryPowerService glorypowerService;

    @Autowired
    GloryPowerDiscountDAO gloryPowerDiscountDAO;

    /**
     *
     * @param start 初始值
     * @param end 结束值
     * @return
     */
    @GetMapping("/computed")
    @ApiOperation("接受初始和目标战力参数")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "start", value = "当前战力值"),
            @ApiImplicitParam(name = "end", value = "目标值")
    })

    public ResultVO computed(int start, int end) {
        //判断初始值和目标值 并且目标值要比初始值要大 并且目标值要低于9000
        try {
            if (end - start > 0) {

                int bigpower = glorypowerService.selectbigpowerone(start);
                int smallpower= glorypowerService.selectsmallpower(start);
                //判断是否超越计算范围
                if (start >= smallpower && end <= bigpower ) {
                    //未打折前的价格
                    BigDecimal price = glorypowerService.selectprice(start, end);

                    //查询折扣价格
                    int num = end - start;
                    BigDecimal discount = gloryPowerDiscountDAO.selectdiscount(num);

                    //折扣后价格
                    BigDecimal resultprice = discount.multiply(price);
                    DecimalFormat df = new DecimalFormat("0.00");
                    String discountprice = df.format(resultprice);
                    return ResultVOUtil.success(discountprice);
                }
                else {
                    return ResultVOUtil.error("超过计算范围");
                }
            }else if (end-start<0){
                return ResultVOUtil.error("初始值要小于目标值");
            }
            return ResultVOUtil.success(0);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("计算值当前战力值:" + start + "目标战力值:" + end);
           return ResultVOUtil.error("网络错误");
        }
    }
}
