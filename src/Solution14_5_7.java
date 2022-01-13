import java.util.stream.Stream;

public class Solution14_5_7 {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.iterate(1, integer -> integer + 1);
        boolean match = stream
                .map(String::valueOf)   //"1", "2", "3", "4", "5" и т.д.
                .distinct() //Возвращает поток, состоящий из отдельных элементов этого потока.
                .limit(5)   //"1", t"2", "3", "4", "5"
                .noneMatch(str -> str.length() != 1); //true (1)
        System.out.println(match);
    }
}
/*
1. Возвращает значение, указывающее, не соответствуют ли никакие элементы этого потока предоставленному предикату.
Может не оценивать предикат для всех элементов, если это не необходимо для определения результата. Если поток пуст, возвращается true, и предикат не оценивается.
 */