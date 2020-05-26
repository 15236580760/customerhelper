package com.sun.entity;/*
 *ClassName:qiang
 *Pachage:com.sun.entity
 *Description:
 *@date:2020/5/1317:15
 *@AUTHOR:15037290614
 *//*
 *com.sun.entity刘战强
 *2020/5/13
 */

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@DynamicUpdate
@DynamicInsert
//战力值实体类
public class GloryPowerDiscount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int grade;//买家需要的分值
    private double discount;//折扣价格
}
