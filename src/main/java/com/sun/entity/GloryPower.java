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
import java.math.BigDecimal;

@Data
@Entity
@DynamicUpdate
@DynamicInsert
//战力值实体类
public class GloryPower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int power;//战力值
    private BigDecimal money;//战力价钱
}
