package com.sun.service.impl;

import com.sun.entity.GloryServer;
import com.sun.form.GloryServerForm;
import com.sun.repository.GloryServerRepsitory;
import com.sun.service.GloryServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Shou
 * @Title:
 * @Package
 * @Description:
 * @date 2020/4/2811:18
 */
@Service
public class GloryServerServiceImpl implements GloryServerService {
    @Autowired
    private GloryServerRepsitory gloryServerRepsitory;

    @Override
    public List<GloryServer> findAll() {
        return gloryServerRepsitory.findAll();
    }

    @Override
    public GloryServer getOne(Integer id) {
        return gloryServerRepsitory.findById(id).get();
    }

    @Override
    public void saveOrUpdate(GloryServerForm gloryServerForm) {
        GloryServer gloryServer;
        if (gloryServerForm.getId() == null) {
            gloryServer = new GloryServer();
        } else {
            gloryServer = gloryServerRepsitory.findById(gloryServerForm.getId()).get();
        }
        gloryServer.setServerAddition(gloryServerForm.getServerAddition());
        gloryServer.setServerName(gloryServerForm.getServerName());
        gloryServerRepsitory.save(gloryServer);
    }

    @Override
    public void updateList(List<GloryServerForm> gloryServerForms) {

        for (GloryServerForm gloryServerForm : gloryServerForms) {
            if (gloryServerForm.getId() != null) {
                GloryServer gloryServer = gloryServerRepsitory.findById(gloryServerForm.getId()).get();
                gloryServer.setServerAddition(gloryServerForm.getServerAddition());
                gloryServer.setServerName(gloryServerForm.getServerName());
                gloryServerRepsitory.save(gloryServer);
            }
        }

    }
}