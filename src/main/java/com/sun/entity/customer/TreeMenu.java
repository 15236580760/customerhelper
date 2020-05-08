package com.sun.entity.customer; /**
 * Created by Happy on 2018-04-07.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：微冷的雨
 */
//树状菜单表
public class TreeMenu {

    private Integer id;  //分类编号
    private String url; // 分类地址
    private String name;  //分类名称
    private Integer parent;  //父分类编号
    private String icon;  //分类的图标
    private boolean checked; //是否选中，为了对接前端的easyUI进行数据的选择操作

    //保存子分类集合
    private List<TreeMenu> children=new ArrayList<TreeMenu>();


    public List<TreeMenu> getChildren() {
        return children;
    }

    public void setChildren(List<TreeMenu> children) {
        this.children = children;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
