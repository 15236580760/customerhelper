package com.sun.controller.customer;


import cn.hutool.core.bean.BeanUtil;
import com.sun.entity.customer.CalWordSetup;
import com.sun.form.customer.CalWordSetupForm;
import com.sun.service.customer.ICalWordSetupService;
import com.sun.util.ServerResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 优惠话术设置接口类
 */
@RestController
@RequestMapping("/wordSetup")
public class CalWordSetupController {

    // 注入 service
    @Resource(name = "calWordSetupService")
    private ICalWordSetupService calWordSetupService;


    // 搜索优惠话术列表
    @GetMapping("/findWordSetup")
    @ResponseBody
    public Object findWordSetup() {
        List<CalWordSetup> list = calWordSetupService.findWordSetup();
        return ServerResponse.createBySuccess(list);
    }

    // 根据套餐类型查询对应优惠话术
    @RequestMapping("/findWordSetupByPackageName")
    @ResponseBody
    public Object findWordSetupByPackageName(@RequestBody CalWordSetupForm calWordSetupForm) {
        if (null != calWordSetupForm) {
            CalWordSetup calWordSetup = BeanUtil.toBean(calWordSetupForm, CalWordSetup.class);
            List<CalWordSetup> list = calWordSetupService.findWordSetupByPackageName(calWordSetup.getPName());
            return ServerResponse.createBySuccess(list);
        }
        return null;
    }

    // 03、添加更新一条话术数据
    @PostMapping("/saveOneWordSetup")
    @ResponseBody
    public Object saveOneWordSetup(@RequestBody CalWordSetupForm calWordSetupForm) throws Exception {
        try {
            if (null != calWordSetupForm) {
                CalWordSetup calWordSetup = BeanUtil.toBean(calWordSetupForm, CalWordSetup.class);

                System.out.println(calWordSetup.getId()+ calWordSetup.getWord()+calWordSetup.getPrice()+calWordSetup.getPName());


                calWordSetupService.saveWordSetup(calWordSetup);
                return ServerResponse.createBySuccess();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }



}