package KahveProjesi;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Islemler extends KahveBilgileri implements ToDoList {
    static Scanner scan = new Scanner(System.in);
    static String hangiKahve = "";
    static Map<String, KahveBilgileri> kahveBilgileriMap = new HashMap<>();
    static int totalFatura = 0;

    public static void start() throws InterruptedException {
        System.out.println("*****40YIL HATIR BIRAKAN MAKİNEYE HOŞGELDİNİZ*****\n");
        giris();
    }

    public static void giris() throws InterruptedException {
        Islemler obj = new Islemler();
        obj.listele();
        int secim = TryCatch.intGiris();
        switch (secim) {
            case 1:
                hangiKahve = "Türk Kahvesi";
                obj.kahveBoyutuDuzenle();
                obj.sekerEkle();
                obj.beklet();
                obj.faturala();
                break;
            case 2:
                hangiKahve = "Filtre Kahve";
                obj.kahveBoyutuDuzenle();
                obj.beklet();
                obj.faturala();
                break;
            case 3:
                hangiKahve = "Expresso";
                obj.kahveBoyutuDuzenle();
                obj.sekerEkle();
                obj.beklet();
                obj.faturala();
                break;
            case 4:
                obj.cıkıs();
                break;
        }
    }


    @Override
    public void beklet() throws InterruptedException {
        System.out.print(hangiKahve + " Hazırlanıyor");
        for (int i = 1; i <= 3; i++) {
            System.out.print(".");
            Thread.sleep(1500);
        }

        System.out.println("\nKahveniz Hazır .Afiyet olsun :)\n");
    }

    @Override
    public void listele() {
        System.out.println("*1-Türk Kahvesi\n**2-Filtre Kahve\n***3-Expresso\n****4-Çıkış");
    }

    @Override
    public void sütEkle() throws InterruptedException {
        System.out.println("\nSüt eklememizi ister misiniz ? (Evet veya Hayır olarak cevaplayınız)");
        String cevap = scan.next();
        if (cevap.equalsIgnoreCase("evet")) {
            System.out.print("Süt Ekleniyor");
            for (int i = 1; i <= 3; i++) {
                System.out.print(".");
                Thread.sleep(1500);
            }
        } else if (cevap.equalsIgnoreCase("hayır")) {
            System.out.println("Süt eklenmeyecektir...");
        } else {
            System.out.println("lütfen geçerli bir cevap giriniz");
            sütEkle();
        }


    }

    @Override
    public void sekerEkle() throws InterruptedException {
        System.out.println("Şeker eklememizi ister misiniz ? (Evet veya Hayır olarak cevaplayınız)");
        String cevap = scan.next();
        if (cevap.equalsIgnoreCase("evet")) {
            System.out.println("Kaç küp şeker eklemesini istersiniz?\n");
            int seker = TryCatch.intGiris();
            System.out.print(seker + " adet şeker ekleniyor");
            for (int i = 1; i <= 3; i++) {
                System.out.print(".");
                Thread.sleep(1500);
            }
            sütEkle();
        } else if (cevap.equalsIgnoreCase("hayır")) {
            System.out.println("Şeker eklenmeyecektir.");
            sütEkle();
        } else {
            System.out.println("lütfen geçerli bir cevap giriniz");
            sekerEkle();
        }
    }

    @Override
    public void cıkıs() {
        System.out.println("40 Yıl Hatır için Yine Bekleriz...");

    }

    @Override
    public void kahveBoyutuDuzenle() {
        KahveBilgileri kahve = new KahveBilgileri();
        System.out.println("Kahveniz Hangi boyutta Olsun?\n1-->Küçük \n2-->Orta \n3-->Büyük");
        int secim = TryCatch.intGiris();
        if (secim == 1) {
            kahve.setBoyut("Küçük");
            kahve.setFiyat(secim);
            kahveBilgileriMap.put(hangiKahve, kahve);
        } else if (secim == 2) {
            kahve.setBoyut("Orta");
            kahve.setFiyat(secim);
            kahveBilgileriMap.put(hangiKahve, kahve);
        } else if (secim == 3) {
            kahve.setBoyut("Büyük");
            kahve.setFiyat(secim);
            kahveBilgileriMap.put(hangiKahve, kahve);
        } else {
            System.out.println("lütfen geçerli bir seçim yapınız");
            kahveBoyutuDuzenle();
        }
        totalFatura+=kahve.getFiyat();

    }

    @Override
    public void faturala() throws InterruptedException {
        System.out.println("Faturanız-->" + totalFatura);
        while (true) {
            System.out.print("\nLütfen çıkış için 1'i başka bir kahve almak için 2'yi tuslayınız");
            int secm = TryCatch.intGiris();
            if (secm == 1) {
                cıkıs();
                break;
            } else if (secm == 2) {
                giris();
                break;
            } else {
                System.out.println("lütfen geçerli bir seçim yapınız");
            }
        }

    }
}
