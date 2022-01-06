import java.time.*;
//Создайте объект класса ZonedDateTime c временем и датой текущего момента и с временной зоной города Москва.
public class Solution14_1_1 {
    public static void main(String[] args) {
        ZonedDateTime zdt = ZonedDateTime.of(LocalDate.now(), LocalTime.now(), ZoneId.of("Europe/Moscow"));
        System.out.println(zdt);
    }
}
