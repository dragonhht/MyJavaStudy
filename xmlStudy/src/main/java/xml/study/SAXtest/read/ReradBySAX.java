package xml.study.SAXtest.read;

import org.xml.sax.SAXException;
import xml.study.SAXtest.read.ParserHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

/**
 * Created by huang on 17-6-2.
 * 通过SAX解析xml
 */
public class ReradBySAX {

    public static void main(String[] args) {

        // 创建 SAXParserFactory
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();

        try {
            // 获取SAXParser解析器
            SAXParser parser = parserFactory.newSAXParser();
            // 创建ParsersHandler
            ParserHandler handler = new ParserHandler();
            // 解析xml
            parser.parse("xmlStudy/src/main/java/xml/study/test.xml", handler);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
