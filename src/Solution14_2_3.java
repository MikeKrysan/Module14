//Напишите пример вызова данного метода, используя лямбда-выражение:
public class Solution14_2_3 {
    public static void main(String[] args) {
            doubleFromString(25, val -> Double.valueOf(val));   //решение. не понятное пока для меня
    }

    public static double doubleFromString(int value, Worker worker) {
        return worker.rework(value);
    }

    public interface Worker {
        double rework(int value);
    }

}
