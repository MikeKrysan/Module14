//Напишите вместо знаков ? правильный тип интерфейса, чтобы пример компилировался:


import java.util.function.Supplier;

public class Solution14_2_6 {
    public static void main(String[] args) {
        task(() -> 65.7);
    }
    private static void task(/*???*/Supplier<Double> param) {} //вставьте тип
}
