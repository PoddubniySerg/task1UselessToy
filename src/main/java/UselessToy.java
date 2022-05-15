public class UselessToy implements Runnable {
    private static final long WAITING_TIME = 1000;
    private final Switcher switcher;

    public UselessToy(Switcher switcher) {
        this.switcher = switcher;
    }

    @Override
    public void run() {
        int counter = 1;
        while (!Thread.currentThread().isInterrupted()) {
            if (switcher.isSwitherTurnOn()) {
                try {
                    Thread.sleep(WAITING_TIME);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                switcher.setSwitherTurnOn(false);
                System.out.println("Поток " + Thread.currentThread().getName() + " выключил тумблер в " + counter + "-й раз");
                counter++;
            }
        }
    }
}
