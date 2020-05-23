package com.sun.service.impl.token;

import com.sun.entity.token.SysToken;
import com.sun.repository.dao.token.ISysTokenDAO;
import com.sun.service.token.TokenLoginService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.UUID;

/**
* @Class TokenServiceImpl 
* @Description: 登录用户的身份鉴权 的实现  这里存入redis
* @version V1.0
 */
@Service("tokenLoginService")
public class TokenLoginServiceImpl implements TokenLoginService {
    @Resource(name = "ISysTokenDAO")
    private ISysTokenDAO sysTokenDAO;
    /**
     * 利用UUID创建Token(用户登录时，创建Token)
     */
    @Override
    public String createToken(String openid) {
        // 创建 GUID 对象
        UUID uuid = UUID.randomUUID();
        // 得到对象产生的ID
        String token = uuid.toString();
        // 转换为大写
        token = token.toUpperCase();
        //写入到数据表
        SysToken info=new SysToken();
        info.setToken(token);
        info.setOpenid(openid);
        sysTokenDAO.addToken(info);
        //过期时间暂时未启用
        //redisCache.expire(token, TokenConstant.TOKEN_EXPIRES_HOUR);
        return token;
    }

    @Override
    public boolean checkToken(String token) {
        return StringUtils.isNotBlank(token) && sysTokenDAO.checkToken(token)==null?true:false;
    }

    @Override
    public void deleteToken(String token) {
        sysTokenDAO.delToken(token);
    }

    @Override
    public String getOpenId(String token) {
        if (checkToken(token)) {
            return (String) sysTokenDAO.getOpenId(token);
        }
        return "";
    }
}