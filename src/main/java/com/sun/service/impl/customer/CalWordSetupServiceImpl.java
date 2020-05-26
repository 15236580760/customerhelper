package com.sun.service.impl.customer;

import com.sun.entity.customer.CalWordSetup;
import com.sun.repository.dao.customer.ICalWordSetupDao;
import com.sun.service.customer.ICalWordSetupService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 优惠话术接口实现层
 */
@Service("calWordSetupService")
public class CalWordSetupServiceImpl implements ICalWordSetupService {

    //00.注入DAO
    @Resource(name="ICalWordSetupDao")
    private ICalWordSetupDao calWordSetupDao;

    // 搜索优惠话术列表
    @Override
    public List<CalWordSetup> findWordSetup() {
        return calWordSetupDao.findWordSetup();
    }

    // 根据套餐查找对应优惠话术
    @Override
    public List<CalWordSetup> findWordSetupByPackageName(String packageName) {
        return calWordSetupDao.findWordSetupByPackageName(packageName);
    }

    // 添加或更新一条优惠话术数据
    @Override
    public int saveWordSetup(CalWordSetup calWordSetup) throws Exception {
        if (null == calWordSetup.getId()) { // 新建操作
            calWordSetupDao.saveOneWordSetup(calWordSetup);
        } else { // 更新操作
            calWordSetupDao.updateOneWordSetup(calWordSetup);
        }
        return calWordSetup.getId();
    }

}
