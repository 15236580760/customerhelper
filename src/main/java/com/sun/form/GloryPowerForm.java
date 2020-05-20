package com.sun.form;/*
 *ClassName:qiang
 *Pachage:com.sun.form
 *Description:
 *@date:2020/5/1317:08
 *@AUTHOR:15037290614
 *//*
 *com.sun.form刘战强
 *2020/5/13
 */

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class GloryPowerForm {
    private int id;
    @NotNull(message = "战力分值不能为空")
    private int power;
    @NotNull(message = "金额不能为空")
    private double money;
}
