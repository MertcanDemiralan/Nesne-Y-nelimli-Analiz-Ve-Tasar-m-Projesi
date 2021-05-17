package ui;

/**
 * Print sınıfı bir nevi Publisher IObserver için alan
 **/
public class Yazici implements IYazici {

    private IObserver observer;

    public Yazici(IObserver observer) {
        this.observer = observer;
    }


    @Override
    public void EkranaYaz(String text) {
        observer.update(String.format("%s\n", text));
    }

    @Override
    public void EkranaYaz(String format, Object... args) {
        observer.update(String.format(format, args));
    }
}
