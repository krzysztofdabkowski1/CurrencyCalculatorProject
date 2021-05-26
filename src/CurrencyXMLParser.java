import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class CurrencyXMLParser {
    private static final String defaultDocumentPath = System.getProperty("user.dir") + "/eurofxref-daily.xml";
    private Map<String, Double> map = null;

    public Map<String, Double> parse()  {
        return this.parse(defaultDocumentPath);
    }

    public Map<String, Double> parse(String XMLDocumentPath) {
        try {
            File file = new File(XMLDocumentPath);
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                Document doc = db.parse(file);

                doc.getDocumentElement().normalize();
                map = new HashMap<>();
                NodeList nList = doc.getElementsByTagName("Cube");
                for (int i = 0; i < nList.getLength(); i++) {

                    Node nNode = nList.item(i);
                    Element eElement = (Element) nNode;

                    if (eElement.hasAttribute("currency")) {
                        double rate = new Double(eElement.getAttribute("rate"));
                        map.put(eElement.getAttribute("currency"), rate);
                    }
                }
        }
        catch(ParserConfigurationException | IOException | SAXException e)
            {
                System.out.println(e);
                map = null;
            }

        return map;
    }
}