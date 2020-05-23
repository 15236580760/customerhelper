package com.sun.service.calculator;

import com.sun.entity.calculator.Dictionary;

import java.util.List;

/**
 * @author 微冷的雨
 * @date 2020/5/12 10:10
 */
public interface IDictionaryService {
    //01.定义一个查询所有字典数据的方法
    public List<Dictionary> findAll();
    //02.定义一个添加字典数据的方法
    public boolean addDicData(Dictionary info);
    //03.定义一个更新字典数据的方法  批量更新
    public boolean updateDicDate(String[] names);
    //04.定义一个删除字典数据的方法
    public boolean delDicDataById(Integer id);
}
