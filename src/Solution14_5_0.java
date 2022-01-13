import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Solution14_5_0 {
    public static void main(String[] args) {
//        List<String> list = Arrays.asList("monkey", "2", "chimp");
//        Stream<String> infinite = Stream.generate(() -> "chimp");    //бесконечный стрим строки
//        Predicate<String> pred = x -> Character.isLetter(x.charAt(0));  //проверка - первый символ - буква
//        System.out.println(list.stream().anyMatch(pred)); //true - (какой-нибудь элемент из списка является буквой?)
//        System.out.println(list.stream().allMatch(pred)); //false  - (все элементы списка являются буквенным содержимым?)
//        System.out.println(list.stream().noneMatch(pred)); //false  - (ни один из элементов листа не является буквенным элементом)
//        System.out.println(infinite.anyMatch(pred)); //true - (какой-либо из элементов является буквенным значением?)

//        Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
//        System.out.println(s.count());  //3

//        Stream<String> st = Stream.of("monkey", "ape", "bonobo");
//        Optional<String> min = st.min((s1, s2) -> s1.length() - s2.length());
//        //минимум по длине
//        min.ifPresent(System.out::println); //ape

//        Stream<String> stream = Stream.of("monkey", "gorilla", "bonobo");
//        Stream<String> inf = Stream.generate(() -> "chimp");
//        stream.findAny().ifPresent(System.out::println);    //monkey - возвращает любой один элемент из стрима (первый)
//        inf.findAny().ifPresent(System.out::println);   //chimp

//        Stream<String> printable = Stream.of("Monkey", "Gorilla", "Bonobo");
//        printable.forEach(System.out::print);   //MonkeyGorillaBonobo

//        Stream<String> stringStream = Stream.of("w", "o", "l", "f");
//        String word = stringStream.reduce("" ,(b, c) -> b + c);
//        System.out.println(word);   //wolf

        Stream<String> collectStream = Stream.of("w", "o", "l", "f");
        StringBuilder wolfBuilder = collectStream.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        String wolf = wolfBuilder.toString();
        System.out.println(wolf);

    }
}
