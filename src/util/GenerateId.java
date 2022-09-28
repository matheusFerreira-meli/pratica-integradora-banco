package util;

// Singleton
public class GenerateId {
    private int id;
    private final static GenerateId instance = new GenerateId();

    private GenerateId() {}

    public static GenerateId getInstance() {
        return instance;
    }

    public int getId() {
        return ++id;
    }

}
