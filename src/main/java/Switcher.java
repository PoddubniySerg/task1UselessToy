public class Switcher {
    private volatile boolean switherTurnOn;

    public Switcher() {
        this.switherTurnOn = false;
    }

    public boolean isSwitherTurnOn() {
        return switherTurnOn;
    }

    public void setSwitherTurnOn(boolean switherTurnOn) {
        this.switherTurnOn = switherTurnOn;
    }
}
