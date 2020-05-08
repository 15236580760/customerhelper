package com.sun.controller;

import com.sun.exception.CustomerException;
import com.sun.form.DiscountForm;
import com.sun.service.DiscountService;
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
 * @date 2020/4/2713:19
 */
@RestController
@RequestMapping("/discount")
@Slf4j
@Api(tags = "总价折扣页面相关接口")
public class DiscountHandler {

    @Autowired
    private DiscountService discountService;

    @GetMapping("/list")
    @ApiOperation("查询折扣列表")
    public ResultVO list(){
       return ResultVOUtil.success(discountService.findAll());
    }

    @GetMapping("/getOne")
    @ApiOperation("查询单一折扣")
    @ApiImplicitParam(name = "id",dataType = "Integer",value = "折扣id")
    public ResultVO findOne(Integer id){
        return ResultVOUtil.success(discountService.getOne(id));
    }


    @PostMapping("/update")
    @ApiOperation("更新折扣")
    @ApiImplicitParam(name = "discountForm",dataType = "DiscountForm",value = "页面折扣对象")
    public ResultVO update(@Valid @RequestBody DiscountForm discountForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【更新折扣】参数错误,DiscountForm={}", discountForm);
            throw new CustomerException(bindingResult.getFieldError().getDefaultMessage());
        }
        discountService.saveOrUpdate(discountForm);
        return ResultVOUtil.success(null);
    }

    @PostMapping("/creat")
    @ApiOperation("新建折扣")
    @ApiImplicitParam(name = "discountForm",dataType = "DiscountForm",value = "页面折扣对象")
    public ResultVO creat(@Valid @RequestBody DiscountForm discountForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【新建折扣】参数错误,DiscountForm={}", discountForm);
            throw new CustomerException(bindingResult.getFieldError().getDefaultMessage());
        }
        discountService.saveOrUpdate(discountForm);
        return ResultVOUtil.success(null);
    }

    @PostMapping("/updateList")
    @ApiOperation("更新折扣(集合形式)")
    @ApiImplicitParam(name = "discountForms",dataType = "DiscountForm",value = "页面折扣集合")
    public ResultVO updateList(@Valid @RequestBody List<DiscountForm> discountForms, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【更新折扣】参数错误,discountForms={}", discountForms);
            throw new CustomerException(bindingResult.getFieldError().getDefaultMessage());
        }
        discountService.updateList(discountForms);
        return ResultVOUtil.success(null);
    }
}