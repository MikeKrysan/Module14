package Solution14_3_0;

public interface MyInterface {
    void doTask(String message);    //абстрактный метод

    default void doDefaultTask() { //дефолтный метод
        System.out.println("Делаю задание по умолчанию");
    } //(3)
}
