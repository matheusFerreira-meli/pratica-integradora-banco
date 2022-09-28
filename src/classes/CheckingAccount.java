package classes;

import exceptions.InsufficientFundsException;
import exceptions.InvalidNumberException;

public class CheckingAccount extends Account {
    public CheckingAccount(int number, Client client) {
        super(number, client);
    }

    @Override
    public boolean toWithdraw(double value) throws InvalidNumberException, InsufficientFundsException {
        if(insufficientBalance(value)) throw new InsufficientFundsException("Saldo insuficiente");

        return super.toWithdraw(value);
    }

    @Override
    boolean insufficientBalance(double value) {
        return getBalance() < value;
    }

    @Override
    public String toString() {
        return "\n{" +
                "type: CheckingAccount" +
                ", number=" + super.getNumber() +
                ", balance=" + super.getBalance() +
                ", client=" + super.getClient() +
                "}";
    }
}
