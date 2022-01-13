import java.util.*;
import java.util.stream.Stream;

/*
Перепешите данный код, используя стримы
 */

public class Solution14_5_10 {
    public static void main(String[] args) {
        //Стандартный подход
//        List<Double> list = Arrays.asList(117d, 12.2d, 66d, 18.5d);
//        List<String> list2 = Arrays.asList("15", "18.5", "117", "22.2");
//        List<Double> doubles = new ArrayList<>();
//        for(String s : list2)  {
//            doubles.add(Double.valueOf(s));
//        }
//        Set<Double> sortedDoubles = new TreeSet<> (Comparator.reverseOrder());
//        sortedDoubles.addAll(list);
//        sortedDoubles.addAll(doubles);
//        for(double d : sortedDoubles) {
//            System.out.println(d);
//        }

        //Код с использованием стримов
        List<Double> list = Arrays.asList(117d, 12.2d, 66d, 18.5d);
        List<String> list2 = Arrays.asList("15", "18.5", "117", "22.2");
        Stream.concat(      // concat() - Creates a lazily concatenated stream whose elements are all the elements of the first stream followed by all the elements of the second stream.
                list.stream(),  //stream() - Возвращает последовательный поток с этой коллекцией в качестве источника.
                list2.stream().map(Double::valueOf) //map() -Возвращает поток, состоящий из результатов применения заданной функции к элементам этого потока.
        )
        .distinct() // Возвращает поток, состоящий из отдельных элементов (в соответствии с Object.equals(Object)) этого потока.
                .sorted(Comparator.reverseOrder())  //1, sorted() -Возвращает поток, состоящий из элементов этого потока, отсортированных в соответствии с предоставленным Компаратором.
                .forEach(System.out::println);  //Performs an action for each element of this stream.

    }
}

/*
Результат вывода в консоль:
117.0
66.0
22.2
18.5
15.0
12.2
1. reverseOrder() -Возвращает компаратор, который устанавливает обратный естественный порядок.
 */