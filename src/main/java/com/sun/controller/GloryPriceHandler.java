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

import com.sun.service.GloryPowerService;
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
    /**
     *
     */
    @Autowired
    GloryPowerService glorypowerService;

    @GetMapping("/computed")
    @ApiOperation("接受初始和目标战力参数")
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "start", value = "当前战力值"),
            @ApiImplicitParam(name = "end", value = "目标值")
    })

    public ResultVO computed(int start, int end) {
        //判断初始值和目标值 并且目标值要比初始值要大 并且目标值要低于9000
        try {
            if (end - start >= 0) {
                if (start >= 0 && end <= 9000) {
                    BigDecimal price = glorypowerService.selectprice(start, end);
                    DecimalFormat df = new DecimalFormat("0.00");
                    String discountprice = df.format(price);
                    return ResultVOUtil.success(discountprice);
                } else {
                    return ResultVOUtil.error("超过计算范围");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("计算值当前战力值:" + start + "目标战力值:" + end);
           return ResultVOUtil.error("网络错误");
        }
    return ResultVOUtil.error("目标值要大于初始值");
    }
}
