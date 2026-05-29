package utils;

import java.time.LocalDate;

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

    public static void validateBirthDate(LocalDate birthDate) {
        if (birthDate == null) {
            throw new IllegalArgumentException("Birth date cannot be null.");
        }
        if (birthDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Birth date cannot be in the future.");
        }
    }

    public static void validateEmail(String email) {
        validateText(email, "Email");
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Invalid email format.");
        }
    }
}
