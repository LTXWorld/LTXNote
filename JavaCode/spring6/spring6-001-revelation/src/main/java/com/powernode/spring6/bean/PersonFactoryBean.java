package com.powernode.spring6.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * ClassName: PersonFactoryBean
 * Package:com.powernode.spring6.bean
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/3/9 16:04
 */
public class PersonFactoryBean implements FactoryBean<Person> {

    @Override
    public Person getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
    //此方法有默认实现
    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
