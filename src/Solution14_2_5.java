import java.util.function.BiPredicate;

//Напишите вместо знаков ? правильный тип интерфейса, чтобы пример компилировался:
public class Solution14_2_5 {
    public static void main(String[] args) {
        task((value1, value2) -> value1.endsWith(value2));
    }
    private static void task(/*???*/BiPredicate<String, String> param) {} //вставьте тип

}

/*
Подсказка (1 из 1): В вызове метода task передаем лямбду, которая принимает 2 аргумента и возвращаем boolean.
BiPredicate<T, U> - принимает 2 параметра и возвращает true-false («двойной проверяльщик»)
 */