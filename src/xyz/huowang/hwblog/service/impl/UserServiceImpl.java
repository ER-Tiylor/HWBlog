package xyz.huowang.hwblog.service.impl;

import org.apache.log4j.Logger;
import xyz.huowang.hwblog.constants.ErrorConstant;
import xyz.huowang.hwblog.dao.IUserDao;
import xyz.huowang.hwblog.dao.impl.UserDaoImpl;
import xyz.huowang.hwblog.domain.User;
import xyz.huowang.hwblog.service.IUserService;
import xyz.huowang.hwblog.util.BaseUtil;

/**
 * @author ：HW
 * @date ：Created in 2020/9/8 22:38
 * @description：TODO
 * @version: 1.0
 */
public class UserServiceImpl implements IUserService {

    public static Logger log= Logger.getLogger(UserServiceImpl.class);
    IUserDao userDao = new UserDaoImpl();
    @Override
    public void registerUser(User user) throws Exception {
        if(BaseUtil.isNullOrEmpty(userDao.isExist(user.getUserEmail()).getUserID())){
            userDao.addUser(user);
        }else{
            throw new Exception(ErrorConstant.REGISTER_USER_ALREADY_EXIST);
        }
    }

    @Override
    public User loginUser(String userName,String userPwd) throws Exception {
        User user = null;
        user = userDao.findUser(userName,userPwd);
        if(BaseUtil.isNullOrEmpty(user.getUserID())){
            throw new Exception(ErrorConstant.REGISTER_USER_NOT_EXIST);
        }
        return user;
    }
}
