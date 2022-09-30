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

        System.out.println(collectBirthdays(year,month,day));




    }

    public static String collectBirthdays(int year, int month, int day) {
        int i= 0;
        LocalDate birthday = LocalDate.of(year,month,day);
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy - EE", Locale.ENGLISH);
        System.out.println(birthday.until(today, ChronoUnit.YEARS));

        String text = System.lineSeparator();
        while (birthday.isBefore(today)){

            i = i +1;
            text = text + i + "-" + formatter.format(birthday) + System.lineSeparator();
            birthday = birthday.plusYears(1);
        }
        if(birthday.isEqual(today)){
            text = i + "-" + formatter.format(today);
        }
        return  text ;


    }

}




