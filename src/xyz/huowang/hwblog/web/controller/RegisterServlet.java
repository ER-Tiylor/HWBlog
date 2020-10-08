package xyz.huowang.hwblog.web.controller;

import org.apache.log4j.Logger;
import xyz.huowang.hwblog.constants.Constant;
import xyz.huowang.hwblog.constants.ErrorConstant;
import xyz.huowang.hwblog.domain.User;
import xyz.huowang.hwblog.service.IUserService;
import xyz.huowang.hwblog.service.impl.UserServiceImpl;
import xyz.huowang.hwblog.util.WebUtils;
import xyz.huowang.hwblog.web.formbean.RegisterFormBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ：HW
 * @date ：Created in 2020/9/8 22:42
 * @description：TODO
 * @version: 1.0
 */
public class RegisterServlet extends HttpServlet {

    public static Logger log= Logger.getLogger(RegisterServlet.class);
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = new User();
        //将客户端提交的表单数据封装到RegisterFormBean对象中
        RegisterFormBean formbean = WebUtils.requestBean(request,RegisterFormBean.class);

        if (formbean.validate()) {
            user = WebUtils.copyFormToUser(formbean,user);
            IUserService service = new UserServiceImpl();
            //调用service层提供的注册用户服务实现用户注册
            try {
                service.registerUser(user);
                request.getRequestDispatcher("/WEB-INF/pages/MainLogin.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
                log.error(e.toString()+user.toString()+ErrorConstant.REGISTER_DEFEAT);
            }
        }else{
            //将封装了用户填写的表单数据的formbean对象发送回register.jsp页面的form表单中进行显示
            request.setAttribute(Constant.MESSAGE, formbean);
            //校验失败就说明是用户填写的表单数据有问题，那么就跳转回register.jsp
            request.getRequestDispatcher("/WEB-INF/pages/MainLogin.jsp").forward(request, response);
            log.warn(formbean.toString());
        }
    }
}
