package xml.study.DOMtest;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * Created by huang on 17-6-2.
 * 通过dom写入xml文件
 */
public class WriteByDom {

    /**
     * 获取DocumentBuilder对象
     * @return DocumentBuilder对象
     */
    public DocumentBuilder getDocumentBuilder() {
        // 获取DocumentBuilderFactory对象
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder = null;
        try {
            // 获取DocumentBuilder对象
            builder = builderFactory.newDocumentBuilder();

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        return builder;
    }


    /**
     * 生成xml文件
     */
    public void createXML() {

        DocumentBuilder builder = getDocumentBuilder();
        // 创建document
        Document document = builder.newDocument();
        document.setXmlStandalone(true);

        // 创建节点
        Element root = document.createElement("root");
        // 向document中添加节点
        document.appendChild(root);

        /*向root节点下添加子节点*/
        Element child = document.createElement("dog");
        // 向dog节点中添加属性
        child.setAttribute("id", "1");
        // 添加文本
        child.setTextContent("哈士奇");
        root.appendChild(child);

        /*将document转换成xml文件*/
        TransformerFactory factory = TransformerFactory.newInstance();
        try {
            Transformer transformer = factory.newTransformer();
            // 换行设置
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            // 将document转换成文件
            transformer.transform(new DOMSource(document), new StreamResult(
                    new File("xmlStudy/src/main/java/xml/study/test1.xml")));

        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        WriteByDom writeByDom = new WriteByDom();
        writeByDom.createXML();
    }
}
