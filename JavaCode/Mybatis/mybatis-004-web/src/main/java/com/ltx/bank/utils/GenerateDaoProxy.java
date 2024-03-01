package com.ltx.bank.utils;

import org.apache.ibatis.javassist.CannotCompileException;
import org.apache.ibatis.javassist.ClassPool;
import org.apache.ibatis.javassist.CtClass;
import org.apache.ibatis.javassist.CtMethod;

import java.lang.reflect.Method;

/**
 * ClassName: GenerateDaoProxy
 * Package:com.ltx.bank.utils
 * Description:
 *可以动态生成dao的实现类
 * @author LTX
 * @version 炼气期
 * @Create 2024/2/27 23:01
 */
public class GenerateDaoProxy {
    //提供工具方法，只要给一个接口就可以返回对应的对象

    /**
     * 生成dao接口的实现类，并且将对象创建出来并返回
     * @param daoInterface 实现类所对应的接口
     * @return 实现类的实例化对象
     */
    public static Object generate(Class daoInterface) throws CannotCompileException, InstantiationException, IllegalAccessException {
        //类池,mybatis内置了javaassit,所以可以直接使用classPool
        ClassPool classPool = ClassPool.getDefault();
        //制造类,实际上在内存中动态生成一个代理类
        CtClass ctClass = classPool.makeClass(daoInterface.getName() + "Proxy");
        //制造接口
        CtClass ctInterface = classPool.makeInterface(daoInterface.getName());
        //添加对应接口
        ctClass.addInterface(ctInterface);
        //实现接口的所有方法
        Method[] methods = daoInterface.getDeclaredMethods();
        for (Method method : methods) {
            //method是抽象方法，要对方法进行实现
            StringBuilder methodCode = new StringBuilder();
            //开始拼串public Account selectByActno(String actno){代码;}
            methodCode.append("public ");
            methodCode.append(method.getReturnType().getName());
            methodCode.append(" ");
            methodCode.append(method.getName());
            methodCode.append("(");
            //需要形参列表
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                Class<?> parameterType = parameterTypes[i];//得到参数的类型
                methodCode.append(parameterType.getName());
                methodCode.append(" ");
                methodCode.append("arg" + i);
                if (i != parameterTypes.length - 1){
                    methodCode.append(",");
                }
            }
            methodCode.append(")");
            methodCode.append("{");
            //方法体中的代码

            methodCode.append("}");

            CtMethod ctMethod = CtMethod.make("", ctClass);
            ctClass.addMethod(ctMethod);
        }
        //创建对象
        Object obj = null;
        Class<?> clazz = ctClass.toClass();
        obj = clazz.newInstance();//返回一个对象
        return obj;
    }
}
