import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
Необходимо список строк перевести в список чисел и произвести их последовательное перемножение.
Решите задачу, сначала используя обычный подход, а затем попробуйте написать тот же код на стримах.
 */
public class Solution14_5_8 {
    /*

     //Подход со стримами
    public static void main(String[] args) {
//        Stream<String> stream = Stream.of("monkey", "gorilla", "bonobozos");
//        stream
//                .map(String::length)   //трансформируем строки в их длины, получаем Stream<Integer>
//                .reduce(1, ((integer, integer2) -> integer * integer2));
//
////                .forEach(System.out::print); //679
//
//        Object object = new Object();
//        System.out.println(object.hashCode(stream));

        int multiply = Stream.of("1", "2", "3", "4", "5")
                .map(Integer::parseInt)
                .reduce(1,((integer, integer2) -> integer * integer2));
        System.out.println(multiply);

    }
    */


    //Обычный подход
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("1", "2", "3", "4", "5");
        List<Integer> integers = new ArrayList<>();
        for(String s : strings) {
            integers.add(Integer.parseInt(s));
        }
        int multiply = 1;
        for(int i:integers) {
            multiply *=i;
        }
        System.out.println(multiply);
    }
}
