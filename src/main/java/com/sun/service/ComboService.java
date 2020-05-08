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
    List<GloryCombo> findAll();

    void saveOrUpdate(ComboForm comboForm);

    GloryCombo getOne(Integer id);

    void updateList(List<ComboForm> comboForms);
}