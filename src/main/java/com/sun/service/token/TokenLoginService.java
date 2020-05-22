package com.sun.service.token;

/**
 * REST 鉴权
* @Class TokenService 
* @Description: 登录用户的身份鉴权
* @version V1.0
 */
public interface TokenLoginService {

    //01.创建token
    String createToken(String openid);  
    //02.检查token
    boolean checkToken(String token); 
    //03.获取openid
    String getOpenId(String token);
    //04.删除token
    void deleteToken(String token);
}