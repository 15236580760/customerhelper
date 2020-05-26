package com.sun.util;

/**
 * rest
* @Project: children-watch-commons 
* @Class TokenConstant 
* @Description: 接口登陆 token有效期
 */
public class TokenConstant {

    /**
     * token有效期（秒）
     * 1天
     */
    public static final long TOKEN_EXPIRES_HOUR = 86400;

    /**  存放Token的header字段 */      
    public static final String LONGIN_TOKEN_NAME = "X-Token";
}