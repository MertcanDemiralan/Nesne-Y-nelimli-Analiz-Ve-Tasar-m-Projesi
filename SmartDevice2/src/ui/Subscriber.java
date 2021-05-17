package ui;

/**
 * subscriber Observerin alıcısı
 */

public class Subscriber implements IObserver{
    @Override
    public void update(String msg) {
        System.out.print(msg);
    }
}
