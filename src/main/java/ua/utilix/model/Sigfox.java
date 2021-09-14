package ua.utilix.model;

public interface Sigfox {

    default SigfoxData parse(String id, String input, int sequence) {
        System.out.println("default " + id + ". Невідомий тип лічильника. Данні: " + input);
        return null;
    }

}
