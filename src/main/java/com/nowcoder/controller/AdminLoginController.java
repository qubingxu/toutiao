/*
package com.nowcoder.controller;

import com.nowcoder.model.ViewObject;
import com.nowcoder.model.Voteoption;
import com.nowcoder.service.AdminService;
import com.nowcoder.service.UserService;
import com.nowcoder.service.VoteService;
import com.nowcoder.util.ToutiaoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Controller
public class AdminLoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    UserService userService;
    @Autowired
    AdminService adminService;

    @RequestMapping(path = {"/reg/"}, method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String reg(Model model, @RequestParam("username") String username, @RequestParam("password") String password, @RequestParam(value = "rember",defaultValue = "0") int remeberme, HttpServletResponse response) {

        try {
            Map<String,Object> map = adminService.register(username,password);
            if(map.containsKey("ticket")){
                Cookie cookie = new Cookie("ticket",map.get("ticket").toString());
                cookie.setPath("/");
                if (remeberme>0)
                {
                    cookie.setMaxAge(3600*24*7);
                }
                response.addCookie(cookie);

                return ToutiaoUtil.getJSONString(0,"注册成功");
            }
            else {
                return ToutiaoUtil.getJSONString(1, map);
            }
        }
        catch (Exception e){
            logger.error("注册异常"+e.getMessage());
            return ToutiaoUtil.getJSONString(1,"注册异常");
        }

    }
    @RequestMapping(path = {"/login/"}, method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String login(Model model, @RequestParam("username") String username,@RequestParam("password") String password,@RequestParam(value = "rember",defaultValue = "0") int remeberme,HttpServletResponse response) {

        try {
            Map<String,Object> map = adminService.adminLogin(username,password);
            if(map.containsKey("ticket")){
                Cookie cookie = new Cookie("ticket",map.get("ticket").toString());
                cookie.setPath("/");
                if (remeberme>0)
                {
                    cookie.setMaxAge(3600*24*7);
                }
                response.addCookie(cookie);
                return ToutiaoUtil.getJSONString(0,"登陆成功");
            }
            else {
                return ToutiaoUtil.getJSONString(1, map);
            }
        }
        catch (Exception e){
            logger.error("登陆异常"+e.getMessage());
            return ToutiaoUtil.getJSONString(1,"登陆异常");
        }

    }
    @RequestMapping(path = {"/logout/"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String logout(@CookieValue("ticket") String ticket){
        adminService.logout(ticket);
        return "/";
    }

}
*/
