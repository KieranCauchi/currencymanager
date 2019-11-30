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
    //ExchangeRate exchangeRate;
    //CurrencyServer server;

    @Before
    public void setup() throws Exception{
        currencyDB = new CurrencyDatabase();
        currency = new Currency(null,null, false);
        //exchangeRate = new ExchangeRate(null, null, 0);
    }

    @After
    public void teardown() { currencyDB = null; }

    @Test
    public void testGetCurrencyFromCode() {
        //Setup
        String code = "EUR";

        //Exercise
        Currency curr = currencyDB.getCurrencyByCode(code);

        //Verify
        assertEquals("Euro", curr.name);
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
        assertEquals(currencyDB.currencies, list);
    }

    @Test
    public void testGetMajorCurrencies() {
        //Setup
        List majorList = currencyDB.getMajorCurrencies();

        //Exercise


        //Verify
        assertEquals(currencyDB.currencies, majorList);
    }

    @Test
    public void testGetExchangeRate() throws Exception {
        //Setup
        String source = "EUR";
        String dest = "GBP";

        //Exercise
        ExchangeRate eRate = currencyDB.getExchangeRate(source, dest);

        //Verify
        assertEquals("EUR 1 = GBP 1.04", eRate);
    }

    @Test
    public void testAddCurrency() throws Exception {
        //Setup
        int size = currencyDB.countCurrencies();

        //Exercise
        currencyDB.addCurrency(currency);

        //Verify
        assertEquals(size+1, currencyDB.countCurrencies());
    }

    @Test
    public void testDeleteCurrency() throws Exception {
        //Setup
        Currency curr = new Currency("TST", "Test", false);
        currencyDB.addCurrency(curr);
        int size = currencyDB.countCurrencies();

        //Exercise
        currencyDB.deleteCurrency("TST");

        //Verify
        assertEquals(size-1, currencyDB.countCurrencies());
    }

}