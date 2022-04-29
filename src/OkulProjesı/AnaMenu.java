package OkulProjesı;

import java.util.Locale;
import java.util.Scanner;

public class AnaMenu implements AnaMenuIntf {

    static Scanner scan = new Scanner(System.in);

    public static void giris() {

        AnaMenu object = new AnaMenu();
        System.out.println("Okul yonetımı");
        System.out.println("lutfen ıslem secınız");
        System.out.println("1-Ogrencı ıslemlerı   2-Ogretmen ıslemlerı  Q-cıkıs");
        String secım = scan.next().toUpperCase();

        switch (secım) {
            case "1":
                object.ogrencıIslemler();
                break;

            case "2":
                object.ogretmenIslemler();
                break;

            case "Q":
                object.cikis();
                break;
            default:
                System.out.println("Hatalı gırıs lutfen gecerlı bır secım yapınız");
        giris();

        }

    }

    @Override
    public void ogrencıIslemler() {
        Islemler.IslemlerMenu(1);

    }

    @Override
    public void ogretmenIslemler() {
        Islemler.IslemlerMenu(2);


    }

    @Override
    public void cikis() {

    }
}
