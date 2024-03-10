package com.powernode.spring6.bean;

/**
 * ClassName: startFactory
 * Package:com.powernode.spring6.bean
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/3/9 15:31
 */
public class startFactory {
    public static Star get(){
        //通过这个静态方法创建StarBean
        return new Star();
    }
}
