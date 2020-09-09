package src.xyz.huowang.hwblog.service.impl;

import src.xyz.huowang.hwblog.constants.ErrorConstant;
import src.xyz.huowang.hwblog.dao.IUserDao;
import src.xyz.huowang.hwblog.dao.impl.UserDaoImpl;
import src.xyz.huowang.hwblog.domain.User;
import src.xyz.huowang.hwblog.exception.UserExistException;
import src.xyz.huowang.hwblog.service.IUserService;

/**
 * @author ：HW
 * @date ：Created in 2020/9/8 22:38
 * @description：TODO
 * @version: 1.0
 */
public class UserServiceImpl implements IUserService {
    IUserDao userDao = new UserDaoImpl();
    @Override
    public void registerUser(User user) throws UserExistException {
        if (userDao.find(user.getUserName())!=null) {
            //checked exception
            //unchecked exception
            //这里抛编译时异常的原因：是我想上一层程序处理这个异常，以给用户一个友好提示
            throw new UserExistException(ErrorConstant.REGISTER_USER_ALREADY_EXIST);
        }
        userDao.saveUser(user);
    }

    @Override
    public User loginUser(String userName, String userPwd) {
        return null;
    }
}
