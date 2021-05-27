import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CurrencyXMLParser parser = new CurrencyXMLParser();
        Map<String, Double> rates = parser.parse();
        CurrencyCalculator calc = new CurrencyCalculator(rates);

        System.out.println(calc.convertFromEUR(56.67, CurrencyEnum.USD));
    }
}
