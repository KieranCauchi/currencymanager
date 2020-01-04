package edu.uom.currencymanager.currencies;

public interface EuroExchange {

    public final static int AUD = 0;
    public final static int GBP = 1;
    public final static int TRY = 2;
    public final static int USD = 3;

    public int getEuroExchangeRate();

}
