package practice;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Objects;

public class Birthdays {

    public static void main(String[] args) {

        int day = 31;
        int month = 12;
        int year = 1990;

        String text = "";
        LocalDate date;




    }

    public static String collectBirthdays(int year, int month, int day) {
        int i= 0;
        LocalDate birthday = LocalDate.of(1992, 07,22);
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy - EE", Locale.ENGLISH);
        System.out.println(birthday.until(today, ChronoUnit.YEARS));

        String text = "";
        while (birthday.isBefore(today)){
            birthday = birthday.plusYears(1);
            System.out.println(formatter.format(birthday));
        }
        return text + birthday;


    }
}




