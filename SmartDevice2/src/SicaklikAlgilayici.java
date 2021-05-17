import api.Service;
import ui.Yazici;

import java.util.Random;

public class SicaklikAlgilayici implements ISicaklikAlgilayici {
    private Service service;
    private Yazici p;

    public SicaklikAlgilayici(Service service, Yazici p) {
        this.service = service;
        this.p = p;
    }

    @Override
    public void sicaklikOku() {
        service.sicaklikGuncelle((new Random().nextDouble() * 100) % 45);
        double t = service.sicaklikGetir();
        p.EkranaYaz("Sıcaklık : %.2f\n\n", t);
    }
}
