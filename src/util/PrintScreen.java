package util;

import interfaces.IPrint;

public class PrintScreen implements IPrint {
    @Override
    public void printOut(String data) {
        System.out.println("Exibindo na tela: ");
        System.out.println(data);
    }
}
