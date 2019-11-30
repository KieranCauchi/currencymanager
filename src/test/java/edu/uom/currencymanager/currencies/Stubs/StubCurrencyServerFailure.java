package edu.uom.currencymanager.currencies.Stubs;

import edu.uom.currencymanager.currencyserver.CurrencyServer;

public class StubCurrencyServerFailure implements CurrencyServer {

    public double getExchangeRate(String sourceCurrency, String destinationCurrency) {
        return -1;
    }

}
