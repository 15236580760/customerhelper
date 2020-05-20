package com.sun.service;

import com.sun.entity.GloryCombo;
import com.sun.form.ComboForm;

import java.util.List;

/**
 * @author Shou
 * @Title:
 * @Package
 * @Description:
 * @date 2020/4/2715:42
 */
public interface ComboService {

    // 查询所有套餐列表
    List<GloryCombo> findAll();

    // 保存或更新单一套餐
    void saveOrUpdate(ComboForm comboForm);

    // 通过id得到单一套餐
    GloryCombo getOne(Integer id);

    // 更新套餐列表
    void updateList(List<ComboForm> comboForms);

    // 通过id删除单一套餐
    void deleteComboById(Integer id);
}