package com.sun.controller.customer;/**
 * Created by Happy on 2018-04-04.
 */
import cn.hutool.core.bean.BeanUtil;
import com.sun.entity.customer.ShortWordAndTreeName;
import com.sun.entity.customer.TreeMenu;
import com.sun.form.customer.TreeMenuForm;
import com.sun.service.customer.ITreeMenuService;
import com.sun.util.ResultVOUtil;
import com.sun.util.ServerResponse;
import com.sun.vo.ResultVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 作者：微冷的雨
 */
@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/treemenu")
public class TreeMenuController {
    //01.注入菜单的Service
    @Resource(name = "treeMenuService")
    private ITreeMenuService treeMenuService;

    //02.根据分类编号，获取该分类的所有子分类集合
    @ResponseBody
    @RequestMapping("/getAllPrivilegesById")
    public Object getAllPrivilegesById(int pid) throws Exception {
        List<TreeMenu> list = treeMenuService.getPrivilegesByPid(pid);
        return list;
    }

    //03.获取一级菜单的集合
    @ResponseBody
    @RequestMapping("/getAllTopPrivileges")
    public Object getAllTopPrivileges() throws Exception {
        List<TreeMenu> topPrivileges = treeMenuService.getTopPrivileges();
        return topPrivileges;
    }

    //04.返回系统中所有菜单的json格式   @RequestParam(required = false,defaultValue = "1") int rid
    @RequestMapping("/getAllMenusJson")
    @ResponseBody
    public ResultVO getAllMenusJson() throws Exception {

        //新的容器 保存有父子关系的权限
        List<TreeMenu> rootMenus=new ArrayList<TreeMenu>();
        try {
            List<TreeMenu> privilegeList = treeMenuService.getAllPrivilege();
            for (TreeMenu item:privilegeList){//原始平级容器
                TreeMenu childMenu=item;//接收每一项
                int pid = childMenu.getParent(); //当前项目的pid  父分类编号  1
                if (pid==0){  //如果是0，证明是顶级分类
                    rootMenus.add(item); //作为单列集合的直接对象
                }else{
                    for (TreeMenu innerMenu:privilegeList){  //扫描整个内存中的数据
                        Integer id = innerMenu.getId(); //1
                        if (id==pid){
                            TreeMenu parentMenu=innerMenu;
                            parentMenu.getChildren().add(childMenu);
                            break;
                        }
                    }
                }
            }
            return ResultVOUtil.success(rootMenus);
//            return rootMenus;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 05、添加更新一条树状快捷语数据
    @PostMapping("/saveOnePrivilege")
    @ResponseBody
    public Object saveOnePrivilege(@RequestBody TreeMenuForm treeMenuForm) throws Exception {

        try {
            if (null != treeMenuForm) {
                TreeMenu treeMenu = BeanUtil.toBean(treeMenuForm, TreeMenu.class);
                treeMenuService.saveOnePrivilege(treeMenu);
                return ServerResponse.createBySuccess();
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return ResultVOUtil.error(null);
    }

    // 06、删除一条树状快捷语数据
    @PostMapping("/deleteOnePrivilege")
    @ResponseBody
    public Object deleteOnePrivilege(@RequestBody TreeMenuForm treeMenuForm) throws Exception {
        try{
            if (null != treeMenuForm) {
                TreeMenu treeMenu = BeanUtil.toBean(treeMenuForm, TreeMenu.class);
                treeMenuService.deleteOnePrivilege(treeMenu.getId());
                return ServerResponse.createBySuccess();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 06、检索快捷语对应树状节点标题
    @RequestMapping("/getPrivilegeAndShortWord")
    @ResponseBody
    public ResultVO getPrivilegeAndShortWord() throws Exception {
        List<ShortWordAndTreeName> list = treeMenuService.getPrivilegeAndShortWord();
        return ResultVOUtil.success(list);
    }


}
