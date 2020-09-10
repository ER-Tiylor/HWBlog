package xyz.huowang.hwblog.web.controller;

import xyz.huowang.hwblog.domain.User;
import xyz.huowang.hwblog.service.IUserService;
import xyz.huowang.hwblog.service.impl.UserServiceImpl;

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

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取用户填写的登录用户名
        String username = request.getParameter("username");
        //获取用户填写的登录密码
        String password = request.getParameter("password");
        IUserService service = new UserServiceImpl();
        //用户登录
        User user = service.loginUser(username, password);
        if(user==null){
            String message = String.format(
                    "对不起，用户名或密码有误！！请重新登录！秒后为您自动跳到登录页面！！<meta http-equiv='refresh' content=';url=%s'",
                    request.getContextPath()+"/LoginUIServlet");
            request.setAttribute("message",message);
            request.getRequestDispatcher("/message.jsp").forward(request, response);
            return;
        }
        //登录成功后，就将用户存储到session中
        request.getSession().setAttribute("user", user);
        String message = String.format(
                "恭喜：%s,登陆成功！本页将在秒后跳到首页！！<meta http-equiv='refresh' content=';url=%s'",
                user.getUserName(),
                request.getContextPath()+"/main.jsp");
        request.setAttribute("message",message);
        request.getRequestDispatcher("/message.jsp").forward(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
