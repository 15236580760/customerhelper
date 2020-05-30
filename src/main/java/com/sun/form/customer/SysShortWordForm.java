package com.sun.form.customer;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class SysShortWordForm {

    private  Integer id;  //快捷语编号
    private String shortword;  //快捷语内容
    private String imgsrc; // 图片地址
    private String imgalt; // 图片描述
    private int typeid;  //快捷语所属分类
}
