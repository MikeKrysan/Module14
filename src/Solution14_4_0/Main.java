package Solution14_4_0;

import java.sql.SQLOutput;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
//        Optional<Double> avarage = avarage(90, 100);
        //isPresent() - возвращает true когда Optional.of(value)
        Optional<Double> avarage = avarage();

        if(avarage.isPresent()) {
            System.out.println(avarage.get());  //95.0
        }

        avarage.ifPresent(System.out::println); //95.0  //вызывает Consumer и передает в него value

        System.out.println(avarage.orElse(Double.NaN)); //возвращает value  //(2)
        System.out.println(avarage.orElseGet(Math::random));    //возвращает value
        System.out.println(avarage.orElseThrow(IllegalStateException::new));    //возвращает value
    }

    public static Optional<Double> avarage(int... scores) { //для использования возможности вставить переменное количество параметров используется многоточие после указания типа. (1)
        if (scores.length == 0) {
            return Optional.empty();
        }
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return Optional.of((double) sum / scores.length);   //все методы вызываем для Optional.of(value)
    }
}

/*
1. Использование int... в примере равнозначно int[], только вы не заботитесь о создании массива(это делает компилятор)
2. Результат будет:
NaN
0.8808268753998181
Exception in thread "main" java.lang.IllegalStateException
	at java.base/java.util.Optional.orElseThrow(Optional.java:403)
	at Solution14_4_0.Main.main(Main.java:21)

 */