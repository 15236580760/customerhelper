package com.sun.service;

import com.sun.entity.GloryServer;
import com.sun.form.GloryServerForm;

import java.util.List;

/**
 * @author Shou
 * @Title:
 * @Package
 * @Description:
 * @date 2020/4/2811:17
 */
public interface GloryServerService {
    List<GloryServer> findAll();

    GloryServer getOne(Integer id);

    void saveOrUpdate(GloryServerForm gloryServerForm);

    void updateList(List<GloryServerForm> gloryServerForms);
}