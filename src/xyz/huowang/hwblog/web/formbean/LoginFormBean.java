package xyz.huowang.hwblog.web.formbean;

import org.apache.log4j.Logger;
import xyz.huowang.hwblog.constants.Constant;
import xyz.huowang.hwblog.util.BaseUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：HW
 * @date ：Created in 2020/9/13 19:03
 * @description：TODO
 * @version: 1.0
 */
public class LoginFormBean {
    public static Logger log= Logger.getLogger(LoginFormBean.class);

    private String userName;
    private String userPassWord;
    private Map<String, String> errors = new HashMap<String, String>();

    public Map<String, String> getErrors() {
        return errors;
    }
    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserPassWord() {
        return userPassWord;
    }
    public void setUserPassWord(String userPassWord) {
        this.userPassWord = userPassWord;
    }

    public boolean validate() {
        boolean isOk = true;
        if (BaseUtil.isNullOrEmpty(this.userName)) {
            isOk = false;
            errors.put(Constant.USERNAME, "用户名不能为空！！");
        }

        if (BaseUtil.isNullOrEmpty(this.userPassWord)) {
            isOk = false;
            errors.put(Constant.USERPWD, "密码不能为空！！");
        }

        return isOk;
    }
}
