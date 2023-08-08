package ua.com.poseal.todo.util;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class IPNCheckValidator implements ConstraintValidator<IPNCheck, String> {
    @Override
    public void initialize(IPNCheck constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return isValidFormat(s) && isValidControlSum(s) && isValidBirthdayDate(s);
    }

    private boolean isValidFormat(String s) {
        if (s == null) {
            return false;
        }
        s = s.trim();
        return s.matches("^\\d{10}$");
    }

    private boolean isValidControlSum(String s) {
        int expected = s.charAt(s.length() - 1) - '0';
        int[] coefficients = {-1, 5, 7, 9, 4, 6, 10, 5, 7};
        int sum = 0;
        for (int i = 0; i < coefficients.length; i++) {
            sum += (s.charAt(i) - '0') * coefficients[i];
        }
        int actual = sum % 11 < 10 ? sum % 11 : 0;

        return actual == expected;
    }

    private boolean isValidBirthdayDate(String s) {
        LocalDate from = LocalDate.of(1899, 12, 31);
        long daysFromIPN = Long.parseLong(s.substring(0, 4));
        LocalDate birthdayDate = from.plusDays(daysFromIPN);

        return birthdayDate.isBefore(LocalDate.now());
    }
}
