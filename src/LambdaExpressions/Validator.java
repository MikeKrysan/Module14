package LambdaExpressions;
//@FunctionalInterface    //аннотация необходима для лямбда-фунций
public interface Validator {
    boolean validate(int value); //Метод принимает значение типа int, возвращает boolean
}
