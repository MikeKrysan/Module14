package Solution14_3_0;

public class MyInterfaceImpl implements MyInterface {

    @Override
    public void doTask(String message) {
        System.out.println("Делаю особую задачу: " + message);
    }

    //опционально - мы не обязаны имплементировать дефолтный метод родительского интерфейса
    @Override
    public void doDefaultTask() {
        System.out.println("Делаю задание по умолчанию, но не спеша");
    }
}

