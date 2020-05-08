package com.sun.controller;

import com.sun.service.UserService;
import com.sun.vo.ResultVO;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response, String userName, String userPwd) throws IOException {
        ModelAndView modelAndView;
        ResultVO resultVO = userService.checkUser(userName, userPwd);
        if (resultVO.getCode().equals(1)) {
            modelAndView = new ModelAndView("redirect:http://39.100.147.44:30003/login", "user", "");
            return modelAndView;
            // response.sendRedirect("http://39.100.147.44:30003/login");
        }
       modelAndView = new ModelAndView("redirect:http://39.100.147.44:30003/index","user","");
      //  modelAndView=new ModelAndView("redirect:http://39.100.147.44:30003/index");
      //  modelAndView.setViewName("http://39.100.147.44:30003/index");
     //   modelAndView.addObject("user",resultVO);
        return modelAndView;

    }


}