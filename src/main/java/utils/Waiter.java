package utils;

/**
 * Created by Billy on 1/14/2017.
 */
public class Waiter {
    public static void waitSomeTime(int miliSeconds){
        try {
            Thread.sleep(miliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
