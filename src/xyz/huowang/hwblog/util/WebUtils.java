package xyz.huowang.hwblog.util;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.UUID;

/**
 * @author ：HW
 * @date ：Created in 2020/9/8 22:41
 * @description： 该工具类的功能就是封装客户端提交的表单数据到formbean中
 * @version: 1.0
 */
public class WebUtils {

    /**
     * 将request对象转换成T对象
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
            throw new RuntimeException(e);
        }
    }
    /**
     * 生成UUID
     * @return
     */
    public static String makeId(){
        return UUID.randomUUID().toString();
    }
}
