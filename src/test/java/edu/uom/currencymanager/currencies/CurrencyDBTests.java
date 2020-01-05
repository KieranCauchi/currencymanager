package edu.uom.currencymanager.currencies;

import edu.uom.currencymanager.currencies.Stubs.StubCurrencyServerFailure;
import edu.uom.currencymanager.currencies.Stubs.StubCurrencyServerSuccess;
import edu.uom.currencymanager.currencyserver.CurrencyServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;

public class CurrencyDBTests {

    CurrencyDatabase currencyDB;
    Currency currency;
    EuroExchangeRate eRate;

    @Before
    public void setup() throws Exception{
        currencyDB = new CurrencyDatabase();
        currency = new Currency(null,null, false);
        eRate = new EuroExchangeRate();
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

        //Verify
        assertEquals(currencyDB.majorCurrencies, majorList);
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

    @Test
    public void testEuroExchangeRateUSD() throws Exception {
        //Setup
        EuroExchange euroExchange = Mockito.mock(EuroExchange.class);
        Mockito.when(euroExchange.getEuroExchangeRate()).thenReturn(euroExchange.USD);

        //Exercise
        String msg = eRate.getEuroExchangeRateMessage(euroExchange);
        System.out.println(msg);

        //Verify
        assertEquals("Exchange Rate is: " + currencyDB.getExchangeRate("EUR", "USD"), msg);
    }

    @Test
    public void testCommitWithSuccessfulCurrencyServer() throws Exception {
        //Setup
        CurrencyServer currencyServer = new StubCurrencyServerSuccess();
        currencyDB.getExchangeRate("EUR", "GBP");

        //Exercise
        boolean result = currencyDB.getRate(currencyServer);

        //Verify
        assertTrue(result);
    }

    @Test
    public void testCommitWithFailingCurrencyServer() throws Exception {
        //Setup
        CurrencyServer currencyServer = new StubCurrencyServerFailure();
        currencyDB.getExchangeRate("EUR", "GBP");

        //Exercise
        boolean result = currencyDB.getRate(currencyServer);

        //Verify
        assertFalse(result);
    }

}