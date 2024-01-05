import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

/**
 * @author 陆涛
 * @version 1.0
 */
public class TestDom4j {
    @Test
    public void testRead() throws Exception{
        //读取jdbc.xml配置文件，获得document对象
        SAXReader saxReader = new SAXReader();
        //通过类加载器获得指向字节码根路径下的指定文件的输入流
        InputStream resourceAsStream = TestDom4j.class.getClassLoader().getResourceAsStream("jdbc.xml");
        Document document = saxReader.read(resourceAsStream);
        //从对象上获得配置文件的信息
        Element rootElement = document.getRootElement();
        System.out.println(rootElement.getName());
        //获取子元素
        List<Element> elements = rootElement.elements();
        for (Element element : elements) {
            System.out.println("\t"+element.getName());
            //获取属性
            Attribute id = element.attribute("id");
            System.out.println(id.getName() +"=" +id.getValue());
            //继续获取子元素的子元素,缩进的层次感
            List<Element> eles = element.elements();
            for (Element ele : eles) {
                System.out.println(ele.getName()+"="+ele.getText());
            }
        }
    }
}
