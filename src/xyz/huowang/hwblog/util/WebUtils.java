package xyz.huowang.hwblog.util;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import xyz.huowang.hwblog.domain.User;
import xyz.huowang.hwblog.web.formbean.LoginFormBean;
import xyz.huowang.hwblog.web.formbean.RegisterFormBean;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * @author ：HW
 * @date ：Created in 2020/9/8 22:41
 * @description： 该工具类的功能就是封装客户端提交的表单数据到formbean中
 *                该类还有校验用户输入表单格式的方法
 * @version: 1.0
 */
public class WebUtils {

    public static Logger log= Logger.getLogger(WebUtils.class);
    /**
     * 将request对象转换成T对象
     * 获取用户输入表单数据
     * @param request
     * @param clazz
     * @return
     */
    public static <T> T requestBean(HttpServletRequest request, Class<T> clazz){
        try{
            T bean = clazz.newInstance();
            Enumeration<String> e = request.getParameterNames();
            while(e.hasMoreElements()){
                String name = (String) e.nextElement();
                String value = request.getParameter(name);
                BeanUtils.setProperty(bean, name, value);
            }
            return bean;
        }catch (Exception e) {
            log.error(e.toString());
            throw new RuntimeException(e);
        }
    }
    /**
     * 把RegisterFormBean的数据填充到User中
     * @param: formbean
     * @param: user
     * @return:  用户对象
     * @throws:
     */
    public static User copyFormToUser(RegisterFormBean formbean, User user){
        try {
            BeanUtils.copyProperties(user, formbean);//填入用户数输入的数据
            user.setUserID(WebUtils.makeUserId());//设置用户的Id属性
        } catch (IllegalAccessException e) {
            log.error(e.toString());
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            log.error(e.toString());
            e.printStackTrace();
        }

        return user;
    }
    /**
     * 把LoginFormBean的数据填充到User中
     * @param: formbean
     * @param: user
     * @return:  用户对象
     * @throws:
     */
    public static User copyFormToUser(LoginFormBean formbean, User user){
        try {
            BeanUtils.copyProperties(user, formbean);//填入用户数输入的数据
        } catch (IllegalAccessException e) {
            log.error(e.toString());
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            log.error(e.toString());
            e.printStackTrace();
        }

        return user;
    }
    /**
     * 生成用户id
     * @return
     */
    public static String makeUserId(){
        //取当前时间的长整形值包含毫秒
        long millis = System.currentTimeMillis();
        //加上三位随机数
        Random random = new Random();
        int end3 = random.nextInt(999);//该方法的作用是生成一个随机的int值，该值介于[0,n]的区间，也就是0到n之间的随机int值，包含0而不包含n。
        //如果不足三位前面补0  String.format("%03d", end3); 3代表要获得的总长度，0代表传入的参数不够的时候会用0作为填充，d会被传入的参数替代
        String str = millis + String.format("%03d", end3);
        return str;
    }

    /**
     * 生成UUID
     * @return
     */
    public static String makeId(){
        return UUID.randomUUID().toString().replace("-","");
    }

    /**
     * 用户名验证
     *  @param name
     *  @return
     */
    public static boolean checkName(String name) {
        String regExp = "^(?!_)(?!.*?_$)[a-zA-Z0-9_\\u4e00-\\u9fa5]+$";
        if(name.matches(regExp)) {
            return true;
        }else {
            return false;
        }
    }

    /**
     * 密码验证
     *  @param pwd
     *  @return
     */
    public static boolean checkPwd(String pwd) {
        String regExp = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$";
        if(pwd.matches(regExp)) {
            return true;
        }
        return false;
    }

    /**
     * email是一个合法的邮箱
     * @param: email
     * @return:
     */
    public static boolean checkEmail(String email){
        String regExp = "^[0-9a-z]+\\w*@([0-9a-z]+\\.)+[0-9a-z]+$";
        if(email.matches(regExp)) {
            return true;
        }
        return false;
    }

    /**
     * 电话号码验证
     * @param: telnum
     * @return:  boolean
     * @throws:
     */
    public static boolean checkTelnum(String telnum){
        String regExp = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\\\d{8}$";
        if(telnum.matches(regExp)){
            return true;
        }
        return false;
    }
}
