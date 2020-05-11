package com.sun.entity.customer;

public class ShortWordAndTreeName {

    private Integer id;  //树状分类编号
    private String name;  //树状分类名称
    private Integer sid; //快捷语编号
    private String shortWord;  //快捷语内容
    private int typeId;  //快捷语所属分类

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getShortWord() {
        return shortWord;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setShortWord(String shortWord) {
        this.shortWord = shortWord;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
}
