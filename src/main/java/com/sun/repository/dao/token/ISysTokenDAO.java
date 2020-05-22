package com.sun.repository.dao.token;

import com.sun.entity.token.SysToken;
import org.springframework.stereotype.Repository;

/**
 * @author 微冷的雨
 * @date 2020/5/14 8:55
 */
@Repository
public interface ISysTokenDAO {
    //01.定义一个添加token的方法
    public boolean addToken(SysToken info);
    //02.定义一个检查token的方法
    public SysToken checkToken(String token);
    //03.定义一个删除token的方法
    public boolean delToken(String token);
    //04.定义一个获取openid的方法
    public String getOpenId(String token);
    //05.
}
