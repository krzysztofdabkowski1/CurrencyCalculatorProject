import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

enum CurrencyEnum{
    USD("USD"),
    JPY("JPY"),
    BGN("BGN"),
    CZK("CZK"),
    DKK("DKK"),
    GBP("GBP"),
    HUF("HUF"),
    PLN("PLN"),
    RON("RON"),
    SEK("SEK"),
    CHF("CHF"),
    ISK("ISK"),
    NOK("NOK"),
    HRK("HRK"),
    RUB("RUB"),
    TRY("TRY"),
    AUD("AUD"),
    BRL("BRL"),
    CAD("CAD"),
    CNY("CNY"),
    HKD("HKD"),
    IDR("IDR"),
    ILS("ILS"),
    INR("INR"),
    KRW("KRW"),
    MXN("MXN"),
    MYR("MYR"),
    NZD("NZD"),
    PHP("PHP"),
    SGD("SGD"),
    THB("THB"),
    ZAR("ZAR");
    public final String val;
    CurrencyEnum(String val) {
        this.val = val;
    }

}

public class CurrencyCalculator {
    private final Map<String, Double> currencyRates;

    public CurrencyCalculator(Map<String, Double> currencyRates) {
        this.currencyRates = currencyRates;
    }

    public double convertFromEUR(double value, CurrencyEnum currency) {
        double result = value * currencyRates.get(currency.val);
        return round(result);
    }

    private double round(double value) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
