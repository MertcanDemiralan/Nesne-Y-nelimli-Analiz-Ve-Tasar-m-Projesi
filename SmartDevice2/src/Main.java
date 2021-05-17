import api.Service;
import ui.IObserver;
import ui.Klavye;
import ui.Yazici;
import ui.Subscriber;

public class Main {

    public static void main(String[] args) {

        Klavye kb = new Klavye();
        IObserver sub1 = new Subscriber();
        Yazici p = new Yazici(sub1); // dependency inversion
        Service service = new Service.ServiceBuilder("SmartDeviceDB")
                .username("postgres")
                .password("12345")
                .build();

        Eyleyici eyleyici = new Eyleyici(service, p);
        SicaklikAlgilayici sicaklikAlgilayici = new SicaklikAlgilayici(service, p);
        AgArayuzu agArayuzu = new AgArayuzu(service, p, kb, eyleyici, sicaklikAlgilayici);
        // final
        agArayuzu.menu(agArayuzu.girisIslemleri());
    }
}
