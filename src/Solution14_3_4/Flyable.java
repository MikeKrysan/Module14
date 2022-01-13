package Solution14_3_4;

public interface Flyable {
    default void fly() {
        System.out.println("Flying");
    }
}
