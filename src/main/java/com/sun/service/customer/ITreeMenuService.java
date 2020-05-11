package com.sun.service.customer;
import com.sun.entity.customer.ShortWordAndTreeName;
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

    //04、添加更新一条树状短语数据
    public int saveOnePrivilege(TreeMenu treeMenu) throws Exception;

    //05、删除一条树状短语数据
    public void deleteOnePrivilege(Integer id) throws Exception;

    //06、检索快捷语对应树状节点标题
    public List<ShortWordAndTreeName> getPrivilegeAndShortWord() throws Exception;

}
