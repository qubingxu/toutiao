package com.nowcoder.model;

import org.springframework.stereotype.Component;

/**
 * Created by nowcoder on 2016/7/3.
 */
@Component
public class HostHolder {
    private static ThreadLocal<User> users = new ThreadLocal<User>();

    public User getUser() {
        return users.get();
    }

    public void setUser(User user) {
        users.set(user);
    }

    public void clear() {
        users.remove();
    }

    private static ThreadLocal<Admin> admins = new ThreadLocal<Admin>();

    public Admin getAdmin() {
        return admins.get();
    }

    public void setAdmin(Admin admin) {
        admins.set(admin);
    }

    public void clearAdmin() {
        admins.remove();
    }
}
