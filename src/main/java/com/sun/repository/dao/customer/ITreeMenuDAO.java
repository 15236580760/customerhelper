package com.sun.repository.dao.customer;




import com.sun.entity.customer.ShortWordAndTreeName;
import com.sun.entity.customer.TreeMenu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Happy on 2018-04-07.
 */
//无限级分类数据操作层
@Repository
public interface ITreeMenuDAO {

   //01、根据pid检索该pid下所有的子分类，包括子分类的子分类
   public List<TreeMenu> getPrivilegesByPid(int pid) throws Exception;
   //02、获取所有的一级分类集合
   public  List<TreeMenu> getTopPrivileges() throws Exception;
   //03、获取系统所有分类集合
   public List<TreeMenu> getAllPrivilege() throws  Exception;

   //04、添加一条树状短语数据
   public int saveOnePrivilege(TreeMenu treeMenu) throws Exception;

   //05、更新一条树状短语数据
   public void updateOnePrivilege(TreeMenu treeMenu) throws Exception;

   //06、删除一条树状短语数据
   public void deleteOnePrivilege(Integer id) throws Exception;

   //06、检索快捷语对应树状节点标题
   public List<ShortWordAndTreeName> getPrivilegeAndShortWord() throws Exception;

}

