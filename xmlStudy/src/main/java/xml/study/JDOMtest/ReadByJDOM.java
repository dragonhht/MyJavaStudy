package xml.study.JDOMtest;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by huang on 17-6-2.
 * 通过jDOM解析xml
 */
public class ReadByJDOM {

    public static void main(String[] args) {

        // 创建SAXBuilder
        SAXBuilder saxBuilder = new SAXBuilder();

        InputStream input = null;
        try {
            // 将xml文件加载到输入流中
            input = new FileInputStream("xmlStudy/src/main/java/xml/study/test.xml");
            // 将输入流加载到saxBuilder中
            Document document = saxBuilder.build(input);
            // 根据document获取根节点
            Element root = document.getRootElement();
            // 获取所有的子节点
            //root.getChildren();
            // 获取dog子节点
            List<Element> dogs = root.getChildren("dog");
            for (Element dog : dogs) {
                // 获取id属性
                Attribute att = dog.getAttribute("id");
                String name = att.getName();
                String id = att.getValue();
                System.out.println(name + ": " + id);

                // 获取子节点
                List<Element> children = dog.getChildren();
                for (Element child : children) {
                    System.out.println(child.getName() +": " + child.getText());
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
