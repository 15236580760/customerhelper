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
 * @date 2020/4/2510:59
 */
@Data
@Entity
@DynamicUpdate
@DynamicInsert
//铭文实体类
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String etc; //段位
    private String addition;  //条件分区
    private String inscriptionNum;  //铭文数
}