package util;

import interfaces.IPrint;

public class PrintPrinter implements IPrint {
    @Override
    public void printOut(String data) {
        System.out.println("Exibindo na impressora: ");
        System.out.println(data);
    }
}
