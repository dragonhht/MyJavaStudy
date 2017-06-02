package xml.study.dom4jtest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.swing.text.html.HTMLDocument;
import java.io.File;
import java.util.Iterator;

/**
 * Created by huang on 17-6-2.
 * 通过dom4j解析xml
 */
public class ByDOM4J {

    public static void main(String[] args) {

        // 创建SAXReader对象
        SAXReader saxReader = new SAXReader();

        try {
            // 通过reader方法加载xml文件
            File file = new File("xmlStudy/src/main/java/xml/study/test.xml");
            Document document = saxReader.read(file);

            // 获取文档根节点
            Element root = document.getRootElement();
            // 获取迭代器
            Iterator iterator = root.elementIterator("dog");
            while (iterator.hasNext()) {
                Element dog = (Element) iterator.next();
                // 获取id属性的值
                String id = dog.attributeValue("id");
                System.out.println("id :" + id);

                // 获取子节点迭代器
                Iterator children = dog.elementIterator();
                while (children.hasNext()) {
                    Element child = (Element) children.next();
                    System.out.println(child.getName() + ": " + child.getText());
                }
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
