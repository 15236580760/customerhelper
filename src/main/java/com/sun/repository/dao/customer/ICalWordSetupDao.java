package com.sun.repository.dao.customer;


import com.sun.entity.customer.CalWordSetup;
import org.springframework.stereotype.Repository;
import java.util.List;


/**
 * 优惠话术设置dao层
 */
@Repository
public interface ICalWordSetupDao {

    // 搜索优惠话术列表
    public List<CalWordSetup> findWordSetup();

    // 通过套餐名称搜索指定优惠话术数据
    public List<CalWordSetup> findWordSetupByPackageName(String packageName);

    // 添加一条优惠话术数据
    public int saveOneWordSetup(CalWordSetup calWordSetup) throws Exception;

    // 更新一条优惠话术数据
    public void updateOneWordSetup(CalWordSetup calWordSetup) throws Exception;

}
