package com.sun.entity.calculator;

/**
 * @author 微冷的雨
 * @date 2020/5/12 9:44
 */

import lombok.Data;


/**
 * 定义数据字典类
 */
@Data
public class Dictionary {

    private Integer did; //流水号
    private String dname;   //名称
    private String dwords;  //内容
    private Integer dtype; //类型
    private String ddirection;  //方位   例如   1-2
}
