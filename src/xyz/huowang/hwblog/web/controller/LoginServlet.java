package xyz.huowang.hwblog.web.controller;

import org.apache.log4j.Logger;
import xyz.huowang.hwblog.constants.Constant;
import xyz.huowang.hwblog.constants.ErrorConstant;
import xyz.huowang.hwblog.domain.User;
import xyz.huowang.hwblog.service.IUserService;
import xyz.huowang.hwblog.service.impl.UserServiceImpl;
import xyz.huowang.hwblog.util.WebUtils;
import xyz.huowang.hwblog.web.formbean.LoginFormBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ：HW
 * @date ：Created in 2020/9/8 22:58
 * @description：TODO
 * @version: 1.0
 */
public class LoginServlet extends HttpServlet {

    public static Logger log= Logger.getLogger(LoginServlet.class);
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = new User();
        //获取用户填写的登录信息
        LoginFormBean formbean = WebUtils.requestBean(request, LoginFormBean.class);
        //用户登录
        if (formbean.validate()) {
            user = WebUtils.copyFormToUser(formbean, user);
            IUserService service = new UserServiceImpl();
            //调用service层提供的注册用户服务实现用户注册
            try {
                user = service.loginUser(user.getUserName(),user.getUserPassWord());
                //登录成功后，就将用户存储到session中
                request.getSession().setAttribute(Constant.USER, user);
                log.info(user.toString());
                request.getRequestDispatcher("/main.jsp").forward(request, response);
            } catch (Exception e) {
                request.setAttribute("message", ErrorConstant.LOGIN_DEFEAT);
                request.getRequestDispatcher("/message.jsp").forward(request, response);
                e.printStackTrace();
                log.error(e.toString()+ErrorConstant.LOGIN_DEFEAT);
            }
        }else{
            //将封装了用户填写的表单数据的formbean对象发送回Login.jsp页面的form表单中进行显示
            request.setAttribute(Constant.MESSAGE, formbean);
            //校验失败就说明是用户填写的表单数据有问题，那么就跳转回Login.jsp
            request.getRequestDispatcher("/WEB-INF/pages/Login.jsp").forward(request, response);
            log.warn(formbean.toString());
        }

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
