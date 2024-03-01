//package com.ltx.bank.javassistTest;
//
//import com.ltx.bank.dao.AccountDao;
//import org.apache.ibatis.javassist.CannotCompileException;
//import org.apache.ibatis.javassist.ClassPool;
//import org.apache.ibatis.javassist.CtClass;
//import org.apache.ibatis.javassist.CtMethod;
//
//import java.lang.reflect.Method;
//
///**
// * ClassName: JavassistTest
// * Package:com.ltx.bank.javassistTest
// * Description:
// *
// * @author LTX
// * @version 炼气期
// * @Create 2024/2/27 21:58
// */
//public class JavassistTest {
//    @Test
//    public void testGenerateAccountDaoImpl() throws CannotCompileException {
//        //获取类池
//        ClassPool pool = ClassPool.getDefault();
//        //制造类
//        CtClass ctClass = pool.makeClass("com.ltx.bank.dao.imp;.AccountDaoImpl");
//        //制造接口
//        CtClass ctInterface = pool.makeInterface("com.ltx.bank.dao.AccountDao");
//        //类实现接口
//        ctClass.addInterface(ctInterface);
//        //实现接口中的所有方法
//        Method[] methods = AccountDao.class.getDeclaredMethods();
//        System.out.println(methods);
//        //
//        for (Method method : methods) {
//            StringBuilder methodCode = new StringBuilder();
//            methodCode.append("public ");//追加修饰符列表
//            methodCode.append(method.getReturnType().getName());//追加返回值类型
//            methodCode.append(" ");//追加空格
//            methodCode.append(method.getName());//追加方法名
//            methodCode.append("(");
//            //拼接参数
//
//            methodCode.append(")");
//            CtMethod ctMethod = CtMethod.make("方法的代码片段", ctClass);
//            ctClass.addMethod(ctMethod);
//        }
//    }
//}
