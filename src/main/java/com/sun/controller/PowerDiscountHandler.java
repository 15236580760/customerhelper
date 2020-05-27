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


import com.sun.service.PowerDiscountService;
import com.sun.util.ResultVOUtil;
import com.sun.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/powerdiscounthandler")
@Slf4j
@Api(tags = "战力设置区段价格")
public class PowerDiscountHandler {
    @Autowired
    PowerDiscountService powerDiscountService;

    @GetMapping("/selectlist")
    @ApiOperation("查询所有折扣价格")
    public ResultVO list() {
        return ResultVOUtil.success(powerDiscountService.findAll());
    }

    @GetMapping("/creatorupdate")
    @ApiOperation("增加或者修改")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "grade", value = "到达价格打折"),
            @ApiImplicitParam(name = "discount", value = "折扣多少")
    })
    public ResultVO creatorupdate( int grade, double discount) {
        return ResultVOUtil.success(powerDiscountService.creatorupdate( grade, discount));
    }

    @GetMapping("/delete")
    @ApiOperation("根据战力删除当前这条信息")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "grade", value = "折扣价格")
    })
    public ResultVO delete(double grade) {
        return ResultVOUtil.success(powerDiscountService.delete(grade));
    }

//
//    @PostMapping("/update")
//    @ApiOperation("更新数据")
//    @ApiImplicitParam(name = "gloryPowerForm", dataType = "gloryPowerForm", value = "页面需要更新的数据")
//    public ResultVO update(@Valid @RequestBody GloryPowerForm gloryPowerForm, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            log.error("【更新战力】参数错误,GloryPowerForm={}", gloryPowerForm);
//            throw new CustomerException(bindingResult.getFieldError().getDefaultMessage());
//        }
//        powerfunctionservice.saveOrUpdate(gloryPowerForm);
//        return ResultVOUtil.success(null);
//    }
//
//
//    @PostMapping("/creat")
//    @ApiOperation("新建战力")
//    @ApiImplicitParam(name = "gloryPowerForm", dataType = "gloryPowerForm", value = "页面需要增加数据")
//    public ResultVO creat(@Valid @RequestBody GloryPowerForm gloryPowerForm, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            log.error("【新建战力】参数错误,GloryPowerForm={}", gloryPowerForm);
//            throw new CustomerException(bindingResult.getFieldError().getDefaultMessage());
//        }
//        powerfunctionservice.saveOrUpdate(gloryPowerForm);
//        return ResultVOUtil.success(null);
//    }
}
