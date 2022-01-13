package LambdaExpressions;
/*
Изначально у нас есть класс Main и интерфейс Validator
 */

public class Main {
    public static void main(String[] args) {
        int value = 70;
//        validateMain(value, new ValidatorImpl());   //(1)
//        validateMain(value, new Validator() {   //(2)
//            @Override
//            public boolean validate(int value) {
//                return value >= 80;
//            }
//        });
        validateMain(value, (int value1) ->value >=60);

    }

    private static void validateMain(int value, Validator validator) {
        System.out.println("Проверяем переданное значение согласно валидатору...");
        boolean isValid = validator.validate(value);
        if(isValid) {
            System.out.println("Отлично! Значение верно!");
        } else {
            System.out.println("Упс! Значение не верно!");
        }
    }
}

/*
1. Первый способ отвалидаторить значение: создаем новый класс ValidatorImpl, который будет имплементить интерфейс Validator
    В этом классе метод validate будет сравнивать значение value >=60 со значение value класса Main

2. Мы можем реализовать имплементацию валидатора с помощью анонимного класса

Мы рассмотрели два возможных способа имплементировать валидатор, не используя лямбда-выражения.
Такими способами пользовались Java-разработчики до Java8. Минусы 1-го варианта: приходится создавать новый класс для каждого выражения
, минусы второго варианта: приходится создавать анонимный класс, синтаксис (строки 10-15) может стать нечитаемым со временем добавления условий к заданию
 */