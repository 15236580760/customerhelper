package com.sun.controller.customer;

import cn.hutool.core.bean.BeanUtil;
import com.sun.entity.customer.SysShortWord;
import com.sun.form.customer.SysShortWordForm;
import com.sun.service.customer.ISysShortWordService;
import com.sun.util.ServerResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 微冷的雨
 * @date 2020/5/6 7:58
 */
@RestController
@RequestMapping("/shortword")
@Api(tags = "快捷语内容接口")
public class SysShortWordController {

    //注入Service
    @Resource(name = "sysShortWordService")
    private ISysShortWordService shortWordService;

    //01.根据类型查询快捷语
    @RequestMapping("/findShortWordByTid")
    @ApiOperation("根据类型查询快捷语")
    public Object findShortWordByTid(Integer typeid){
        List<SysShortWord> list = shortWordService.findShortWordByTid(typeid);
        ServerResponse<List<SysShortWord>> result = ServerResponse.createBySuccess(0, list);
        return result;
    }

    //02.根据关键字查询快捷语
    @ApiOperation("根据关键字查询快捷语")
    @RequestMapping("/findShortWordByWord")
    public Object findShortWordByWord(SysShortWord word){
        List<SysShortWord> list = shortWordService.findShortWordByWord(word);
        ServerResponse<List<SysShortWord>> result = ServerResponse.createBySuccess(0, list);
        return result;
    }

    // 03、添加更新一条快捷语数据
    @PostMapping("/saveShortWord")
    @ResponseBody
    @ApiOperation("添加或更新一条快捷语数据")
    public Object saveOnePrivilege(@RequestBody SysShortWordForm sysShortWordForm) throws Exception {
        try {
            if (null != sysShortWordForm) {
                SysShortWord sysShortWord = BeanUtil.toBean(sysShortWordForm, SysShortWord.class);
                shortWordService.saveShortWord(sysShortWord);
                return ServerResponse.createBySuccess();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    // 06、删除一条快捷语数据
    @PostMapping("/deleteShortWord")
    @ResponseBody
    @ApiOperation("删除一条快捷语数据")
    public Object deleteShortWord(@RequestBody SysShortWordForm sysShortWordForm) throws Exception {
        try{
            if(null != sysShortWordForm) {
                SysShortWord sysShortWord = BeanUtil.toBean(sysShortWordForm, SysShortWord.class);
                shortWordService.deleteShortWord(sysShortWord.getId());
                return ServerResponse.createBySuccess();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 07、根据typeId删除一条快捷语数据
    @PostMapping("/deleteShortWordByTypeId")
    @ResponseBody
    @ApiOperation("根据typeId删除一条快捷语数据")
    public Object deleteShortWordByTypeId(@RequestBody SysShortWordForm sysShortWordForm) throws Exception {
        try{
            if(null != sysShortWordForm) {
                SysShortWord sysShortWord = BeanUtil.toBean(sysShortWordForm, SysShortWord.class);
                shortWordService.deleteShortWordByTypeId(sysShortWord.getTypeid());
                return ServerResponse.createBySuccess();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

