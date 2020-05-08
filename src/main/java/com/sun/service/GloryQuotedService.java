package com.sun.service;

import com.sun.entity.GloryQuoted;
import com.sun.form.GloryQuotedForm;

import java.util.List;

/**
 * @author Shou
 * @Title:
 * @Package
 * @Description:
 * @date 2020/4/2813:46
 */
public interface GloryQuotedService {
    GloryQuoted getOne(Integer id);

    List<GloryQuoted> findAllByParent();

    void saveOrUpdate(GloryQuotedForm gloryQuotedForm);

    void updateList(List<GloryQuotedForm> gloryQuotedForms);
}