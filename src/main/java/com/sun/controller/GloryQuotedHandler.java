package com.sun.controller;

import com.sun.exception.CustomerException;
import com.sun.form.GloryQuotedForm;
import com.sun.service.GloryQuotedService;
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
 * @date 2020/4/2813:45
 */
@RestController
@RequestMapping("/quoted")
@Slf4j
@Api(tags = "段位价格页面相关接口")
public class GloryQuotedHandler {

    @Autowired
    private GloryQuotedService gloryQuotedService;

    @GetMapping("getOne")
    @ApiOperation("查询单一段位价格详情")
    @ApiImplicitParam(name = "id",dataType = "Integer",value = "段位价格对应Id")
    public ResultVO getOne(Integer id){
        return  ResultVOUtil.success(gloryQuotedService.getOne(id)) ;
    }

    @GetMapping("list")
    @ApiOperation("查询段位价格列表")
    public ResultVO findAll(){
        return ResultVOUtil.success(gloryQuotedService.findAllByParent());
    }

    @PostMapping("creat")
    @ApiOperation("新建段位价格")
    @ApiImplicitParam(name = "GloryQuotedForm",dataType = "GloryQuotedForm",value = "页面段位价格对象")
    public ResultVO creat(@Valid @RequestBody GloryQuotedForm gloryQuotedForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【新建段位价格明细】参数错误,GloryQuotedForm={}", gloryQuotedForm);
            throw new CustomerException(bindingResult.getFieldError().getDefaultMessage());
        }
        gloryQuotedService.saveOrUpdate(gloryQuotedForm);
        return ResultVOUtil.success("");
    }
    @PostMapping("update")
    @ApiOperation("更新段位价格")
    @ApiImplicitParam(name = "GloryQuotedForm",dataType = "GloryQuotedForm",value = "页面段位价格对象")
    public ResultVO update(@Valid @RequestBody GloryQuotedForm gloryQuotedForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【更新段位价格明细】参数错误,GloryQuotedForm={}", gloryQuotedForm);
            throw new CustomerException(bindingResult.getFieldError().getDefaultMessage());
        }
        gloryQuotedService.saveOrUpdate(gloryQuotedForm);
        return ResultVOUtil.success("");
    }

    @PostMapping("/updateList")
    @ApiOperation("更新段位(集合形式)")
    @ApiImplicitParam(name = "gloryQuotedForms",dataType = "GloryQuotedForm",value = "页面段位集合")
    public ResultVO updateList(@Valid @RequestBody List<GloryQuotedForm> gloryQuotedForms, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【更新段位】参数错误,gloryQuotedForms={}", gloryQuotedForms);
            throw new CustomerException(bindingResult.getFieldError().getDefaultMessage());
        }
        gloryQuotedService.updateList(gloryQuotedForms);
        return ResultVOUtil.success(null);
    }
}