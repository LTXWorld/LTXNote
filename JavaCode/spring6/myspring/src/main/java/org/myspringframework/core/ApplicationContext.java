package org.myspringframework.core;

/**
 * ClassName: ApplicationContext
 * Package:org.myspringframework.core
 * Description:
 * 框架应用上下文接口
 * @author LTX
 * @version 炼气期
 * @Create 2024/3/11 15:45
 */
public interface ApplicationContext {
    /**
     * 根据bean名称获取bean对象
     * @param beanName 配置文件中的bean id
     * @return
     */
    Object getBean(String beanName);
}
