package com.sun.controller.customer;

import com.sun.annotation.IgnoreSecurity;
import com.sun.service.token.TokenLoginService;
import com.sun.util.ServerResponse;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author liu
 * @date 最新
 */
@Api(tags = "uuid做token令牌")
@Controller
public class UserInfoController {

    //注入service
    @Resource(name = "tokenLoginService")
    private TokenLoginService loginService;

    @RequestMapping("/login")
    @ResponseBody
    @IgnoreSecurity //忽略安全性检查
    public ServerResponse login(String openid){
        //logger.info("**** openid **** : " + openid);
        if(StringUtils.isNotBlank(openid)){
            //创建token
            String createToken = loginService.createToken(openid);
            //logger.info("**** Generate Token **** : " + createToken);
           /* Cookie cookie=new Cookie("X-Token",createToken);
            cookie.setMaxAge(3600);
            cookie.setDomain("http://localhost");
            response.addCookie(cookie);
*/
            return ServerResponse.createBySuccess("token创建成功",createToken);
        }
        return null;
    }

    /**
     * 获取openID
     * @return
     */
    @RequestMapping("/openid")
    @ResponseBody
    public ServerResponse getValue(HttpServletRequest request) {
        //String header = request.getHeader("X-Token");
       // if (header!=null&&!header.equals("")){
            return ServerResponse.createBySuccess("获取openid成功","xxxxxxxxxxxxx");
        //}
        //return null;
    }
}
