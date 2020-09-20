package xyz.huowang.hwblog.web.UI;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ：HW
 * @date ：Created in 2020/9/8 22:59
 * @description：
 *      LoginUIServlet负责为用户输出登陆界面
 *      当用户访问LoginUIServlet时，就跳转到WEB-INF/pages目录下的login.jsp页面
 * @version: 1.0
 */
public class MainLoginUIServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/MainLogin.jsp").forward(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
