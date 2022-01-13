import java.util.stream.Stream;

public class Solution14_5_5 {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1,2,3);
        int result = stream
                .filter(integer -> integer <= 2)
                .findFirst()
                .orElse(4); //If a value is present, returns the value, otherwise returns other.
        System.out.println(result);
    }
}
