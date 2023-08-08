package ua.com.poseal.todo.util;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Random;

@Component
public class Generator {
    private static final int MAX = 99999;
    private static final int MIN = 10000;
    private static final LocalDate START_DATE = LocalDate.of(1899, Month.DECEMBER, 31);
    private final Random random;

    public Generator() {
        this.random = new Random();
    }

    public String generateIPN() {
        long days = ChronoUnit.DAYS.between(START_DATE, LocalDate.now());
        long validRandomDays = random.nextLong() % (days + 1);
        while (String.valueOf(validRandomDays).length() != 5) {
            validRandomDays = random.nextLong() % (days + 1);
        }
        String secondPartIPN = "" + random.nextInt(MAX - MIN) + MIN;

        return validRandomDays + secondPartIPN;
    }
}
