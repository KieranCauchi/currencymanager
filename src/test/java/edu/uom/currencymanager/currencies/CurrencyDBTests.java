package edu.uom.currencymanager.currencies;

import edu.uom.currencymanager.currencyserver.CurrencyServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CurrencyDBTests {

    CurrencyDatabase currencyDB;
    Currency currency;
    ExchangeRate rate;
    //CurrencyServer server;

    @Before
    public void setup() {
        currencyDB = new CurrencyDatabase();
        currency = new Currency(null,null, false);
        rate = new ExchangeRate(null, null, 0);
    }

    @After
    /*public void teardown() {
        currencyDB = null;
    }*/
    public void teardown() { currency = null; rate = null; }
/*
    @Test
    public void testAddCurrencyToDatabase() {
        //Setup
        Currency currency = new Currency("EUR", "Euro", true);

        //Cache the current size of database
        int size = studentDB.countStudents();

        //Exercise
        currencyDB.add

        //Verify
        assertEquals(size+1, studentDB.countStudents());
    }
*/
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
        assertEquals(exists, true);
    }

    @Test
    public void testGetCurrencies() {
        //Setup
        String code = "EUR";

        //Exercise
        boolean exists = currencyDB.currencyExists(code);

        //Verify
        assertEquals(exists, true);
    }

}
