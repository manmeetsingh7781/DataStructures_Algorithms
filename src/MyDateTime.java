import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;

// java.time => package from Date & time from Java 8 before that it was used to be in java.util

public class MyDateTime {
    public static void main(String[] args) {

        // what date is today
        LocalDate todays_date = LocalDate.now();
        System.out.println(todays_date);
       
        // current time
        LocalTime time = LocalTime.now();
        System.out.println(time);

        // compare days between two dates
        LocalDate tommorow = LocalDate.of(2022, 3, 25);
        System.out.println(tommorow.compareTo(todays_date));

        LocalTime evening = LocalTime.of(15, 18, 0);
        System.out.println(evening);
        System.out.println(evening.compareTo(time));

        Calendar calendar = Calendar.getInstance();
        calendar.set(2022, 3, 22);

        calendar.add(Calendar.DATE, 10);        // add 10 days and will change month if it happens
        calendar.roll(Calendar.DATE, 10);       // roll wont change month if it exceed the number of days in it, it will start over in same month
        System.out.println(calendar.getTime());
    }    
}
