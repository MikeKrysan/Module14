import java.util.stream.Stream;

public class Solution14_5_6 {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("One", "Two");
        stream.limit(3).skip(2).forEach(System.out::println);   //1, 2
    }
}

/*
1 skip() - Возвращает поток, состоящий из оставшихся элементов этого потока после отбрасывания первых n элементов потока
2 limit()  - 109 / 5 000
Результаты перевода
Возвращает поток, состоящий из элементов этого потока, усеченный так, чтобы его длина не превышала maxSize.
 */