package com.sun.repository.dao.customer;


import com.sun.entity.customer.SysShortWord;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @author 微冷的雨
 * @date 2020/5/6 7:48
 */
@Repository
//快捷语数据操作层
public interface ISysShortWordDAO {
    //01.查询指定类型的快捷语集合
    public List<SysShortWord> findShortWordByTid(Integer tid);
    //02.快捷语查询
    public List<SysShortWord> findShortWordByWord(SysShortWord info);
}
