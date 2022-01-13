import java.time.*;

//что делает данный код?
public class Solution14_1_6 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2029, 8, 4);
        Period period = Period.ofDays(3);
        date = date.minus(period); // строка 1
        Duration duration = Duration.ofHours(12);
        LocalDateTime dateTime = LocalDateTime.of(date, LocalTime.of(8, 0));
        dateTime.plus(duration); // строка 2
        System.out.println(dateTime);
    }
}

/*
2029-08-01T08:00
 */