package com.sun.repository.dao.customer;




import com.sun.entity.customer.TreeMenu;
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

}

