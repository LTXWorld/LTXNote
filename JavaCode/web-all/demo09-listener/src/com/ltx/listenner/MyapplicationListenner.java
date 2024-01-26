package com.ltx.listenner;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;

/**
 * ClassName: MyapplicationListenner
 * Package:com.ltx.listenner
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/1/24 16:48
 */
@WebListener
public class MyapplicationListenner implements ServletContextListener, ServletContextAttributeListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //
        System.out.println(sce.getServletContext().hashCode()+"xxx应用域被初始化");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println(sce.getServletContext().hashCode()+"xxx应用域被销毁了");
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        ServletContext application = scae.getServletContext();
        String key = scae.getName();
        Object value = scae.getValue();
        System.out.println(application.hashCode() + "应用域增加了" +key+":" + value);
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        //移除了数据
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        //替换数据
        ServletContext application = scae.getServletContext();
        String key = scae.getName();
        Object value = scae.getValue();//这里获取的是旧的值
        Object valueNew = application.getAttribute("keyA");
        System.out.println(application.hashCode() + "应用域增加了" +key+":" + value);
    }
}
