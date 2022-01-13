package Solution14_3_3;

public interface Swimmer {
    default int getResult() {
        return 15;
    }

    default void swim() {
        System.out.println("Swimming");
    }
}
