package interfaces;

public interface Validatable {
    boolean isValid();

    default void printValidationStatus() {
        if (isValid()) {
            System.out.println("Data is VALID");
        } else {
            System.out.println("Data is INVALID");
        }
    }
}