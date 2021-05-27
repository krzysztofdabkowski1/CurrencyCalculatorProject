import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyXMLParserTest {

    @org.junit.jupiter.api.Test
    void testParse() {
        String testDocumentPathname = System.getProperty("user.dir") + "/tests/test_file.xml";
        CurrencyXMLParser testParser = new CurrencyXMLParser();
        Map<String, Double> testMap = testParser.parse(testDocumentPathname);

        assertEquals(9.999,testMap.get("USD"));
    }

    @org.junit.jupiter.api.Test
    void testParseEmptyFile() {
        String testDocumentPathname = System.getProperty("user.dir") + "/tests/test_file2.xml";
        String testDocumentPathname2 = System.getProperty("user.dir") + "/tests/random_non_existing_file.xml";
        CurrencyXMLParser testParser = new CurrencyXMLParser();

        Map<String, Double> testMap = testParser.parse(testDocumentPathname);
        assertNull(testMap);

        testMap = testParser.parse(testDocumentPathname2);
        assertNull(testMap);
    }
}