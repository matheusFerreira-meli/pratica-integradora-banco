package classes;

import exceptions.InsufficientFundsException;
import exceptions.InvalidNumberException;

public abstract class Account {
    private final int number;
    private double balance;
    private final Client client;

    public Account(int number, Client client) {
        this.client = client;
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public int getNumber() {
        return number;
    }

    public boolean toWithdraw(double value) throws InvalidNumberException, InsufficientFundsException {
        if(isInvalidNumber(value)) throw new InvalidNumberException("Valor de saque inválido");

        balance -= value;
        return true;
    }

    public boolean deposit(double value) throws InvalidNumberException {
        if(isInvalidNumber(value)) throw new InvalidNumberException("Valor de saque inválido");

        balance += value;
        return true;
    }

    private boolean isInvalidNumber(double value) {
        return value <= 0;
    }

    @Override
    public String toString() {
        return "{" +
                "number=" + number +
                ", balance=" + balance +
                ", client=" + client +
                '}';
    }
}
