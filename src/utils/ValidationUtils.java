package utils;

public class ValidationUtils {
    public static void validateText(String value, String field) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(field + " cannot be empty.");
        }
    }

    public static void validatePositiveNumber(double value, String field) {
        if (value < 0) {
            throw new IllegalArgumentException(field + " must be positive.");
        }
    }

    public static void validateCapacity(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than zero.");
        }
    }
}
