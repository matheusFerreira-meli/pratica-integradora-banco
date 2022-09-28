package data;

import classes.*;
import exceptions.InsufficientFundsException;
import exceptions.InvalidNumberException;
import exceptions.NotFoundException;
import util.GenerateId;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AccountManager {
    private final GenerateId generateId;
    private Map<Integer, Account> accounts;

    public AccountManager() {
        this.accounts = new HashMap<>();
        this.generateId = GenerateId.getInstance();
    }

    public void createCheckingAccount(Client client) {
        int idAccount = generateId.getId();
        CheckingAccount account = new CheckingAccount(idAccount, client);
        accounts.put(idAccount, account);
    }

    public void createSpecialAccount(Client client) {
        int idAccount = generateId.getId();
        SpecialAccount account = new SpecialAccount(idAccount, client, 500);
        accounts.put(idAccount, account);
    }

    public void createSavingsAccount(Client client) {
        int idAccount = generateId.getId();
        SavingsAccount account = new SavingsAccount(idAccount, client);
        accounts.put(idAccount, account);
    }

    public boolean withdraw(int idAccount, double value) throws NotFoundException, InvalidNumberException, InsufficientFundsException {
        Account account = accounts.get(idAccount);
        if(account == null) throw new NotFoundException("Conta não encontrada");

        return account.toWithdraw(value);
    }

    public boolean deposit (int idAccount, double value) throws NotFoundException, InvalidNumberException {
        Account account = accounts.get(idAccount);
        if(account == null) throw new NotFoundException("Conta não encontrada");

        return account.deposit(value);
    }

    public List<String> getAccounts() {
        return accounts.values().stream()
                .map(Account::toString)
                .collect(Collectors.toList());
    }

    public String getAccount(int id) throws NotFoundException {
        Account account = accounts.get(id);
        if (account == null) throw new NotFoundException("Conta não encontrada");

        return account.toString();
    }

    public void deleteAccount(int id) throws NotFoundException {
        Account account = accounts.get(id);
        if(account == null) throw new NotFoundException("Conta não encontrada");

        accounts.remove(id);
    }


    public List<Account> getCheckingAccounts() {
        return accounts.values().stream()
                .filter(account -> account instanceof CheckingAccount)
                .sorted((acc1, acc2) -> Double.compare(acc2.getBalance(), acc1.getBalance()))
                .collect(Collectors.toList());
    }
}
