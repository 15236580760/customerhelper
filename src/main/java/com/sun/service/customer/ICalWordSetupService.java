package com.sun.service.customer;

import com.sun.entity.customer.CalWordSetup;

import java.util.List;

public interface ICalWordSetupService {

    // 搜索优惠话术列表
    public List<CalWordSetup> findWordSetup();

    // 通过套餐名称搜索指定优惠话术数据
    public List<CalWordSetup> findWordSetupByPackageName(String packageName);

    // 添加或更新一条优惠话术数据
    public int saveWordSetup(CalWordSetup calWordSetup) throws Exception;

}
