package edu.uom.currencymanager.currencies;

public class EuroExchangeRate {

    CurrencyDatabase cd;

    public String getEuroExchangeRateMessage(EuroExchange euroExchange) throws Exception {

        int segment = euroExchange.getEuroExchangeRate();

        switch(segment) {
            case EuroExchange.AUD:
                return "Exchange Rate is: " + cd.getExchangeRate("EUR", "AUD");
            case EuroExchange.GBP:
                return "Exchange Rate is: " + cd.getExchangeRate("EUR", "GBP");
            case EuroExchange.TRY:
                return "Exchange Rate is: " + cd.getExchangeRate("EUR", "TRY");
            case EuroExchange.USD:
                return "Exchange Rate is: " + cd.getExchangeRate("EUR", "USD");
            default:
                return "This is a default message.";
        }
    }

}
