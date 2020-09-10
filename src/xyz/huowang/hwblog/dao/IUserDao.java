package xyz.huowang.hwblog.dao;

import xyz.huowang.hwblog.domain.CriteriaUser;
import xyz.huowang.hwblog.domain.User;

import java.util.List;

/**
 * @author ：HW
 * @date ：Created in 2020/9/8 22:28
 * @description：TODO
 * @version: 1.0
 */
public interface IUserDao {
    /**
     * 模糊查询 返回满足条件的List
     * @param cc ：封装了查询条件
     * @return
     */
    public List<User> getForListWithCriteriaCustomer(CriteriaUser cc);

    /**
     * 根据用户名和密码来查找用户
     * @param userName
     * @param userPwd
     * @return 查到到的用户
     */
    User find(String userName, String userPwd);

    /**根据用户名来查找用户
     * @param userName
     * @return 查到到的用户
     */
    User find(String userName);
    /**
     * 查询 返回 List
     */
    public List<User> getAll();

    /**
     * 增加
     */
    public void saveUser(User customer);

    /**
     * 修改 更新时候的查询（根据id）显示
     */
    public User getUser(Integer id);

    /**
     * 删除
     */
    public void deleteUser(Integer id);

    /**
     * 返回和name 相同的记录数
     */
    public long getCountWithName(String name);
}
