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

    //03、添加一条快捷语数据
    public int saveShortWord(SysShortWord sysShortWord) throws Exception;

    //04、更新一条快捷语数据
    public void updateShortWord(SysShortWord sysShortWord) throws Exception;

    //05、删除一条快捷语数据
    public void deleteShortWord(Integer id) throws Exception;

    //06、根据typeId删除快捷语数据
    public void deleteShortWordByTypeId(Integer id) throws Exception;


}
