package classes;

import exceptions.InsufficientFundsException;
import exceptions.InvalidNumberException;

public class SpecialAccount extends Account {
    private double limit;

    public SpecialAccount(int number, Client client, double limit) {
        super(number, client);
        this.limit = limit;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    @Override
    public boolean toWithdraw(double value) throws InvalidNumberException, InsufficientFundsException {
        if (insufficientBalance(value)) throw new InsufficientFundsException("Saldo insuficiente");

        return super.toWithdraw(value);
    }

    boolean insufficientBalance(double value) {
        return getBalance() + limit < value;
    }

    @Override
    public String toString() {
        return "SpecialAccount: {" +
                "limit=" + limit + super.toString();
    }
}
