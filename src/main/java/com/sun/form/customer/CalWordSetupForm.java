package com.sun.form.customer;

import lombok.Data;

@Data
public class CalWordSetupForm {

    private Integer id;  //优惠话术id编号
    private String pName;  //优惠话术对应套餐名称
    private String word; //优惠话术语句
    private float price;  //优惠话术价格
}
