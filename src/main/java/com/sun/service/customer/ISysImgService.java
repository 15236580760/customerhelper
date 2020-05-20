package com.sun.service.customer;

import com.sun.entity.customer.SysImg;

import java.util.List;

public interface ISysImgService {

    //01.查询图文列表
    public List<SysImg> findSysImgList();
}
