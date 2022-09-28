import classes.Client;
import data.AccountManager;
import util.PrintPrinter;
import util.PrintScreen;

public class Main {
    public static void main(String[] args) {
        Client client1 = new Client(1, "234", "Matheus");
        Client client2 = new Client(2, "2ddd34", "Joao");
        Client client3 = new Client(2, "2ddd34", "relll");
        AccountManager accountManager = new AccountManager();

        accountManager.createCheckingAcc(client1);
        accountManager.createSpecialAcc(client2);
        accountManager.createSpecialAcc(client3);

        try {
            accountManager.withdraw(2, 500);
        } catch (Exception e) {
            System.out.println("Erro");
        }


        PrintScreen screen = new PrintScreen();
        PrintPrinter printer = new PrintPrinter();
        screen.printOut(accountManager.getSpecialAccNegativeBalance().toString());
    }
}