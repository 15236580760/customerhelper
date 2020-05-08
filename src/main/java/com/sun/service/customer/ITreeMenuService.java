package com.sun.service.customer;
import com.sun.entity.customer.TreeMenu;
import java.util.List;

/**
 * 无限级菜单服务层
 */
public interface ITreeMenuService {

    //01、根据pid检索该pid下所有的子分类，包括子分类的子分类
    public List<TreeMenu> getPrivilegesByPid(int pid) throws Exception;
    //02、获取所有的一级分类集合
    public  List<TreeMenu> getTopPrivileges() throws Exception;
    //03、获取系统所有分类集合
    public List<TreeMenu> getAllPrivilege() throws  Exception;

}
