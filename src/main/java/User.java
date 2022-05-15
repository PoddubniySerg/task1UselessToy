public class User implements Runnable {

    private static final long WAITING_TIME = 3000;
    private static final int COUNTER = 10;

    private final Switcher switcher;

    public User(Switcher switcher) {
        this.switcher = switcher;
    }

    @Override
    public void run() {
        int counter = COUNTER;
        while (counter > 0) {
            if (!switcher.isSwitherTurnOn()) {
                switcher.setSwitherTurnOn(true);
                System.out.println("Поток " + Thread.currentThread().getName() + " включил тумблер");
                counter--;
            }
            try {
                Thread.sleep(WAITING_TIME);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
