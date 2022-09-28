import classes.Client;
import data.AccountManager;

public class Main {
    public static void main(String[] args) {
        Client client1 = new Client(1, "234", "Matheus");
        Client client2 = new Client(2, "2ddd34", "Joao");
        AccountManager accountManager = new AccountManager();

        accountManager.createCheckingAccount(client1);
        accountManager.createSavingsAccount(client2);

        System.out.println(accountManager.getAccounts());
    }
}