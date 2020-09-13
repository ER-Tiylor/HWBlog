package xyz.huowang.hwblog.dao.impl;

import org.apache.log4j.Logger;
import xyz.huowang.hwblog.dao.IUserDao;
import xyz.huowang.hwblog.domain.User;
import xyz.huowang.hwblog.util.JdbcUtils;

import java.sql.ResultSet;


/**
 * @author ：HW
 * @date ：Created in 2020/9/8 22:33
 * @description： 用户操作管理的具体实现类
 * @version: 1.0
 */
public class UserDaoImpl implements IUserDao {

    public static Logger log= Logger.getLogger(UserDaoImpl.class);
    JdbcUtils connect = new JdbcUtils();
    User user = new User();
    @Override
    public User findUser(String userName, String passWord) throws Exception {
        String sql = "SELECT * " +
                "FROM hwblog_user " +
                "WHERE username = '"+userName+"' AND "
                + "userpassword ='"+passWord+"'";

        ResultSet rs = connect.Query(sql);
        user = sqlToUser(rs);
        connect.closeSource();
        return user;
    }

    @Override
    public User findUser(String userName) throws Exception {
        String sql = "SELECT * " +
                "FROM hwblog_user " +
                "WHERE username ='"+userName+"'";
        ResultSet rs = connect.Query(sql);
        user = sqlToUser(rs);
        connect.closeSource();
        return user;
    }

    @Override
    public int addUser(User user) throws Exception {
        String sql = "insert into hwblog_user(`userid`,`username`,`userpassword`,`userbirthday`,`useremail`)" +
                " values('"+user.getUserID()+"','"+
                user.getUserName()+"','"+
                user.getUserPassWord()+"','"+
                user.getUserBirthday()+"','"+
                user.getUserEmail()+"')";
        connect.Update(sql);
        connect.closeSource();
        return 0;
    }

    @Override
    public User isExist(String email) throws Exception{
        String sql = "SELECT * " +
                "FROM hwblog_user " +
                "WHERE useremail = '"+email+"'";
        ResultSet rs = connect.Query(sql);
        user = sqlToUser(rs);
        connect.closeSource();
        return user;
    }

    public User sqlToUser(ResultSet rs) throws Exception{
        User user = new User();
        while(rs.next()!=false){
            user.setUserID(rs.getString("userid"));
            user.setUserSex(rs.getString("usersex"));
            user.setUserName(rs.getString("username"));
            user.setUserEmail(rs.getString("useremail"));
            user.setUserTelNum(rs.getString("usertelnum"));
            user.setUserFlag(rs.getString("userloginflag"));
            user.setUserPassWord(rs.getString("userpassword"));
            user.setUserBirthday(rs.getString("userbirthday"));
        }
        return user;
    }
}
