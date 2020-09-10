package xyz.huowang.hwblog.service;

import xyz.huowang.hwblog.domain.User;
import xyz.huowang.hwblog.exception.UserExistException;

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
     * @throws UserExistException
     */
    void registerUser(User user) throws UserExistException;
    /**
     * 提供登录服务
     * @param userName
     * @param userPwd
     * @return
     */
    User loginUser(String userName, String userPwd);
}
