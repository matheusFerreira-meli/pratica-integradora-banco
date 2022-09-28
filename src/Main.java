import classes.Client;
import data.AccountManager;
import exceptions.NotFoundException;
import util.PrintPrinter;
import util.PrintScreen;

public class Main {
    public static void main(String[] args) {
        // Criando clientes
        Client client1 = new Client(1, "23456", "Matheus");
        Client client2 = new Client(1, "23478", "Maria");
        Client client3 = new Client(2, "11111222", "Joao");
        Client client4 = new Client(2, "54567", "Juliana");
        Client client5 = new Client(2, "7777555", "Mario");

        // instanciando a account manager e criando as contas
        AccountManager accountManager = new AccountManager();
        accountManager.createCheckingAcc(client1);
        accountManager.createSpecialAcc(client2);
        accountManager.createSavingsAcc(client3);
        accountManager.createCheckingAcc(client4);
        accountManager.createSpecialAcc(client5);

        try {
            // realizando os serviços
            accountManager.withdraw(2, 500);
            accountManager.deposit(1, 200);
            accountManager.deposit(4, 190);
            accountManager.deposit(3, 1000);
            accountManager.transfer(3, 1, 500);
        } catch (Exception e) {
            System.out.println("Erro");
        }


        PrintScreen screen = new PrintScreen();
        PrintPrinter printer = new PrintPrinter();
        System.out.println("============= Resultados ==============");
        System.out.println("Contas no negativo");
        screen.printOut(accountManager.getSpecialAccNegativeBalance().toString());

        System.out.println("--------------");
        System.out.println("Contas corrente ordenadas");
        printer.printOut(accountManager.getCheckingAcc().toString());

        System.out.println("--------------");
        System.out.println("Todas as contas");
        screen.printOut(accountManager.getAcc().toString());

        System.out.println("--------------");
        System.out.println("Deletando a conta 4");

        try {
            accountManager.deleteAcc(4);
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("--------------");
        System.out.println("Exibindo todas as contas depois de excluir uma conta");
        screen.printOut(accountManager.getAcc().toString());
    }
}