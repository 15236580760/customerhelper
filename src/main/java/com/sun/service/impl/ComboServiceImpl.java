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

    @Override
    public List<GloryCombo> findAll() {
        return gloryComboRepsitory.findAll();
    }

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

    @Override
    public GloryCombo getOne(Integer id) {
        return gloryComboRepsitory.findById(id).get();
    }

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
}