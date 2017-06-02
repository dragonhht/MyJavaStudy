package xml.study.dom4jtest;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.*;

/**
 * Created by huang on 17-6-2.
 * 通过dom4j写入xml文件
 */
public class WriteByDOM4J {

    /**
     * 创建xml
     */
    public void createXML() {

        // 创建document
        Document document = DocumentHelper.createDocument();

        // 创建根节点
        Element root = document.addElement("root");

        // 在root节点下添加节点
        Element dog = root.addElement("dog");
        // 添加属性
        dog.addAttribute("id", "1");
        // 添加文本内容
        dog.setText("哈士奇");

        // 设置xml格式
        OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        outputFormat.setEncoding("utf-8");

        /*生成xml文件*/
        OutputStream out = null;
        XMLWriter xmlWriter = null;
        try {
            File file = new File("xmlStudy/src/main/java/xml/study/test1.xml");
            if (!file.exists()) {
                file.createNewFile();
            }
            out = new FileOutputStream(file);
            // 创建XMLWriter
            xmlWriter = new XMLWriter(out, outputFormat);
            // 设置是否转义
            xmlWriter.setEscapeText(false);
            xmlWriter.write(document);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
            if (xmlWriter != null) {
                try {
                    xmlWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }




    }

    public static void main(String[] args) {
        WriteByDOM4J dom4J = new WriteByDOM4J();
        dom4J.createXML();
    }
}
