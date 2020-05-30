package com.sun.entity.customer;

/**
 * @author 微冷的雨
 * @date 2020/5/6 7:42
 */
//快捷语实体类
public class SysShortWord {

    private  Integer id;  //快捷语编号
    private String shortword;  //快捷语内容
    private String imgsrc; // 图片在oss服务器上的地址
    private String imgalt; // 图片描述
    private int typeid;  //快捷语所属分类

    public void setId(Integer id) {
        this.id = id;
    }

    public void setShortword(String shortword) {
        this.shortword = shortword;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public void setImgalt(String imgalt) {
        this.imgalt = imgalt;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public Integer getId() {
        return id;
    }

    public String getShortword() {
        return shortword;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public String getImgalt() {
        return imgalt;
    }

    public int getTypeid() {
        return typeid;
    }
}
