package com.sun.service.impl.customer;

import com.sun.entity.customer.SysImg;
import com.sun.repository.dao.customer.ISysImgDao;
import com.sun.service.customer.ISysImgService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("sysImgService")

public class SysImgServiceImpl implements ISysImgService {

    //00.注入DAO
    @Resource(name="ISysImgDao")
    private ISysImgDao sysImgDao;

    @Override
    public List<SysImg> findSysImgList() {
        System.out.println(sysImgDao.findSysImgList().get(0).getName());
        return sysImgDao.findSysImgList();
    }
}
