import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CurrencyXMLParser parser = new CurrencyXMLParser();
        Map<String, Double> currencyRates = parser.parse();
        CurrencyCalculator calc = new CurrencyCalculator(currencyRates);

        System.out.println(calc.convertFromEUR(56.67, CurrencyEnum.USD));
    }
}
