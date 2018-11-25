package com.nowcoder.interceptor;

import com.nowcoder.dao.AdminDAO;
import com.nowcoder.dao.AdminLoginTicketDAO;
import com.nowcoder.dao.LoginTicketDAO;
import com.nowcoder.dao.UserDAO;
import com.nowcoder.model.*;
import com.nowcoder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import sun.rmi.runtime.Log;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Component
public class PassportInterceptor implements HandlerInterceptor {

    @Autowired
    private LoginTicketDAO loginTicketDAO;
    @Autowired
    private AdminLoginTicketDAO adminLoginTicketDAO;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private AdminDAO adminDAO;
    @Autowired
    private HostHolder hostHolder;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String ticket = null;
        if(httpServletRequest.getCookies()!=null){
            for(Cookie cookie : httpServletRequest.getCookies()){
                if(cookie.getName().equals("ticket")){
                     ticket = cookie.getValue();
                     break;
                }
            }
        }
        if(ticket != null){
            LoginTicket loginTicket = loginTicketDAO.selectByTicket(ticket);
            AdminLoginTicket adminLoginTicket = adminLoginTicketDAO.selectByTicket(ticket);
            if(loginTicket == null ||loginTicket.getExpired().before(new Date())||loginTicket.getStatus()!=0)
            {
                if(adminLoginTicket == null ||adminLoginTicket.getExpired().before(new Date())||adminLoginTicket.getStatus()!=0)
                {
                    return true;
                }
            }
            if(loginTicket!=null){

                User user = userDAO.selectById(loginTicket.getUserId());
                if(user!=null)
                    hostHolder.setUser(user);
            }
            else if (adminLoginTicket!=null){
                Admin admin = adminDAO.selectById(adminLoginTicket.getAdminId());
                if(admin!=null){
                    hostHolder.setAdmin(admin);
                }
            }

        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        if (modelAndView!=null&&hostHolder.getUser()!=null){
            modelAndView.addObject("user",hostHolder.getUser());
        }
        else if (modelAndView!=null&&hostHolder.getAdmin()!=null){
            modelAndView.addObject("admin",hostHolder.getAdmin());
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        hostHolder.clear();
    }
}
