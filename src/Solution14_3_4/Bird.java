package Solution14_3_4;

public class Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("Bird flying");
    }

    public static void main(String[] args) {
        Flyable bird = new Bird();
        bird.fly();
        //System.out.println("I can fly");

    }
}

/*
Выведется в консоль:
Bird flying
 */