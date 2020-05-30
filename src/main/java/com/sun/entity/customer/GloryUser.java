package com.sun.entity.customer;

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
//折扣实体类
public class GloryUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String  id;// 用户id

    private String  username;//用户名字

    private String  phone;//用户手机号

    private String  pass;//用户密码

    private String  email;//用户邮箱
}