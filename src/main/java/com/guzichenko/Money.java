package com.guzichenko;

/**
 * Created by Артем on 24.04.2016.
 */
public class Money implements Expression{

    protected int amount;
    protected String currency;


    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    @Override
    public boolean equals(Object obj) {

        Money money = (Money) obj;
        //System.out.println(getClass() + " " + money.getClass() );
        return amount == money.amount
                && currency().equals(money.currency());

    }

    /*
     Money times(int multiplier){
         return new Money(amount * multiplier, currency);
     }*/

    static Money dollar(int amount){
     return new Money(amount, "USD");
    }

    static Money franc(int amount){
     return new Money(amount, "CHF");
    }

    String currency(){
        return currency;
    }

   Expression plus(Money addend){
        return new Money(amount + addend.amount, currency);
    }


    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }
}
