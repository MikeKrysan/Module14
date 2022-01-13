import java.util.Arrays;
import java.util.Optional;

public class Solution14_4_1 {
//    public static void main(String[] args) {
//        String text = "Hello";
//        Optional<String> opt = refactorText(text); //1
//        System.out.println(opt);
//        System.out.println(opt.isPresent());
//    }
//
//    public static Optional<String> refactorText(String... strings) { // если написать: public static Optional<String> refactorText(String... strings)
//        if(Arrays.stream(strings).count()< 5) {     //тогда в этой строке будет ошибка, компилятор ждет вводных данных
//            return null;
//        } else {
//            return Optional.of(strings + " refactored");
//        }
//    }

    public static void main(String[] args) {
        String text = "Hello";
        Optional<String> opt = Optional.of(refactorText(text)); // строка 1
        System.out.println(opt.isPresent());
    }

    private static String refactorText(String text) { // если написать: public static Optional<String> refactorText(String... strings)
        if (text.length() >= 5) {    //тогда в этой строке будет ошибка, компилятор ждет вводных данных
            return null;
        } else {
            return text + " refactored";
        }
    }


}

/*
Ошибка компиляции в строке 1.
 */

