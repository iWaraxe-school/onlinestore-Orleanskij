package util;


import org.w3c.dom.*;
import org.xml.sax.SAXException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class ParsingXML {

    public static Document Parser_XML() throws IOException, ParserConfigurationException, org.xml.sax.SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("D:\\java_Auto\\onlinestore-Orleanskij\\store\\src\\main\\resources\\sorting.xml"));
        return document;
    }

    public static Map<String, String> readerMap(String tagName) throws IOException, ParserConfigurationException, SAXException {
        Map<String, String> xmlData = new LinkedHashMap<>();
        Document doc = Parser_XML();
        NodeList list = doc.getElementsByTagName(tagName);

        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            NodeList info = node.getChildNodes();

            for (int j = 0; j < info.getLength(); j++) {

                if (info.item(j).getNodeType() == Node.ELEMENT_NODE) {
                    String key = info.item(j).getNodeName();
                    String value = info.item(j).getTextContent().toLowerCase(Locale.ROOT);
                    xmlData.put(key, value);
                }
            }
        }
        return xmlData;
    }
}
