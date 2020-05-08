package com.sun.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Shou
 * @Title:
 * @Package
 * @Description:
 * @date 2020/4/2516:13
 */
@Data
@Entity
//区服基数比例表
public class GloryServer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String serverName;   //区服名称
    private Double serverAddition;  //比例

}