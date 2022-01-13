import java.util.stream.Stream;

public class Solution14_5_3 {
    public static void main(String[] args) {
        Stream<Integer> infinite = Stream.iterate(2, x -> x * 2);
        System.out.println(infinite.anyMatch(test -> test/8 == 0)); //true (1)
    }
}

/*
1. Получаем бесконечный стрим из чисел, помноженных на 2 (2, 4, 8, 16 ...). при любом совпадении когда test/8 без остатка вернет true
 */