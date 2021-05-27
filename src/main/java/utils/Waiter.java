package utils;

public class Waiter {

    /**
     * Слагам си по някой друг sleep по време на билдване на теста за да видя до къде съм стигнал :)
      * @param waitInSeconds Thread.sleep * 1000.
     */
    public static void waitFor(int waitInSeconds){
        try {
            Thread.sleep(waitInSeconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
