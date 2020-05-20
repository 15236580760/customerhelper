package com.sun.repository.dao.customer;

import com.sun.entity.customer.SysImg;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ISysImgDao {

    //01.查询图文列表
    public List<SysImg> findSysImgList();
}
