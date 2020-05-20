package com.sun.entity.customer;

import lombok.Data;

@Data
public class SysImg {

    private Integer id;  //图片的编号
    private String name;  //图片的名称
    private String url; //图片的地址
    private String describe;  //图片的描述
}
