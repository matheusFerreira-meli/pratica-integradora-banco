package classes;

import exceptions.InsufficientFundsException;
import exceptions.InvalidNumberException;

public class SavingsAccount extends Account {
    private double rate = 1.50;

    public SavingsAccount(int number, Client client) {
        super(number, client);
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public boolean toWithdraw(double value) throws InvalidNumberException, InsufficientFundsException {
        if (insufficientBalance(value)) throw new InsufficientFundsException("Saldo insuficiente");

        return super.toWithdraw(value);
    }

    @Override
    boolean insufficientBalance(double value) {
        return getBalance() < value + getRate();
    }

    @Override
    public String toString() {
        return "SavingsAccount: {" +
                "rate=" + rate + super.toString();
    }
}
