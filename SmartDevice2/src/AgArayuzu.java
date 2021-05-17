import api.Service;
import ui.Klavye;
import ui.Yazici;

public class AgArayuzu implements IAgArayuzu {
    Service service;
    Yazici p;
    Klavye kb;
    Eyleyici eyleyici;
    SicaklikAlgilayici sicaklikAlgilayici;

    public AgArayuzu(Service service, Yazici p, Klavye kb, Eyleyici eyleyici, SicaklikAlgilayici sicaklikAlgilayici) {
        this.service = service;
        this.p = p;
        this.kb = kb;
        this.eyleyici = eyleyici;
        this.sicaklikAlgilayici = sicaklikAlgilayici;
    }

    @Override
    public boolean girisIslemleri() {
        p.EkranaYaz("Giriş Yapın");
        p.EkranaYaz("username :");
        String un = kb.getString();
        p.EkranaYaz("password :");
        String pw = kb.getString();
        boolean b = service.girisYap(un, pw);
        if (!b)
            p.EkranaYaz("Giriş Başarısız..");
        else
            p.EkranaYaz("Giriş Başarılı..");
        return b;
    }

    @Override
    public void menu(boolean b) {
        while (b) {
            p.EkranaYaz("1) Sicaklik Olcme");
            p.EkranaYaz("2) Sogutucu Ac");
            p.EkranaYaz("3) Sogutucu Kapat");
            p.EkranaYaz("4) Kapat");
            int ch = kb.getInt();
            if (ch == 1) {
                sicaklikAlgilayici.sicaklikOku();
            } else if (ch == 2) {
                eyleyici.sogutucuAc();
            } else if (ch == 3) {
                eyleyici.sogutucuKapat();
            } else if (ch == 4) {
                break;
            } else {
                p.EkranaYaz("Geçersiz Seçim!!!");
            }
        }
    }
}
