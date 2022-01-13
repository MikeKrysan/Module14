//Напишите вместо знаков ? правильный тип интерфейса, чтобы пример компилировался:

import java.util.function.Consumer;

public class Solution14_2_4 {
    public static void main(String[] args) {
        task(12, value -> {});
    }

    private static void task(int value, /*???*/Consumer<Integer> param) {}  //вставьте тип
}

