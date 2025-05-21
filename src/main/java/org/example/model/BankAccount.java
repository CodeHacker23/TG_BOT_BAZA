package org.example.model;


import java.util.Objects;

public class BankAccount {
    private double balance;

    public double getBalance() {
        return balance;
    }


    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return Double.compare(balance, that.balance) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(balance);
    }
}
