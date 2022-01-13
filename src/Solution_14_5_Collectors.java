import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Коллекторы существуют для того, чтобы вернтуть преобразованную операцию стрима в коллекцию
Например, хранить отфильтрованные результаты. Коллекторы создаются путем вызова
статических методов у класса Collectors
 */
public class Solution_14_5_Collectors {
    public static void main(String[] args) {

        //Случаи Map, когда значение выступает один объект
//        Stream<String> ohMy = Stream.of("lion", "tigers", "bears");   //(1)
//        String result = ohMy.collect(Collectors.joining(", " ));    // позволяет соединять элементы стрима по передаваемому значению
//        System.out.println(result); //lions, tigers, bears

//        Stream<String> ohMy = Stream.of("lion", "tigers", "bears");
//        Double result = ohMy.collect(Collectors.averagingInt(String::length)); //позволяет подсчитать среднее арифметическое значение чисел(есть методы также для double, long, int)
//        System.out.println(result); //5.33333333

//        Stream<String>  ohMy = Stream.of("lions", "tigers",  "bears", "takumi");
//        TreeSet<String> result = ohMy
//                .filter(s -> s.startsWith("t"))
//                .collect(Collectors.toCollection(TreeSet::new)); // записали результат в коллекцию, при этом помимо общего метода toCollection() можем пользоваться спецефичными toList(), toSet()
//        System.out.println(result); //[takumi, tigers]

//        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");    //(2)
//        Map<String, Integer> map = ohMy.collect(Collectors.toMap(   //собираем результаты работы в Map
//                s -> s, String::length  //первый аргумент - ключ нашей Map(сами элементы стрима в данном случае), второй аргумент - значения по ключу - длины элементов-строк
//        )); //{lions = 5, bears = 5, tigers = 6}


//        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
//        Map<Integer, String> map = ohMy.collect(Collectors.toMap(
//              String::length,   //ключ - длина массива
//              k -> k,   //значение - сами строки
//                (s1, s2) -> s1 + ", " +s2   //таким образом объединяем строки по одинаковому ключу. В третьем параметре мы определяем, что мы хотим иметь дело с одинаковыми ключами - складывать их через запятую
//        )); //{5 = lions, bears, 6 = tigers}
//        System.out.println(map.getClass()); // class java.util.HashMap

//        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
//        Map<Integer, String> map = ohMy.collect(Collectors.toMap(
//                String::length,   //ключ - длина массива
//                k -> k,   //значение - сами строки
//                (s1, s2) -> s1 + "," +s2,   //таким образом объединяем строки по одинаковому ключу.
//                TreeMap::new    //указали Java дать конкретную требуемую имплементацию
//        )); //{5 = lions, bears, 6 = tigers}
//        System.out.println(map.getClass());


        //Случай Map, когда значением выступает коллекция

//        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
//        Map<Integer, List<String>> map = ohMy.collect(Collectors.groupingBy(String::length));
//        System.out.println(map);    //{5=[lions, bears], 6=[tigers]}

        //Такая простая и элегантная запись позволила сгруппировать нам в листы значения по ключам, равным длинам этих самых значений.

        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");    //(3)
        Map<Boolean, List<String>> map = ohMy.collect(Collectors.partitioningBy(s -> s.length() <= 5));
        System.out.println(map);//{false=[tigers], true=[lions, bears]
        //ут мы меняем стратегию и буквально «делим пополам» наш стрим по некоему условию. Ключами выступают boolean true или false

    }
}

/*
1. collect() - Выполняет изменяемую операцию редукции элементов этого потока с помощью Collector.
2. - таким коллектором Map мы можем пользоваться только тогда, если мы знаем, что ключи в будущей Map не будут дублироваться
    В обратном случае Java не поймет, как хранить несколько значений по одному ключу и выбросит ошибку при запуске
3. При этом помните, что каким бы ни было передаваемое условие деления — ключи true и false всегда будут содержаться в финальной Map.
    Если ни одного значения нет по одному или другому ключу, то хранится пустая коллекция.
 */