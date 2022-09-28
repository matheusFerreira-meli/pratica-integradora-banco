package classes;

import util.GenerateId;

public class Client {
    private final int id;
    private final String cpf, name;

    public Client(int id, String cpf, String name) {
        this.id = id;
        this.cpf = cpf;
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", cpf='" + cpf + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
