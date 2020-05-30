package com.sun.controller.customer;

import com.sun.entity.customer.GloryUser;
import com.sun.exception.CustomerException;
import com.sun.service.customer.UserService;
import com.sun.util.ResultVOUtil;
import com.sun.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

/**
 * @author Shou
 * @Title:
 * @Package
 * @Description:
 * @date 2020/4/3016:05
 */
@RestController
@RequestMapping("/user")
@Slf4j
@Api(tags = "用户相关接口")
public class UserHandler {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public ResultVO login(HttpServletRequest request, HttpServletResponse response, String userName, String userPwd) throws IOException {
//        ModelAndView modelAndView;
        int num = userService.checkUser(userName, userPwd);
        System.out.println("您已经访问到了后台接口");
//        if (num==0) {
//            modelAndView = new ModelAndView("redirect:http://localhost:30003/login", "user", "");
//            return modelAndView;
//            // response.sendRedirect("http://39.100.147.44:30003/login");
//        }
//       modelAndView = new ModelAndView("redirect:http://localhost:30003/index","user","");
      //  modelAndView=new ModelAndView("redirect:http://39.100.147.44:30003/index");
      //  modelAndView.setViewName("http://39.100.147.44:30003/index");
     //   modelAndView.addObject("user",resultVO);
        return ResultVOUtil.success(num);

    }


    @PostMapping("/add")
    @ApiOperation("注册用户")
    @ApiImplicitParam(name = "gloryUser",dataType = "GloryUser",value = "添加用户")
    @ResponseBody
    public ResultVO add(@Valid @RequestBody GloryUser gloryUser ,BindingResult bindingResult) throws CustomerException {
        if(bindingResult.hasErrors()){
            log.error("【更新折扣】参数错误,DiscountForm={}", gloryUser);
            throw new CustomerException(bindingResult.getFieldError().getDefaultMessage());
        }

        return ResultVOUtil.success(userService.adduser(gloryUser));
    }



}