//package xyz.huowang.hwblog.web.filter;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author ：HW
// * @date ：Created in 2020/9/13 21:34
// * @description： 过滤器
// * @version: 1.0
// */
//public class LoginFilter implements Filter {
//    // 需要定义系统页面访问中可放行的链接
//    private List<String> list = new ArrayList<String>();
//    public void init(FilterConfig arg0) throws ServletException {
//        list.add("/main.jsp");
//        list.add("/LoginAction.do");
//    }
//
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        // 1、获取页面中的访问的路径连接
//        String path = request.getServletPath();
//        if (list != null && list.contains(path)) {
//            // 如果页面中获取的访问连接于定义的可放行的连接一致，则放行
//            chain.doFilter(request, response);
//            return;
//        }
//        // 2、从session(flag)对象中获取当前登录的用户标志
//        Object flag = request.getSession().getAttribute("flag");
//        if (flag != null) {
//            // 如果从session中获取的用户对象不为空，则放行
//            chain.doFilter(request, response);
//            return;
//        }
//        // 如果不满足条件1和2，则不能放行，回到系统的登录页面
//        response.sendRedirect(request.getContextPath() + "/");
//    }
//
//    //销毁过滤器
//    public void destroy() {
//
//    }
//}
