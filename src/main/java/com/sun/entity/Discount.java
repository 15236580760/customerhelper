package com.sun.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Shou
 * @Title:
 * @Package
 * @Description:
 * @date 2020/4/279:58
 */
@Data
@Entity
@DynamicUpdate
@DynamicInsert
//折扣实体类
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer priceRange; //价格区间
    private Integer favourable;  //打折金额
    private String gameName;  //游戏名称
}