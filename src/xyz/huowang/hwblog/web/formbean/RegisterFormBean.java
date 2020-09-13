package xyz.huowang.hwblog.web.formbean;

import org.apache.log4j.Logger;
import xyz.huowang.hwblog.constants.Constant;
import xyz.huowang.hwblog.constants.ErrorConstant;
import xyz.huowang.hwblog.util.BaseUtil;
import xyz.huowang.hwblog.util.WebUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：HW
 * @date ：Created in 2020/9/8 22:44
 * @description：
 *      封装的用户注册表单bean，用来接收register.jsp中的表单输入项的值
 *      RegisterFormBean中的属性与register.jsp中的表单输入项的name一一对应
 *      RegisterFormBean的职责除了负责接收register.jsp中的表单输入项的值之外还担任着校验表单输入项的值的合法性
 * @version: 1.0
 */
public class RegisterFormBean {

    public static Logger log= Logger.getLogger(RegisterFormBean.class);
    //RegisterFormBean中的属性与register.jsp中的表单输入项的name一一对应
    private String userName;
    private String userPassWord;
    private String confirmPwd;
    private String userEmail;
    private String userBirthday;

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
    public String getConfirmPwd() {
        return confirmPwd;
    }
    public void setConfirmPwd(String confirmPwd) {
        this.confirmPwd = confirmPwd;
    }
    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public String getUserBirthday() {
        return userBirthday;
    }
    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday;
    }

    /**
     * 存储校验不通过时给用户的错误提示信息
     */
    private Map<String, String> errors = new HashMap<String, String>();
    public Map<String, String> getErrors() {
        return errors;
    }
    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }
    @Override
    public String toString() {
        return "RegisterFormBean{" +
                "errors=" + errors +
                '}';
    }

    public boolean validate() {
        boolean isOk = true;
        if (BaseUtil.isNullOrEmpty(this.userName)) {
            isOk = false;
            errors.put(Constant.USERNAME, "用户名不能为空！！");
        }else if(!WebUtils.checkName(this.userName)){
            errors.put(Constant.USERNAME, "用户名不符合要求！！");
        }

        if (BaseUtil.isNullOrEmpty(this.userPassWord)) {
            isOk = false;
            errors.put(Constant.USERPWD, "密码不能为空！！");
        } else if(!WebUtils.checkPwd(this.userPassWord)){
                isOk = false;
                errors.put(Constant.USERPWD, "密码必须是6-20位字母数字组合！！");
        }

        if (BaseUtil.isNullOrEmpty(this.confirmPwd)) {
            if (!this.confirmPwd.equals(this.userPassWord)) {
                isOk = false;
                errors.put(Constant.CONFIRMPWD, "两次密码输入必须一致！！");
            }
        }

        if (BaseUtil.isNullOrEmpty(this.userEmail)) {
            isOk = false;
            errors.put(Constant.USEREMAIL, "邮箱不能为空！！");
        }else if (!WebUtils.checkEmail(this.userEmail)) {
            isOk = false;
            errors.put(Constant.USEREMAIL, "邮箱不是一个合法邮箱！！");
        }

        if(BaseUtil.isNullOrEmpty(this.userBirthday)){
            isOk = false;
            errors.put(Constant.USERBIRTHDAY, "出生日期不能为空！！");
        }

        if(!isOk){
            log.warn(ErrorConstant.PLEASE_CHECK_INPUT);
        }
        return isOk;
    }

}
