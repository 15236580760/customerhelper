package com.sun.entity.token;

import lombok.Data;

/**
 * @author 微冷的雨
 * @date 2020/5/14 8:54
 */
//token内容相关
@Data
public class SysToken {
    private Integer id;
    private String token;
    private String openid;

}
