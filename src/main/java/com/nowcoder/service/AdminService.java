package com.nowcoder.service;

import com.nowcoder.dao.AdminDAO;
import com.nowcoder.dao.AdminLoginTicketDAO;
import com.nowcoder.dao.LoginTicketDAO;
import com.nowcoder.dao.UserDAO;
import com.nowcoder.model.Admin;
import com.nowcoder.model.AdminLoginTicket;
import com.nowcoder.model.LoginTicket;
import com.nowcoder.model.User;
import com.nowcoder.util.ToutiaoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by nowcoder on 2016/7/2.
 */
@Service
public class AdminService {
    @Autowired
    AdminDAO adminDAO;

    @Autowired
    AdminLoginTicketDAO adminLoginTicketDAO;

    public Admin getAdmin(int id) {
        return adminDAO.selectById(id);
    }
    public String addLoginTicket(int adminId){
        AdminLoginTicket ticket = new AdminLoginTicket();
        Date date = new Date();
        date.setTime(date.getTime() + 1000*3600*24);
        ticket.setAdminId(adminId);
        ticket.setExpired(date);
        ticket.setStatus(0);
        ticket.setTicket(UUID.randomUUID().toString().replace("-",""));
        adminLoginTicketDAO.addTicket(ticket);
        return ticket.getTicket();
    }
    public Map<String,Object> register(String username, String password){
        Map<String,Object> map = new HashMap<String, Object>();
        if(StringUtils.isBlank(username)){
            map.put("msgname","用户名不能为空");
            return map;
        }
        if(StringUtils.isBlank(password)){
            map.put("msgpwd","密码不能为空");
            return map;
        }
        Admin admin = adminDAO.selectByName(username);

        if(admin != null){
            map.put("msgname","用户名已经被注册");
            return map;
        }
        admin = new Admin();
        admin.setName(username);
        admin.setSalt(UUID.randomUUID().toString().substring(0,5));
        admin.setPassword(ToutiaoUtil.MD5(password+admin.getSalt()));
        adminDAO.addAdmin(admin);

        String ticket = addLoginTicket(admin.getId());
        map.put("ticket",ticket);
        return map;
    }
    public Map<String,Object> adminLogin(String username, String password){
        Map<String,Object> map = new HashMap<String, Object>();
        if(StringUtils.isBlank(username)){
            map.put("msgname","用户名不能为空");
            return map;
        }
        if(StringUtils.isBlank(password)){
            map.put("msgpwd","密码不能为空");
            return map;
        }
        Admin admin = adminDAO.selectByName(username);
        System.out.print(admin.getId());
        if(admin == null){
            map.put("msgname","用户名不存在");
            return map;
        }
        if(!ToutiaoUtil.MD5(password+admin
                .getSalt()).equals(admin.getPassword())){
            map.put("msgpwd","密码不正确");
            return map;
        }

        System.out.print(admin.getId());
        String ticket = addLoginTicket(admin.getId());
        map.put("ticket",ticket);
        return map;
    }

    public void logout(String ticket){
        adminLoginTicketDAO.updateStatus(ticket,1);
    }

}
