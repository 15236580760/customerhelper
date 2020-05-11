package com.sun.form.customer;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class SysShortWordForm {

    private  Integer id;  //快捷语编号
    @NotEmpty(message = "快捷语内容不能为空")
    private String shortword;  //快捷语内容
    @NotEmpty(message = "快捷语所属分类不能为空")
    private int typeid;  //快捷语所属分类
}
