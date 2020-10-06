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
            user.setUserID(rs.getString("user_id"));
            user.setUserIP(rs.getString("user_ip"));
            user.setUserRight(rs.getString("right_id"));
            user.setUserName(rs.getString("user_name"));
            user.setUserEmail(rs.getString("user_email"));
            user.setUserGender(rs.getString("user_gender"));
            user.setUserHeadImage(rs.getString("user_icon"));
            user.setUserNickName(rs.getString("user_nickname"));
            user.setUserPassWord(rs.getString("user_password"));
            user.setUserBirthday(rs.getString("user_birthday"));
            user.setUserTelNum(rs.getString("user_telphone_number"));
            user.setUserIntroduction(rs.getString("user_introduction"));
            user.setUserRegisterTime(rs.getString("user_register_time"));
        }
        return user;
    }
}
