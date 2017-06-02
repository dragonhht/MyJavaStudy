package xml.study.SAXtest.read;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by huang on 17-6-2.
 */
public class ParserHandler extends DefaultHandler {

    /**
     * 遍历xml的开始标签
     * @param uri
     * @param localName
     * @param qName
     * @param attributes
     * @throws SAXException
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);

        // 解析dog元素
        if ("dog".equals(qName)) {
            // 获取id属性的值
            String value = attributes.getValue("id");
            System.out.println("id :" + value);

            // 获取所有属性
            for (int i = 0; i < attributes.getLength(); i++) {
                System.out.println(attributes.getQName(i) + ":"
                 + attributes.getValue(i));
            }
        } else {
            if (!"body".equals(qName)) {
                System.out.print(qName + ":");
            }
        }
    }

    /**
     * 遍历xml的结束标签
     * @param uri
     * @param localName
     * @param qName
     * @throws SAXException
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);

        if ("dog".equals(qName)) {
            System.out.println("dog标签结束");
        }
    }

    /**
     * 标志解析开始
     * @throws SAXException
     */
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        System.out.println("解析开始");
    }

    /**
     * 标志解析结束
     * @throws SAXException
     */
    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("解析结束");
    }

    /**
     * 获取节点值
     * @param ch
     * @param start
     * @param length
     * @throws SAXException
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        String value = new String(ch, start, length);
        if (!value.trim().equals("")) {
            System.out.println(value);

        }
    }
}
