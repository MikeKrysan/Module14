import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution14_5_0_3 {
    public static void main(String[] args) {
//        IntStream stream = IntStream.rangeClosed(1, 4);
//        System.out.println(stream.peek(System.out::println).sum()); //1 выводим в консоль все проходящие в стриме значения

        //2
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(5);

        Stream<List<Integer>> stream = Stream.of(list1, list2);

        stream.peek(list -> list.remove(0)).map(List::size).forEach((System.out::println)); //мы в методе peek() изменили длину стрима, что крайне не рекомендуется делать, peek() нужно делать не видоизменяя источник стримов
    }
}

/*
1. peek() - пропускает через себя все элементы стрима, и выполняет с ними какие-нибудь операции
Очень удобно работать с данным методом, так как возможно узнать какие именно элементы проходят через промежуточную операцию  нашего стрима
2 Но данный метод(1) не должна модифицировать источник стрима
 */