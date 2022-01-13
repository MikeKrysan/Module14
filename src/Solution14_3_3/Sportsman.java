package Solution14_3_3;

public class Sportsman implements Swimmer, Runner {
    public static void main(String[] args) {
        Sportsman sportsman = new Sportsman();
        System.out.println(sportsman.getResult());
    }
    @Override
    public int getResult() {
        return 20;
    }
}

/*
Добавив новые дефолтные методы в интерфейсах и принимая во внимание тот факт, что классы могут имплементировать множество интерфейсов, разработчики открыли проблему множественного наследования.
Но есть решение проблемы - нужно просто переопределить дефолтный метод в этом классе, чтобы Java понимала, какую имплементацию метода вызывать в Runtime
 */
