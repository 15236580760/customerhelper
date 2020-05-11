package com.sun.form.customer;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class TreeMenuForm {

    private Integer id;  //分类编号
    private String url; // 分类地址
    @NotEmpty(message = "名称不能为空")
    private String name;  //分类名称
    @NotEmpty(message = "父分类编号不能为空")
    private Integer parent;  //父分类编号
    private String icon;  //分类的图标
    private boolean checked; //是否选中，为了对接前端的easyUI进行数据的选择操作

}
