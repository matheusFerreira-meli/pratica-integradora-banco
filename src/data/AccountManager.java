package data;

import classes.Account;
import classes.CheckingAccount;
import classes.Client;
import classes.SpecialAccount;
import util.GenerateId;

import java.util.HashMap;
import java.util.Map;

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

}
