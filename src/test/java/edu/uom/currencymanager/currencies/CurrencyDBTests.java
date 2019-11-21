package edu.uom.currencymanager.currencies;

import edu.uom.currencymanager.currencyserver.CurrencyServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CurrencyDBTests {

    CurrencyDatabase currencyDB;
    Currency currency;
    ExchangeRate rate;
    //CurrencyServer server;

    @Before
    public void setup() throws Exception {
        currencyDB = new CurrencyDatabase();
        currency = new Currency(null,null, false);
        rate = new ExchangeRate(null, null, 0);
    }

    @After
    /*public void teardown() {
        currencyDB = null;
    }*/
    public void teardown() { currencyDB = null; }

    @Test
    public void testGetCurrencyFromCode() {
        //Setup
        String code = "EUR";

        //Exercise
        Currency curr = currencyDB.getCurrencyByCode(code);

        //Verify
        assertEquals(curr.name, "Euro");
    }

    @Test
    public void testCurrencyExists() {
        //Setup
        String code = "EUR";

        //Exercise
        boolean exists = currencyDB.currencyExists(code);

        //Verify
        assertTrue(exists);
    }

    @Test
    public void testGetCurrencies() {
        //Setup
        List<Currency> list = currencyDB.getCurrencies();

        //Verify
        assertEquals(list, currencyDB.currencies);
    }

    @Test
    public void testGetMajorCurrencies() {
        //Setup
        List majorList = currencyDB.getMajorCurrencies();

        //Exercise


        //Verify
        assertEquals(majorList, currencyDB.currencies);
    }

    @Test
    public void testGetExchangeRate() throws Exception {
        //Setup
        String source = "EUR";
        String dest = "GBP";

        //Exercise
        ExchangeRate rate = currencyDB.getExchangeRate(source, dest);

        //Verify
        assertEquals(rate, "EUR 1 = GBP 0.40");
    }

    @Test
    public void testAddCurrency() throws Exception {
        //Setup
        Currency curr = new Currency("TST", "Test", true);
        currencyDB.addCurrency(curr);

        //Exercise
        //need count method in CurrencyDatabase

        //Verify
        assertEquals(curr, currencyDB.currencies);
    }

    @Test
    public void testDeleteCurrency() throws Exception {
        //Setup
        Currency curr = new Currency("TST", "Test", true);
        currencyDB.addCurrency(curr);

        //Exercise
        //need count method in CurrencyDatabase
        currencyDB.deleteCurrency("TST");

        //Verify
        assertEquals(curr, currencyDB.currencies);
    }

}
