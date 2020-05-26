package com.sun.controller;/*
 *ClassName:qiang
 *Pachage:com.sun.controller
 *Description:
 *@date:2020/5/2010:56
 *@AUTHOR:15037290614
 *//*
 *com.sun.controller刘战强
 *2020/5/20
 */

import com.sun.exception.CustomerException;
import com.sun.form.DiscountForm;
import com.sun.form.GloryPowerForm;
import com.sun.form.InscriptionForm;
import com.sun.service.PowerFunctionService;
import com.sun.util.ResultVOUtil;
import com.sun.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/powerfunction")
@Slf4j
@Api(tags = "战力设置区段价格")
public class PowerFunctionHandler {


    @Autowired
    PowerFunctionService powerfunctionservice;

    @GetMapping("/list")
    @ApiOperation("查询总区段和价格列表")
    public ResultVO list() {
        return ResultVOUtil.success(powerfunctionservice.findAll());
    }

    @GetMapping("/creatorupdate")
    @ApiOperation("新建战力与价格或者修改战力与价格")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "power", value = "到达价格打折"),
            @ApiImplicitParam(name = "money", value = "价位多少")
    })
    public ResultVO creatorupdate( int power, BigDecimal money) {
        return ResultVOUtil.success(powerfunctionservice.creatorupdate( power, money));
    }


    @GetMapping("/delete")
    @ApiOperation("根据战力删除当前这条信息")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "power", value = "战力值")
    })
    public ResultVO delete(int  power) {
        return ResultVOUtil.success(powerfunctionservice.delete(power));
    }

}
