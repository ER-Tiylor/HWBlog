package xyz.huowang.hwblog.dao;

import xyz.huowang.hwblog.domain.User;

/**
 * @author ：HW
 * @date ：Created in 2020/9/8 22:28
 * @description：TODO
 * @version: 1.0
 */
public interface IUserDao {

    /**
     * 用户登录（需要传入两个参数）
     * @param: username 用户名
     * @param: password 密码
     * @return:
     * @throws:
     */
    User userLogin(String userName, String passWord) throws Exception;

    /**
     * 添加用户
     * @param: user
     * @return:  int
     * @throws: Exception
     */
    int addUser(User user) throws Exception;

    /**
     * 用于用户注册
     * @param: user
     * @return:  int
     * @throws: Exception
     */
    int saveUser(User user) throws Exception;

    /**
     * 根据用户名查找用户
     * @param: username 用户名
     * @return:  用户对象
     * @throws:
     */
    void deleteUser(String userName) throws Exception;

    /**
     * 修改用户信息（需要传入两个参数）
     * @param: username 用户名
     * @param: password 密码
     * @return:  用户对象
     * @throws: SQLException
     */
    int updateUser(User user) throws Exception;

    /**
     * 查询用户信息（需要传入两个参数）
     * @param: userID 用户ID
     * @return:  用户对象
     * @throws: Exception
     */
    User queryUser(String userID) throws Exception;

    /**
     * 根据邮箱查看用户是否已经注册
     * @param: email
     * @return:  用户对象
     * @throws:
     */
    User isExist(String email) throws Exception;


}
