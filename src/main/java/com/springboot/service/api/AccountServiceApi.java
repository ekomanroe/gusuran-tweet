package com.springboot.service.api;

/**
 * Created by eko.j.manurung on 10/13/2016.
 */
public interface AccountServiceApi {

    int login(String username, String password);

    boolean changePassword(Integer id, String oldPassword, String newPassword);

    String resetPassword(Integer id);
}
