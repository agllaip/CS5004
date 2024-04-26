import java.time.LocalDate;                     // LocalDate class - represents a date
import java.time.YearMonth;                     // YearMonth class - represents a year and month

public class MayCalendar {
    public static void main(String[] args) {

        // Get the current year.
        int year = LocalDate.now().getYear();

        // Create a YearMonth object for May of the current year
        // Jan = 1, Feb = 2, March = 3, April = 4, May = 5, and so on ...
        YearMonth yearMonth = YearMonth.of(year, 5);

        // Print header (Month and Year plus the days of the week)
        System.out.println("             May " + year);
        System.out.println("Sun  Mon Tue Wed Thu Fri Sat");

        // Get the day the month of May starts on
        // Mon = 1, Tue = 2, and so on ...
        int startDayOfMonth = yearMonth.atDay(1).getDayOfWeek().getValue();

        // Print leading spaces before the first day of the Month
        for (int i = 1; i < startDayOfMonth; i++) {
            System.out.print("      ");
        }

        // Print the days of May
        for (int day = 1; day <= yearMonth.lengthOfMonth(); day++) {
            System.out.printf("%4d", day);

            // Check if the next day is Sunday, if it is start a new line
            if (yearMonth.atDay(day).getDayOfWeek().getValue() == 6) {
                System.out.println();
            }
        }
    }
}