package xml.study.SAXtest.write;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

/**
 * Created by huang on 17-6-2.
 * 通过SAX写入xml文件
 */
public class WriteBySAX {

    /**
     * 创建xml
     */
    public void createXML() {

        SAXTransformerFactory factory = (SAXTransformerFactory) SAXTransformerFactory
                .newInstance();

        OutputStream out = null;
        try {
            TransformerHandler handler = factory.newTransformerHandler();
            Transformer transformer = handler.getTransformer();

            // 设置编码
            transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
            // 设置换行
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            // 创建Result对象
            File file = new File("xmlStudy/src/main/java/xml/study/test1.xml");
            if (!file.exists()) {
                file.createNewFile();
            }
            out = new FileOutputStream(file);
            Result result = new StreamResult(out);
            // 将result对象与handler关联
            handler.setResult(result);

           /*使用handler进行文档的编写*/
           // 打开document
            handler.startDocument();

            // 属性对象
            AttributesImpl attribute = new AttributesImpl();
            // 创建节点
            handler.startElement("", "", "root", attribute);
            // 清除attribute
            attribute.clear();

            // 设置属性
            attribute.addAttribute("", "", "id", "", "1");
            handler.startElement("", "", "dog", attribute);

            // 添加文本
            String s = "哈士奇";
            handler.characters(s.toCharArray(), 0, s.length());

            handler.endElement("", "", "dog");

            // 关闭节点
            handler.endElement("", "", "root");
            // 关闭document
            handler.endDocument();


        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
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
        WriteBySAX writeBySAX = new WriteBySAX();
        writeBySAX.createXML();
    }
}
