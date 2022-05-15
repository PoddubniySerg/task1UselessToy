public class Main {
    public static void main(String[] args) throws InterruptedException {
        Switcher switcher = new Switcher();
        Thread toy = new Thread(new UselessToy(switcher), "Toy");
        Thread user = new Thread(new User(switcher), "User");
        toy.start();
        user.start();
        user.join();
        toy.interrupt();
    }
}