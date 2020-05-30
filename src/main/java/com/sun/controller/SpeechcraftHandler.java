package com.sun.controller;

import com.sun.exception.CustomerException;
import com.sun.form.SpeechcraftForm;
import com.sun.service.SpeechcraftService;
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
 * @date 2020/4/2813:27
 */
@RestController
@RequestMapping("/speechcraft")
@Slf4j
@Api(tags = "语术页面相关接口")
public class SpeechcraftHandler {
    @Autowired
    private SpeechcraftService speechcraftService;

    @GetMapping("/list")
    @ApiOperation("查询全部语术")

    public ResultVO list(){
        return ResultVOUtil.success(speechcraftService.findAll());
    }

    @GetMapping("/getOne")
    @ApiOperation("查询单一语术")
    @ApiImplicitParam(name = "id",dataType = "Integer",value = "语术对应id")
    public ResultVO getOne(Integer id){
        return ResultVOUtil.success(speechcraftService.getOne(id));
    }

    @PostMapping("/update")
    @ApiOperation("更新语术对象")
    @ApiImplicitParam(name = "SpeechcraftForm",dataType = "SpeechcraftForm",value = "页面语术对象")
    public ResultVO update(@Valid @RequestBody SpeechcraftForm speechcraftForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【更新语术】参数错误,SpeechcraftForm={}", speechcraftForm);
            throw new CustomerException(bindingResult.getFieldError().getDefaultMessage());
        }
        speechcraftService.saveOrUpdate(speechcraftForm);
        return ResultVOUtil.success(null);
    }

    @PostMapping("/create")
    @ApiOperation("新建语术对象")
    @ApiImplicitParam(name = "SpeechcraftForm",dataType = "SpeechcraftForm",value = "页面语术对象")
    public ResultVO creat(@Valid @RequestBody SpeechcraftForm speechcraftForm, BindingResult bindingResult){
        System.out.println(speechcraftForm);
        if(bindingResult.hasErrors()){
            log.error("【新建语术】参数错误,SpeechcraftForm={}", speechcraftForm);
            throw new CustomerException(bindingResult.getFieldError().getDefaultMessage());
        }
        speechcraftService.saveOrUpdate(speechcraftForm);
        return ResultVOUtil.success(null);
    }

    @PostMapping("/updateList")
    @ApiOperation("更新语术(集合形式)")
    @ApiImplicitParam(name = "speechcraftForms",dataType = "SpeechcraftForm",value = "页面语术集合")
    public ResultVO updateList(@Valid @RequestBody List<SpeechcraftForm> speechcraftForms, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【更新语术】参数错误,speechcraftFromS={}", speechcraftForms);
            throw new CustomerException(bindingResult.getFieldError().getDefaultMessage());
        }
        speechcraftService.updateList(speechcraftForms);
        return ResultVOUtil.success(null);
    }

}