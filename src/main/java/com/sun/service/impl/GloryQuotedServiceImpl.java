package com.sun.service.impl;

import com.sun.entity.GloryQuoted;
import com.sun.form.GloryQuotedForm;
import com.sun.repository.GloryQuotedRepsitory;
import com.sun.service.GloryQuotedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Shou
 * @Title:
 * @Package
 * @Description:
 * @date 2020/4/2813:50
 */
@Service
public class GloryQuotedServiceImpl implements GloryQuotedService {
    @Autowired
    private GloryQuotedRepsitory gloryQuotedRepsitory;

    @Override
    public GloryQuoted getOne(Integer id) {
        return gloryQuotedRepsitory.findById(id).get();
    }

    @Override
    public List<GloryQuoted> findAllByParent() {
        return gloryQuotedRepsitory.findAllByParent("1");
    }

    @Override
    public void saveOrUpdate(GloryQuotedForm gloryQuotedForm) {

        GloryQuoted gloryQuoted;

        if(gloryQuotedForm.getId()==null){
            gloryQuoted=new GloryQuoted();
        }else {
            gloryQuoted=gloryQuotedRepsitory.findById(gloryQuotedForm.getId()).get();
        }
        gloryQuoted.setIntervalValue(gloryQuotedForm.getIntervalValue());
        gloryQuoted.setLevelName(gloryQuotedForm.getLevelName());
        gloryQuoted.setName(gloryQuoted.getName());
        gloryQuoted.setParent(gloryQuoted.getParent());
        gloryQuoted.setStarNum(gloryQuotedForm.getStarNum());
        gloryQuoted.setPrice(gloryQuotedForm.getPrice());
        gloryQuoted.setServerMultiplier(gloryQuotedForm.getServerMultiplier());
        gloryQuoted.setTime(gloryQuotedForm.getTime());

        gloryQuotedRepsitory.save(gloryQuoted);

    }

    @Override
    public void updateList(List<GloryQuotedForm> gloryQuotedForms) {

        for(GloryQuotedForm gloryQuotedForm : gloryQuotedForms){
            if(gloryQuotedForm.getId()!=null){
                GloryQuoted gloryQuoted=gloryQuotedRepsitory.findById(gloryQuotedForm.getId()).get();
                gloryQuoted.setIntervalValue(gloryQuotedForm.getIntervalValue());
                gloryQuoted.setLevelName(gloryQuotedForm.getLevelName());
                gloryQuoted.setName(gloryQuoted.getName());
                gloryQuoted.setParent(gloryQuoted.getParent());
                gloryQuoted.setStarNum(gloryQuotedForm.getStarNum());
                gloryQuoted.setPrice(gloryQuotedForm.getPrice());
                gloryQuoted.setServerMultiplier(gloryQuotedForm.getServerMultiplier());
                gloryQuoted.setTime(gloryQuotedForm.getTime());

                gloryQuotedRepsitory.save(gloryQuoted);
            }
        }

    }
}