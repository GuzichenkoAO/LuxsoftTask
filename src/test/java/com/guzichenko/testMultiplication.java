package com.guzichenko;

import org.junit.Assert;
import org.junit.Test;



/**
 * Created by Артем on 24.04.2016.
 */
public class testMultiplication {

    @Test
    public void testEquality(){

        Assert.assertTrue(Money.dollar(10).equals(Money.dollar(10)));
        Assert.assertFalse(Money.dollar(10).equals(Money.dollar(11)));

        Assert.assertFalse(Money.franc(5).equals(Money.dollar(5)));
    }

    @Test
    public void testCurrency(){
        Assert.assertEquals("USD", Money.dollar(1).currency());
        Assert.assertEquals("CHF", Money.franc(1).currency());
    }

    @Test
    public void testSimpleAddition() {
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        Assert.assertEquals(Money.dollar(10), reduced);
    }

}

