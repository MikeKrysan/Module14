import java.time.LocalTime;

public class Solution14_1 {
    public static void main(String[] args) {
        LocalTime time = LocalTime.of(16, 30); // строка 1
        time.withHour(14).plusMinutes(15);
//        time = time.withHour(14).plusMinutes(15);//(1)
//        System.out.println(time);
        LocalTime newtime = time.withHour(14). plusMinutes(15); //(2)
        System.out.println(newtime);

    }
}

/*
Выведет в консоль:
16:30
то есть все модификации не возымели эффект. Теперь добейтесь того, чтобы мы получили желаемые 14:45.

Выберите из предложенного ниже, как мы можем этого добиться:

(1) нужно вернуть результат методов снова в переменную time (но тогда потеряете доступ к первоначально созданному объекту на строке 1);
(2) нужно создать новую ссылочную переменную LocalTime newTime и присвоить результат в нее (не забыв, конечно, теперь передать newTime в System.out.println()).

Важно обратить внимание на 2 особенности при работе с этим API:

1
Объекты данных типов являются неизменяемыми (immutable). Напомним, что представителем такого типа является класс String. Это означает, что после того, как объект был создан,
он не может быть модифицирован (отсутствуют сеттеры на поля объекта).

2
Не путайте назначения временных классов (LocalTime, LocalDateTime). Если у вас есть экземпляр класса LocalDate, то он не может работать с временем, и наоборот.
Поэтому такой код компилироваться не будет!
 */