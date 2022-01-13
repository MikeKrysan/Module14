package Solution14_4_5;

import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

/*
Напишите такой метод, который принимает 1 параметр типа int guess (догадка) в диапазоне от 1 до 5 и возвращает Optional<String> (выигрыш). Внутри метода реализуйте следующую логику:

если передаваемый guess не в требуемом диапазоне — бросайте IllegalStateException;
иначе: генерируйте рандомное значение int (для этого вам понадобится метод nextInt(int bound) класса java.util.Random);
    если сгенерированное значение равняется переданному значению guess тогда возвращайте Optional.of(“Поздравляем! Вы угадали значение!”));
    если же нет — Optional.empty().

Протестируйте ваш метод из main(), обрабатывая Optional<String> как вы хотите.
 */

public class Solution14_4_5 {

    public static int result = new Random().nextInt(5) + 1; //генерируем рандом
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Попробуйте отгадать число в диапазоне от 1 до 5 включительно");
        System.out.println("(Загаданное число: " + result + ")");
        int number = scanner.nextInt();
        Optional<Optional<String>> opt = Optional.of(isWin(result));
        System.out.println(opt);
    }

//    private Optional<String> isWin(int guess, int result) {
//        if(guess < 1 || guess > 5) {
//            throw new IllegalStateException("Вы вышли за рамки диапазона!"); //проверяем на граничные условия
//        } else if(result.equals(guess)){     //делаем проверку
//                return Optional.of("Поздравляем! Вы угадали значение!");
//            } else {
//                return Optional.empty();
//            }
//        }
//    }

    private static Optional<String> isWin(int guess) {
        if (guess < 1 || guess > 5) {
            throw new IllegalStateException(); // проверяем на граничные условия
        }

    else {
            int result = new Random().nextInt(5) + 1; // генерируем рандом
            System.out.println(result);

            if (result == guess) { // делаем проверку
                return Optional.of("Поздравляем! Вы угадали значение!");
            }

        else {
                return Optional.empty();
            }
        }
    }
}

/*
В консоль выводит:
Попробуйте отгадать число в диапазоне от 1 до 5 включительно
(Загаданное число: 4)
4
3
Optional[Optional.empty]

Задача не доведена до логического конца
 */