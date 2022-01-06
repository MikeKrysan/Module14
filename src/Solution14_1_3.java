/*
Напишите метод, который будет принимать 2 объекта: 1 типа LocalTime и 2 типа Duration,
 и будет возвращать true, если переданное время + промежуток больше текущего времени.
 */

import java.time.Duration;
import java.time.LocalTime;

public class Solution14_1_3 {
    public static void main(String[] args) {
        LocalTime time = LocalTime.of(8, 0);
        Duration duration = Duration.ofMinutes(45);
        LocalTime newTime = time.plus(duration);
        System.out.println(workLunchTime(newTime, duration));
    }
    public static boolean workLunchTime(LocalTime newTime, Duration duration) {
        if(newTime > duration){
            return true;
        }
            return false;
    }
}
