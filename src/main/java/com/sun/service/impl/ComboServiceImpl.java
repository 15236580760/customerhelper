package com.sun.service.impl;

import com.sun.entity.GloryCombo;
import com.sun.form.ComboForm;
import com.sun.repository.GloryComboRepsitory;
import com.sun.service.ComboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Shou
 * @Title:
 * @Package
 * @Description:
 * @date 2020/4/2715:45
 */
@Service
public class ComboServiceImpl implements ComboService {

    @Autowired
    private GloryComboRepsitory gloryComboRepsitory;

    // 查询所有套餐列表
    @Override
    public List<GloryCombo> findAll() {
        return gloryComboRepsitory.findAll();
    }

    // 添加或更新单一套餐
    @Override
    public void saveOrUpdate(ComboForm comboForm) {
        GloryCombo gloryCombo;
        if(comboForm.getId()==null){
            gloryCombo=new GloryCombo();
        }else {
            gloryCombo=gloryComboRepsitory.findById(comboForm.getId()).get();
        }
        gloryCombo.setComboAddition(comboForm.getComboAddition());
        gloryCombo.setComboName(comboForm.getComboName());

        gloryComboRepsitory.save(gloryCombo);

    }

    // 通过id得到单一套餐
    @Override
    public GloryCombo getOne(Integer id) {
        return gloryComboRepsitory.findById(id).get();
    }

    // 更新所有套餐数据
    @Override
    public void updateList(List<ComboForm> comboForms) {
        for(ComboForm comboForm : comboForms){
            if(comboForm.getId()!=null){
                GloryCombo gloryCombo=gloryComboRepsitory.findById(comboForm.getId()).get();
                gloryCombo.setComboName(comboForm.getComboName());
                gloryCombo.setComboAddition(comboForm.getComboAddition());
                gloryComboRepsitory.save(gloryCombo);
            }
        }
    }

    // 通过id删除单一套餐
    @Override
    public void deleteComboById(Integer id) {
        gloryComboRepsitory.deleteById(id);
    }
}