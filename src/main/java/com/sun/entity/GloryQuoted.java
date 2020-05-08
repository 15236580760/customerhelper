package com.sun.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Shou
 * @Title:
 * @Package
 * @Description:
 * @date 2020/4/259:39
 */
@Data
@Entity
@DynamicUpdate
@DynamicInsert
//段位、区服实体类
public class GloryQuoted {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;  //流水号
    private String name; //段位名称
    private Double price;  //段位价格
    private String parent; // 类型：  区服  OR  段位
    private String time;   // 所需时间
    private String intervalValue;  //自增
    private Integer starNum;  //该段位星数
    private String serverMultiplier; //未启用
    private String levelName;  //段位名称

}