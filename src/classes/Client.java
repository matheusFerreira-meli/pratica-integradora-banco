package classes;

import util.GenerateId;

public class Client {
    private final int id;
    private final String cpf;
    private final String name;

    public Client(String cpf, String name) {
        this.cpf = cpf;
        this.name = name;

        GenerateId generateId = GenerateId.getInstance();
        this.id = generateId.getId();
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
