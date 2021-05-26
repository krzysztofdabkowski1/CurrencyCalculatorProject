import org.xml.sax.SAXException;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyXMLParserTest {


    @org.junit.jupiter.api.Test
    void testParse() {
        String testDocumentPath = System.getProperty("user.dir") + "/tests/test_file.xml";
        CurrencyXMLParser testParser = new CurrencyXMLParser();
        Map<String, Double> testMap = testParser.parse(testDocumentPath);

        assertEquals(9.999,testMap.get("USD"));
    }


    @org.junit.jupiter.api.Test
    void testParseEmptyFile() {

        String testDocumentPath = System.getProperty("user.dir") + "/tests/test_file2.xml";
        String testDocumentPath2 = System.getProperty("user.dir") + "/tests/random_non_existing_file.xml";
        CurrencyXMLParser testParser = new CurrencyXMLParser();

        Map<String, Double> testMap = testParser.parse(testDocumentPath);
        assertNull(testMap);

        testMap = testParser.parse(testDocumentPath2);
        assertNull(testMap);
    }
}