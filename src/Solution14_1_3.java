/*
Напишите метод, который будет принимать 2 объекта: 1 типа LocalTime и 2 типа Duration,
 и будет возвращать true, если переданное время + промежуток больше текущего времени.
 */

import java.time.Duration;
import java.time.LocalTime;

public class Solution14_1_3 {
    public static void main(String[] args) {
        //Моя реализация. В методе не выходит сравнить две переменных одного класса через ">"
        LocalTime time = LocalTime.of(18, 12);  //Сравниваем с местным временем. Если больще - результат вызова метода будет true, если меньше - false
        Duration duration = Duration.ofMinutes(45);
//
//        Duration duration = Duration.ofSeconds(3000);
//        long hours = duration.toHours();
//        int minutes = (int) ((duration.getSeconds() % (60 * 60)) / 60);
//        int seconds = (int) (duration.getSeconds() % 60);
//        System.out.println(hours + ":" + minutes + ":" + seconds);
//
//        LocalTime newTime = time.plus(duration);
//        System.out.println(workLunchTime(time, newTime));
//    }
//    public static boolean workLunchTime(LocalTime time, LocalTime newTime) {
//        if(time > newTime){   //В этом месте компилятор ругается (bad operand types for binary operator '>')
//            return false;
//        }
//            return true;
//    }

        System.out.println(isGreaterTime(time, duration));
    }

    //Решение варианта по курсу
    private static boolean isGreaterTime(LocalTime time, Duration duration) {
        return time.plus(duration).isAfter(LocalTime.now());
    }
}


/*
А как-то можно перевести время в Array к int и сравнить два числа?

    Duration duration = Duration.ofSeconds(3000);
    long hours = duration.toHours();
    int minutes = (int) ((duration.getSeconds() % (60 * 60)) / 60);
    int seconds = (int) (duration.getSeconds() % 60);
    System.out.println(hours + ":" + minutes + ":" + seconds);

    private long printDuration(long start) {
        long end = System.currentTimeMillis();
        long duration = end - start;
        return duration;
    }
 */