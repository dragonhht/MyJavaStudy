package xml.study.JDOMtest;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by huang on 17-6-2.
 * 通过jDom写入xml问价
 */
public class WriteByJDOM {

    /**
     * 生成xml
     */
    public void createXML() {

        // 创建根节点
        Element root = new Element("root");

        // 创建一个有根节点的document
        Document document = new Document(root);

        Element dog = new Element("dog");
        // 设置属性
        dog.setAttribute("id", "1");
        // 添加文本内容
        dog.setText("哈士奇");

        // 添加子节点
        root.addContent(dog);

        // 设置xml格式
        Format format = Format.getPrettyFormat();
        format.setEncoding("utf-8");

       /*将document转成xml文件*/
        XMLOutputter xmlOutputter = null;
        OutputStream out = null;
        try {
            // 创建 XMLOutputter
            xmlOutputter = new XMLOutputter(format);
            File file = new File("xmlStudy/src/main/java/xml/study/test1.xml");
            if (!file.exists()) {
                file.createNewFile();
            }
            out = new FileOutputStream(file);
            xmlOutputter.output(document, out);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {
        WriteByJDOM jdom = new WriteByJDOM();
        jdom.createXML();
    }
}
