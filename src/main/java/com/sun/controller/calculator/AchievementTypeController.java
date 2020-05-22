package com.sun.controller.calculator;

import com.sun.entity.calculator.Dictionary;
import com.sun.service.calculator.IDictionaryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 微冷的雨
 * @date 2020/5/12 9:34
 */
@RestController
@RequestMapping("/archieve")
public class AchievementTypeController {
    //01.植入Service层实例
    @Resource(name = "dictionaryService")
    private IDictionaryService dictionaryService;

    //02.写一个查询所有字典数的方法
    @RequestMapping("/list")
    public Object findAllDics()
    {
        List<Dictionary> list = dictionaryService.findAll();
        return list;
    }

}
