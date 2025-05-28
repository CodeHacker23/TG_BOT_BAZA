package org.example.model;

import org.example.enums.StateUser;

import java.util.Objects;

public class User {
    private String login;
    private Long userId;
    private BankAccount bankAccount;
    private StateUser stateUser = StateUser.NOT;


    public StateUser getStateUser() {
        return stateUser;
    }

    public void setStateUser(StateUser stateUser) {
        this.stateUser = stateUser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Long getUserId( ) {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) && Objects.equals(userId, user.userId) && Objects.equals(bankAccount, user.bankAccount);
    }


    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", userId=" + userId +
                ", bankAccount=" + bankAccount +
                ", stateUser=" + stateUser +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, userId, bankAccount);
    }
}
