package com.sun.service.impl.customer;/**
 * Created by Happy on 2018-04-07.
 */

import com.sun.entity.customer.ShortWordAndTreeName;
import com.sun.entity.customer.TreeMenu;
import com.sun.repository.dao.customer.ITreeMenuDAO;
import com.sun.service.customer.ITreeMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 作者：微冷的雨
 *
 * @create 2018-04-07
 * 博客地址:www.cnblogs.com/weilengdeyu
 */
@Service("treeMenuService")
public class TreeMenuServiceImpl implements ITreeMenuService {
    @Resource(name = "ITreeMenuDAO")
    private ITreeMenuDAO privilegeDAO;

    @Override
    public List<TreeMenu> getPrivilegesByPid(int pid) throws Exception {
        return privilegeDAO.getPrivilegesByPid(pid);
    }

    @Override
    public List<TreeMenu> getTopPrivileges() throws Exception {
        return privilegeDAO.getTopPrivileges();
    }



    public List<TreeMenu> getAllPrivilege() throws Exception {
        return privilegeDAO.getAllPrivilege();
    }

    @Override
    public int saveOnePrivilege(TreeMenu treeMenu) throws Exception {
        // 保存操作
        if (null == treeMenu.getId()) {
            privilegeDAO.saveOnePrivilege(treeMenu);
        } else { // 更新操作
            privilegeDAO.updateOnePrivilege(treeMenu);
        }
        return treeMenu.getId();
    }

    @Override
    public void deleteOnePrivilege(Integer id) throws Exception {
        privilegeDAO.deleteOnePrivilege(id);
    }

    @Override
    public List<ShortWordAndTreeName> getPrivilegeAndShortWord() throws Exception {
        return privilegeDAO.getPrivilegeAndShortWord();
    }

    public ITreeMenuDAO getPrivilegeDAO() {
        return privilegeDAO;
    }

    public void setPrivilegeDAO(ITreeMenuDAO privilegeDAO) {
        this.privilegeDAO = privilegeDAO;
    }
}
