package com.sun.entity.customer;

/**
 * @author 微冷的雨
 * @date 2020/5/6 7:42
 */
//快捷语实体类
public class SysShortWord {

    private  Integer id;  //快捷语编号
    private String shortword;  //快捷语内容
    private int typeid;  //快捷语所属分类

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShortword() {
        return shortword;
    }

    public void setShortword(String shortword) {
        this.shortword = shortword;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }
}
