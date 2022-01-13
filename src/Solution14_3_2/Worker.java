package Solution14_3_2;

public interface Worker {
    default void work() {
        System.out.println("Working");
    }
}

