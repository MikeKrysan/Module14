import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class Solution14_5_9 {
    public static void main(String[] args) {
        IntStream stream = IntStream.generate(() -> 15);
        OptionalDouble average = stream.mapToLong(integer -> integer).average();
        System.out.println(average.orElseThrow(() -> new RuntimeException()));
    }
}

/*
    Программа будет работать, пока ее не убьешь
 */