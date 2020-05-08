package com.sun.controller;

import com.sun.exception.CustomerException;
import com.sun.form.ComboForm;
import com.sun.service.ComboService;
import com.sun.util.ResultVOUtil;
import com.sun.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Shou
 * @Title:
 * @Package
 * @Description:
 * @date 2020/4/2715:41
 */
@RestController
@RequestMapping("/combo")
@Slf4j
@Api(tags = "套餐页面相关接口")
public class ComboHandler {

    @Autowired
    private ComboService comboService;

    @GetMapping("/list")
    @ApiOperation("查询套餐列表")
    public ResultVO list() {
        return ResultVOUtil.success(comboService.findAll());
    }

    @GetMapping("/getOne")
    @ApiOperation("查询单一套餐详情")
    @ApiImplicitParam(name = "id",dataType = "Integer",value = "折扣ID")
    public ResultVO getOne(Integer id) {
        return ResultVOUtil.success(comboService.getOne(id));
    }

    @PostMapping("/update")
    @ApiOperation("更新套餐")
    @ApiImplicitParam(name = "comboForm",value = "页面套餐对象")
    public ResultVO update(@Valid @RequestBody ComboForm comboForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【更新套餐】参数错误,comboForm={}", comboForm);
            throw new CustomerException(bindingResult.getFieldError().getDefaultMessage());
        }
        comboService.saveOrUpdate(comboForm);
        return ResultVOUtil.success(null);
    }

    @PostMapping("/creat")
    @ApiOperation("新建套餐")
    @ApiImplicitParam(name = "comboForm",dataType = "ComboForm",value = "页面套餐对象")
    public ResultVO creat(@Valid @RequestBody ComboForm comboForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【新建套餐】参数错误,comboForm={}", comboForm);
            throw new CustomerException(bindingResult.getFieldError().getDefaultMessage());
        }
        comboService.saveOrUpdate(comboForm);
        return ResultVOUtil.success(null);
    }


    @PostMapping("/updateList")
    @ApiOperation("更新套餐(集合形式)")
    @ApiImplicitParam(name = "comboForms",dataType="ComboForm",value = "页面套餐集合")
    public ResultVO updateList(@Valid @RequestBody List<ComboForm> comboForms, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【更新套餐】参数错误,comboForms={}", comboForms);
            throw new CustomerException(bindingResult.getFieldError().getDefaultMessage());
        }
        comboService.updateList(comboForms);
        return ResultVOUtil.success(null);
    }

}