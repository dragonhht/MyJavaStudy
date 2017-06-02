package xml.study.DOMtest;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by huang on 17-6-2.
 * 通过DOM解析xml
 */
public class ByDOM {


    public static void main(String[] args) {

        // 获取DocumentBuilderFactory对象
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

        try {
            // 获取DocumentBuilder对象
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            // 解析xml文件
            Document document = builder.parse("xmlStudy/src/main/java/xml/study/test.xml");

            // 通过标签名获取节点
            NodeList nodeList = document.getElementsByTagName("dog");
            System.out.println("标签数量: " + nodeList.getLength());
            // 遍历节点
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                // 当标签只有一个id属性时,获取id的值
                Element element = (Element) node;
                // 通过属性名获取属性值
                System.out.println("属性id:" + element.getAttribute("id"));

                // 获取节点的所有属性
                NamedNodeMap namedNodeMap = node.getAttributes();
                System.out.println("属性数量: " + namedNodeMap.getLength());
                for (int j = 0; j < namedNodeMap.getLength(); j++) {
                    Node attrituteNode = namedNodeMap.item(j);
                    // 输出属性名和属性值
                    System.out.println(attrituteNode.getNodeName() +": "
                    + attrituteNode.getNodeValue());
                }

                // 获取所有的子节点
                NodeList childNodes = node.getChildNodes();
                System.out.println("子节点:");
                for (int l = 0; l < childNodes.getLength(); l++) {
                    Node childNode = childNodes.item(l);
                    if (childNode.getNodeType() == Node.ELEMENT_NODE) { // 去除text节点
                        // 输出节点与相应的值
                        System.out.println(childNode.getNodeName() + ": "
                                + childNode.getTextContent());
                    }
                }
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
