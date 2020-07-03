package Dealers;

import Details.Auto;
import Storage.AutoStorage;

public class Dealer implements Runnable {
    private int delay;
    private AutoStorage autoStorage;

    public Dealer(AutoStorage autoStorage, int delay) {
        this.delay = delay;
        this.autoStorage = autoStorage;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Auto auto = autoStorage.getAuto();

                System.out.println(
                        "Dealer " + Thread.currentThread().getName() + ":"
                                + "Auto " + auto.getId() + "("
                                + "Body " + auto.getBodyDetail().getId() + ","
                                + "Motor " + auto.getMotorDetail().getId() + ","
                                + "Accessory " + auto.getAccessoryDetail().getId() + ")");
                Thread.sleep(delay);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void setDelay(int delay) {
        this.delay = delay;
    }
}