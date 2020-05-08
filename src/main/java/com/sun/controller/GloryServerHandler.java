package com.sun.controller;

import com.sun.exception.CustomerException;
import com.sun.form.GloryServerForm;
import com.sun.service.GloryServerService;
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
 * @date 2020/4/2811:14
 */
@RestController
@RequestMapping("/gloryServer")
@Slf4j
@Api(tags = "王者荣耀区服价格加成页面相关接口")
public class GloryServerHandler {

    @Autowired
    private GloryServerService gloryServerService;

    @GetMapping("/list")
    @ApiOperation("查询全部王者荣耀区服价格加成")
    public ResultVO findAll(){
       return ResultVOUtil.success(gloryServerService.findAll()) ;
    }

    @GetMapping("/getOne")
    @ApiOperation("查询单一王者荣耀区服价格加成")
    @ApiImplicitParam(name = "id",dataType = "Integer",value = "王者荣耀区服对应Id")
    public ResultVO getOne(Integer id){
        return ResultVOUtil.success(gloryServerService.getOne(id)) ;
    }

    @PostMapping("/creat")
    @ApiOperation("新建王者荣耀区服价格加成")
    @ApiImplicitParam(name = "GloryServerForm",dataType = "GloryServerForm",value = "页面王者荣耀区服对象")
    public ResultVO creat(@Valid @RequestBody GloryServerForm gloryServerForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【更新区服加成】参数错误,GloryServerForm={}", gloryServerForm);
            throw new CustomerException(bindingResult.getFieldError().getDefaultMessage());
        }
        gloryServerService.saveOrUpdate(gloryServerForm);
        return ResultVOUtil.success(null) ;
    }
    @PostMapping("/update")
    @ApiOperation("更新王者荣耀区服价格加成")
    @ApiImplicitParam(name = "GloryServerForm",dataType = "GloryServerForm",value = "页面王者荣耀区服对象")
    public ResultVO update(@Valid @RequestBody GloryServerForm gloryServerForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【更新区服加成】参数错误,GloryServerForm={}", gloryServerForm);
            throw new CustomerException(bindingResult.getFieldError().getDefaultMessage());
        }
        gloryServerService.saveOrUpdate(gloryServerForm);
        return ResultVOUtil.success(null) ;
    }
    @PostMapping("/updateList")
    @ApiOperation("更新王者荣耀区服价格加成(集合形式)")
    @ApiImplicitParam(name = "gloryServerForms",dataType = "GloryServerForm",value = "页面王者荣耀区服集合")
    public ResultVO updateList(@Valid @RequestBody List<GloryServerForm> gloryServerForms, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【更新王者荣耀区服】参数错误,gloryServerForms={}", gloryServerForms);
            throw new CustomerException(bindingResult.getFieldError().getDefaultMessage());
        }
        gloryServerService.updateList(gloryServerForms);
        return ResultVOUtil.success(null);
    }
}