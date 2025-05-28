package org.example.model;


import java.util.Objects;

public class BankAccount {
    private double balance;
    private String numberCard;

    public BankAccount(double balance, String numberCard) {
        this.balance = balance;
        this.numberCard = numberCard;
    }

    public String getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(String numberCard) {
        this.numberCard = numberCard;
    }

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
    public String toString() {
        return "BankAccount{" +
                "balance=" + balance +
                ", numberCard='" + numberCard + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(balance);
    }
}
