package com.sun.controller.customer;


import com.sun.entity.customer.CalWordSetup;
import com.sun.entity.customer.SysImg;
import com.sun.service.customer.ISysImgService;
import com.sun.util.ServerResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/sysImg")
@Api(tags = "文图接口")
public class SysImgController {

    // 注入 service
    @Resource(name = "sysImgService")
    private ISysImgService sysImgService;

    // 搜索图文列表
    @GetMapping("/findImgList")
    @ResponseBody
    @ApiOperation("搜索优惠话术列表")
    public Object findImgList() {
        List<SysImg> list = sysImgService.findSysImgList();
        return ServerResponse.createBySuccess(list);
    }


    // 上传图片的接口
    // 03、添加更新一条话术数据
    @ApiOperation("上传图片")
    @PostMapping("/uploadImg")
    @ResponseBody
    public Object uploadImg(int a ) throws Exception {

        return null;
    }


}



















