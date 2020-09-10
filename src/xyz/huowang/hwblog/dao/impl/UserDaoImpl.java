package xyz.huowang.hwblog.dao.impl;

import xyz.huowang.hwblog.dao.IUserDao;
import xyz.huowang.hwblog.domain.CriteriaUser;
import xyz.huowang.hwblog.domain.User;
import xyz.huowang.hwblog.util.JdbcUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：HW
 * @date ：Created in 2020/9/8 22:33
 * @description： 用户操作管理的具体实现类
 * @version: 1.0
 */
public class UserDaoImpl implements IUserDao {

    JdbcUtils connect = new JdbcUtils();
    User user = new User();
    @Override
    public List<User> getForListWithCriteriaCustomer(CriteriaUser cc) {
        String sql = "SELECT hwuser_id,hwuser_name,hwuser_email,hwuser_telnum " +
                "FROM hwblog_user " +
                "WHERE hwuser_name LIKE "+cc.getName()+"AND "
                + "hwuser_email LIKE "+cc.getEmail()+
                " AND hwuser_telnum LIKE "+cc.getPhone();
        return null;
    }

    @Override
    public User find(String userName, String userPwd) {
        String sql = "SELECT hwuser_id,hwuser_name,hwuser_telnum " +
                "FROM hwblog_user " +
                "WHERE hwuser_name LIKE "+userName+"AND "
                + "hwuser_password LIKE "+userPwd;

        try {
            user = (User) connect.Query(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User find(String userName) {
        String sql = "SELECT hwuser_id,hwuser_name,hwuser_telnum " +
                "FROM hwblog_user " +
                "WHERE hwuser_name LIKE "+userName;
        try {
            user = (User) connect.Query(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        String sql = "select * from hwblog_user";
        List result = new ArrayList<>();
        try {
            result = (List) connect.Query(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void saveUser(User customer) {
        String sql = "insert into hwblog_user(hwuser_id,hwuser_name,hwuser_loginflag,hwuser_telnum) values " +
                "("+user.getUserID()+","+user.getUserName()+","+user.getUserFlag()+","+user.getUserTelNum()+")";
        try {
            connect.Update(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUser(Integer id) {
        String sql = "select * from hwblog_user where hwuser_id = "+user.getUserID();
        User user = new User();
        try {
            user = (User) connect.Query(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void deleteUser(Integer id) {
        String sql = "delete from hwblog_user where hwuser_id = "+user.getUserID();
        try {
            connect.Update(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public long getCountWithName(String name) {
        String sql = "select count(hwuser_id) from hwblog_user where hwuser_name = "+user.getUserName();
        long num = 0;
        try {
            connect.Query(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
