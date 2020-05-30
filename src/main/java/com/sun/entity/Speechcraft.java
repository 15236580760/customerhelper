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
 * @date 2020/4/2511:18
 */
@Data
@Entity
@DynamicInsert
@DynamicUpdate
//话术实体
public class Speechcraft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;  //话术编号
    private String name;  //游戏名称
    private String speechcraft;  //话术内容
    private String imgsrc;
    private String imgalt;

}