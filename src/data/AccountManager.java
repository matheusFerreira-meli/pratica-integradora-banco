package data;

import classes.*;
import util.GenerateId;

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

    public List<String> getAccounts() {
        return accounts.values().stream()
                .map(Account::toString)
                .collect(Collectors.toList());
    }
}
