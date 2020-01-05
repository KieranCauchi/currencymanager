package edu.uom.currencymanager.currencies;

public class EuroExchangeRate {

    public String getEuroExchangeRateMessage(EuroExchange euroExchange) throws Exception {

        CurrencyDatabase currencyDatabase = new CurrencyDatabase();

        int segment = euroExchange.getEuroExchangeRate();

        switch(segment) {
            case EuroExchange.AUD:
                return "Exchange Rate is: " + currencyDatabase.getExchangeRate("EUR", "AUD");
            case EuroExchange.GBP:
                return "Exchange Rate is: " + currencyDatabase.getExchangeRate("EUR", "GBP");
            case EuroExchange.TRY:
                return "Exchange Rate is: " + currencyDatabase.getExchangeRate("EUR", "TRY");
            case EuroExchange.USD:
                return "Exchange Rate is: " + currencyDatabase.getExchangeRate("EUR", "USD");
            default:
                return "This is a default message.";
        }
    }

}
