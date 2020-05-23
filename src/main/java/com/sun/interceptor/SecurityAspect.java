package com.sun.interceptor;

import com.sun.annotation.IgnoreSecurity;
import com.sun.exception.TokenLoginException;
import com.sun.service.token.TokenLoginService;
import com.sun.util.HttpContextUtils;
import com.sun.util.TokenConstant;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 *
* @Class SecurityAspect 安全检查切面(是否登录检查) 
* @Description: 通过验证Token维持登录状态
 */
/*@Component
@Aspect*/
public class SecurityAspect {

    /** Log4j日志处理 */
    private static final Logger log = Logger.getLogger(SecurityAspect.class);
    
    @Autowired
    private TokenLoginService tokenLoginService;

    
    /**
     * 環繞通知 前後都通知 
     * aop检测注解为 RequestMapping 就调用此方法
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public Object execute(ProceedingJoinPoint pjp) throws Throwable {
        // 从切点上获取目标方法
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        log.info("methodSignature : " + methodSignature);
        Method method = methodSignature.getMethod();
        log.info("Method : " + method.getName() + " : "
                + method.isAnnotationPresent(IgnoreSecurity.class));
        // 若目标方法忽略了安全性检查,则直接调用目标方法
        if(method.isAnnotationPresent(IgnoreSecurity.class)){
            // 调用目标方法
            return pjp.proceed();
        }
        //忽略 api接口测试安全性检查
        if("getDocumentation".equalsIgnoreCase(method.getName())){
            // 调用目标方法
            return pjp.proceed();
        }
        // 从 request header 中获取当前 token
        String token = HttpContextUtils.getHttpServletRequest().getHeader(TokenConstant.LONGIN_TOKEN_NAME);
        // 检查 token 有效性
        if(!tokenLoginService.checkToken(token)){
            String message = String.format("token [%s] is invalid", token);
            log.info("message : " + message);
            throw new TokenLoginException(message);
        }
        //每次调用接口就刷新过期时间
        //redisCache.expire(token, TokenConstant.TOKEN_EXPIRES_HOUR);
        // 调用目标方法
        return pjp.proceed();
    }
}