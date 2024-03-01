package com.ltx.xml.test;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * ClassName: test1
 * Package:com.ltx.xml.test
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/2/22 10:48
 */
public class test1 {
    @Test
    public void testParseMyBatisConfigXML() throws Exception{
        //创建SAXReader对象来解析xml文件
        SAXReader reader = new SAXReader();
        //获取输入流
        InputStream InputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("mybatis-config.xml");
        //读xml文件返回document对象
        Document document = reader.read(InputStream);
//        System.out.println(document);
        //获取文档当中的标签,如根标签等
        Element rootElement = document.getRootElement();
//        System.out.println(rootElement.getName());
        //获取默认环境id
        String xpath = "/configuration/environments";//快速定位xml中的元素
        Element environments = (Element) document.selectSingleNode(xpath);//将node向下转型
//        System.out.println(node);
        //获取属性值
        String defaultEnvironmentID = environments.attributeValue("default");
        System.out.println(defaultEnvironmentID);//获取默认环境的id
        //获取具体的环境
        xpath = "/configuration/environments/environment[@id='"+defaultEnvironmentID+"']";
        System.out.println(xpath);
        Element environment = (Element) document.selectSingleNode(xpath);
        //继续获取具体某个环境的子标签结点,element方法用来获取孩子结点
        Element transactionManager = environment.element("transactionManager");
        String transactionType = transactionManager.attributeValue("type");
        System.out.println(transactionType);
        Element dataSource = environment.element("dataSource");
        String dataSourceType = dataSource.attributeValue("type");
        System.out.println(dataSourceType);
        //获取datasource下的所有子节点
        List<Element> propertyElts = dataSource.elements();
        for (Element propertyElt : propertyElts) {
            String name = propertyElt.attributeValue("name");
            String value = propertyElt.attributeValue("value");
            System.out.println(name + "+" + value);
        }
        //获取mapper标签，从任意位置开始而不是根标签
        xpath = "//mapper";
        List<Node> mappers = document.selectNodes(xpath);
        for (Node mapper : mappers) {
            Element mapperElt = (Element) mapper;
            String resource = mapperElt.attributeValue("resource");
        }
    }
    @Test
    public void testParseSqlMapperXML() throws Exception{
        SAXReader saxReader = new SAXReader();
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("CarMapper.xml");
        Document document = saxReader.read(is);
        //
        String xpath = "/mapper";
        Element mapper = (Element) document.selectSingleNode(xpath);
        String namespace = mapper.attributeValue("namespace");
        System.out.println(namespace);
        //将mapper下的各个语句都收集在一个列表当中（通常是各个crud语句）
        List<Element> elements = mapper.elements();
        //遍历所有sql标签
        for (Element element : elements) {
            //获取sql的id
            System.out.println(element.attributeValue("id"));
            //获取resultType
            String resultType = element.attributeValue("resultType");
            System.out.println(resultType);//如果没有这个属性的语句就会返回空
            //获取标签中的sql语句
            String sqlText = element.getTextTrim();
            System.out.println(sqlText);

        }
    }
}
