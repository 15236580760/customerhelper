package com.sun.controller;

import com.sun.exception.CustomerException;
import com.sun.form.InscriptionForm;
import com.sun.service.InscriptionService;
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
 * @date 2020/4/2811:40
 */
@RestController
@RequestMapping("inscription")
@Slf4j
@Api(tags = "铭文价格页面相关接口")
public class InscriptionHandler {

    @Autowired
    private InscriptionService inscriptionService;

    @GetMapping("/list")
    @ApiOperation("查询全部铭文区间价格加成")
    public ResultVO list(){
        return ResultVOUtil.success(inscriptionService.findAll());
    }

    @GetMapping("/getOne")
    @ApiOperation("查询单一铭文区间价格加成")
    @ApiImplicitParam(name = "id",dataType = "Integer",value = "铭文数区间对应Id")
    public ResultVO getOne(Integer id){
        return ResultVOUtil.success(inscriptionService.getOne(id));
    }

    @PostMapping("/update")
    @ApiOperation("更新铭文数区间价格加成")
    @ApiImplicitParam(name = "InscriptionForm",dataType = "InscriptionForm",value = "页面铭文数区间对象")
    public ResultVO update(@Valid @RequestBody InscriptionForm inscriptionForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【更新铭文】参数错误,InscriptionForm={}", inscriptionForm);
            throw new CustomerException(bindingResult.getFieldError().getDefaultMessage());
        }
        inscriptionService.saveOrUpdate(inscriptionForm);
        return ResultVOUtil.success(null);
    }

    @PostMapping("/creat")
    @ApiOperation("新建铭文数区间价格加成")
    @ApiImplicitParam(name = "InscriptionForm",dataType = "InscriptionForm",value = "页面铭文数区间对象")
    public ResultVO creat(@Valid @RequestBody InscriptionForm inscriptionForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【新建铭文】参数错误,InscriptionForm={}", inscriptionForm);
            throw new CustomerException(bindingResult.getFieldError().getDefaultMessage());
        }
        inscriptionService.saveOrUpdate(inscriptionForm);
        return ResultVOUtil.success(null);
    }

    @PostMapping("/updateList")
    @ApiOperation("更新铭文(集合形式)")
    @ApiImplicitParam(name = "inscriptionForms",dataType = "InscriptionForm",value = "页面铭文集合")
    public ResultVO updateList(@Valid @RequestBody List<InscriptionForm> inscriptionForms, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【更新铭文】参数错误,inscriptionForms={}", inscriptionForms);
            throw new CustomerException(bindingResult.getFieldError().getDefaultMessage());
        }
        inscriptionService.updateList(inscriptionForms);
        return ResultVOUtil.success(null);
    }

}