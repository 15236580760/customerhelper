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
 * @date 2020/4/2510:10
 */
@Data
@Entity
@DynamicUpdate
@DynamicInsert
//套餐实体类
public class GloryCombo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String comboName;  //套餐名称
    private Double comboAddition;  //套餐系数
}