package com.sun.form;/*
 *ClassName:qiang
 *Pachage:com.sun.form
 *Description:
 *@date:2020/5/1317:00
 *@AUTHOR:15037290614
 *//*
 *com.sun.form刘战强
 *2020/5/13
 */

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class GloryPowerDiscountForm {

    private int id;
    @NotEmpty(message = "分值不能为空")
    private int grade;
    @NotEmpty(message = "折扣价格不能为空")
    private double discount;
}
