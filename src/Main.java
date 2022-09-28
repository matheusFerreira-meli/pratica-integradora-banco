import classes.Client;
import data.AccountManager;
import exceptions.InvalidNumberException;
import exceptions.NotFoundException;
import util.PrintPrinter;
import util.PrintScreen;

public class Main {
    public static void main(String[] args) {
        Client client1 = new Client(1, "234", "Matheus");
        Client client2 = new Client(2, "2ddd34", "Joao");
        Client client3 = new Client(2, "2ddd34", "relll");
        AccountManager accountManager = new AccountManager();

        accountManager.createCheckingAccount(client1);
        accountManager.createCheckingAccount(client2);
        accountManager.createCheckingAccount(client3);

        try {
            accountManager.deposit(1, 500);
            accountManager.deposit(2, 1000);
        } catch (Exception e) {
            System.out.println("Erro");
        }


        PrintScreen screen = new PrintScreen();
        PrintPrinter printer = new PrintPrinter();
        screen.printOut(accountManager.getCheckingAccounts().toString());
    }
}