package org.myspringframework.core;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: ClassPathXmlApplicationContext
 * Package:org.myspringframework.core
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/3/11 15:48
 */
public class ClassPathXmlApplicationContext implements ApplicationContext{

    //用来存储实例化的Bean对象
    private Map<String, Object> singletonObjects = new HashMap<>();

    /**
     * 通过构造方法来生成的，解析配置文件，初始化所有Bean对象;将bean对象存放在上面的集合中
     * @param configLocation 配置文件路径（类路径下）
     */
    public ClassPathXmlApplicationContext(String configLocation) {
        try {
            //解析配置文件
            SAXReader reader = new SAXReader();//这时dom4j解析xml文件的核心对象
            //获取输入流，指向配置文件
            InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream(configLocation);
            Document document = reader.read(inputStream);//读取配置文件myspring.xml
            //获取文件里的标签,注意参数语法
            List<Node> nodes = document.selectNodes("//bean");
            //遍历bean标签
            for (Node node : nodes) {
//                System.out.println(node);
                Element beanElt = (Element) node;//向下转型，为了使用Element接口中更加丰富的方法
                String  id = beanElt.attributeValue("id");
                String className = beanElt.attributeValue("class");
                System.out.println("beanid " + id + "className " + className);
                //通过反射机制创建对象，放入map集合提前曝光
                Class<?> aClass = Class.forName(className);//获取class
                Constructor<?> defaultCon = aClass.getDeclaredConstructor();//获取类的无参构造方法
                Object bean = defaultCon.newInstance();//实例化bean
                singletonObjects.put(id, bean);//提前曝光，将bean放入map集合中
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public Object getBean(String beanName) {
        return null;
    }
}
