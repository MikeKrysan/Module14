/*
Создайте метод, который принимает в качестве аргумента объект java.util.Date и возвращает объект LocalTime, содержащий время переданного объекта в вашем часовом поясе.


 */

import java.time.*;
import java.util.Date;

public class Solution14_1_7 {
    //Мой вариант решения
//    public static void main(String[] args) {
//        dateInTime();
//    }
//    public static void dateInTime() {
//        LocalDate date = LocalDate.now();
//        LocalDateTime dateTime = LocalDateTime.from(ZonedDateTime.of(date, LocalTime.now(), ZoneId.of("Europe/Paris")));
//        System.out.println(dateTime);
//    }

    //вариант решения с курса
    public static void main(String[] args) {
        //convertDateToTime();
    }
    public static LocalTime convertDateToTime(Date date) {
        Instant instant = date.toInstant(); //Для конвертации между старым классом Date и новым API нам потребуется промежуточный класс java.time.Instant.
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of("Europe/Moscow")); //(1), конструктор atZone()-(2)
        return zonedDateTime.toLocalTime(); //(3)
    }

}

/*
1. Объект этого класса представляет определенный момент времени во временной зоне Гринвича (GMT+0). Так как этот объект содержит понятие «временная зона»,
мы можем конвертировать этот объект только в ZonedDateTime и обратно.
2. Конвертируем Instant в ZonedDateTime согласно переданному значению временной зоны:
ZonedDateTime zonedDateTime = instantObject.atZone(ZoneId.of("Europe/Moscow"));

3. toLocalTime - Gets the LocalTime part of this date-time.
 */