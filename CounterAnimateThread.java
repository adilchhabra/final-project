public class CounterAnimateThread extends Thread {

    private Clock theCounter;

    public CounterAnimateThread(Clock cp) {
        theCounter = cp;
    }

    public void run() {

        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            theCounter.bumpCount();
        }

    }

}