package com.sun.service.customer;

import com.sun.entity.customer.SysShortWord;
import java.util.List;

/**
 * 快捷语服务接口接口层
 * @author 微冷的雨
 * @date 2020/5/6 7:55
 */
public interface ISysShortWordService {

    //01.查询指定类型的快捷语集合
    public List<SysShortWord> findShortWordByTid(Integer tid);
    //02.快捷语查询
    public List<SysShortWord> findShortWordByWord(SysShortWord word);

}
