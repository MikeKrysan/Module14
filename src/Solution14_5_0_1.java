import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Solution14_5_0_1 {
    public static void main(String[] args) {
            //1
//        Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
//        s
//                .filter(x -> x.startsWith("m")) //оставляем лишь элементы начинающиеся с m
//                .forEach(System.out::println);  //monkey

            //2
//        Stream<String> stream = Stream.of("duck", "duck", "duck", "goose");
//        stream
//                .distinct() //оставляем уникальные элементы
//                .forEach(System.out::print);  //duckgoose

            //3
//        Stream<Integer> str = Stream.iterate(1, n -> n + 1);
//        str
//                .skip(5)    //пропускаем первые 5 элементов
//                .limit(2)   //ограничиваем данные 2 элементами
//                .forEach(System.out::print);  //67

            //4
//        Stream<String> stream1 = Stream.of("monkey", "gorilla", "bonobozos");
//        stream1
//                .map(String::length)   //трансформируем строки в их длины, получаем Stream<Integer>
//                .forEach(System.out::print); //679

            //5
//        List<String> zero = Arrays.asList();
//        List<String>  one = Arrays.asList("bonobo");
//        List<String>    two = Arrays.asList("mama gorilla", "baby gorilla");

//        Stream<List<String>> animals = Stream.of(zero, one, two);
//        Stream<String> stringStream = animals.flatMap(list -> list.stream());
//        stringStream.forEach(System.out::print); //bonobomama gorillababy gorilla

            //6
//        Stream<String> s = Stream.of("brown-", "bear-");
//        s.sorted().forEach(System.out::print);  //1. bear-brown-

        Stream<String> s1 = Stream.of("brown bear-", "grizzly-");
        s1.sorted(Comparator.reverseOrder()).forEach(System.out::print);  //grizzly-brown bear-


    }
}

/*
1. sorted()-Возвращает поток, состоящий из элементов этого потока, отсортированных в естественном порядке.
 */