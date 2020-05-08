package com.sun.controller.customer;

import com.sun.entity.customer.SysShortWord;
import com.sun.service.customer.ISysShortWordService;
import com.sun.util.ServerResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 微冷的雨
 * @date 2020/5/6 7:58
 */
@RestController
@RequestMapping("/shortword")
public class SysShortWordController {

    //注入Service
    @Resource(name = "sysShortWordService")
    private ISysShortWordService shortWordService;

    //01.根据类型查询快捷语
    @RequestMapping("/findShortWordByTid")
    public Object findShortWordByTid(Integer typeid){
        List<SysShortWord> list = shortWordService.findShortWordByTid(typeid);
        ServerResponse<List<SysShortWord>> result = ServerResponse.createBySuccess(0, list);
        return result;
    }

    //02.根据关键字查询快捷语
    @RequestMapping("/findShortWordByWord")
    public Object findShortWordByWord(SysShortWord word){
        List<SysShortWord> list = shortWordService.findShortWordByWord(word);
        ServerResponse<List<SysShortWord>> result = ServerResponse.createBySuccess(0, list);
        return result;
    }

}

