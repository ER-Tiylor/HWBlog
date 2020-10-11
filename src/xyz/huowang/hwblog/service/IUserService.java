package xyz.huowang.hwblog.service;

import xyz.huowang.hwblog.domain.User;

/**
 * @author ：HW
 * @date ：Created in 2020/9/8 22:36
 * @description：TODO
 * @version: 1.0
 */
public interface IUserService {

    /**
     * 提供注册服务
     * @param user
     * @throws
     */
    void registerUser(User user) throws Exception;
    /**
     * 提供登录服务
     * @param userEmail
     * @param userPwd
     * @return
     */
    User loginUser(String userEmail,String userPwd) throws Exception;
}
