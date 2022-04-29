package Depo_Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class islemler extends urunBılgısı {
    static List<urunBılgısı> urunListesi = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);
    static int ıd = 1000;

    public static void girisMenusu() {
        System.out.println("***********HOŞGELDİNİZ************");
        System.out.println("------>İŞLEM TERCİHİ YAPINIZ<------\n" +
                "1-->Ürün Güncellemesi     \n" +
                "2-->Ürün Girişi           \n" +
                "3-->Ürün Listeleme        \n" +
                "4-->Ürün Rafa Yerleştirme \n" +
                "5-->Ürün Çıkışı           \n" +
                "6-->Çıkış                 \n");

        int secim = scan.nextInt();
        switch (secim) {
            case 1:
                guncelle();
                girisMenusu();
                break;
            case 2:
                urunGirisi();
                girisMenusu();
                break;
            case 3:
                urunListele();
                girisMenusu();
                break;
            case 4:
                rafaYerlestırme();
                girisMenusu();
                break;
            case 5:
                urunCıkıs();
                girisMenusu();
                break;
            case 6:
                cıkıs();
                break;
            default:
                System.out.println("Yanlış Seçim yaptınız");
        }
    }

    private static void guncelle() {
        urunBılgısı urun = new urunBılgısı();
        System.out.println("-----> Ürün Güncelleme Sayfası <-----" );
        System.out.println("Lütfen güncellemek istediğiniz ürünün ismini giriniz" );
        scan.nextLine();//dummy
        String urunIsmı = scan.nextLine().toUpperCase();
        System.out.println("ürünün üreticisini giriniz" );

        String uretıcı = scan.nextLine().toUpperCase();
        System.out.println("Ürün birimini giriniz" );
        String birim = scan.nextLine().toUpperCase();

        urun.urunIsmi = urunIsmı;
        urun.birimi = birim;
        urun.uretici = uretıcı;
        urun.ıd = ıd;
        urunListesi.add(urun);
        System.out.println("Ürün güncellemesi tamamlandı\nÜrününüz--->" + urun);
        ıd++;


    }

    private static void urunGirisi() {

        System.out.println("----->Ürün Giriş Sayfası<-----" );
        System.out.println("Lütfen ekleme yapmak istediğiniz ürünün ıd numarasını giriniz" );
        int ıdNo = scan.nextInt();
        boolean varMı=false;
        for (int i = 0; i <urunListesi.size() ; i++) {
            if (urunListesi.get(i).ıd==ıdNo){
                varMı=true;
                System.out.println("Lütfen ürüne eklemek istediğiniz miktarın birimini giriniz" );
                String birim = scan.next().toUpperCase();
                boolean flag=false;
                for (int j = 0; j <urunListesi.size() ; j++) {
                    if (urunListesi.get(i).birimi.equalsIgnoreCase(birim)){
                        flag=true;
                        System.out.println("Lütfen eklemek istediğiniz mıktarı gırınız");
                        double mıktar=scan.nextDouble();
                        urunListesi.get(i).miktar+=mıktar;
                        break;

                    }
                }
                if (!flag){
                    System.out.println("lutfen urune uygun bırım gırınız");                }
            }

        }
        if (!varMı){
            System.out.println("bu ıd numarası ıle esleşen urun mevcut değildir");
        }
    }

    private static void urunListele() {
        System.out.println("-----> Depodaki Ürün Listesi <-----");
        for (urunBılgısı w:urunListesi
        ) {
            System.out.println(w);
        }

    }

    private static void rafaYerlestırme() {
        System.out.println("----> Raf numarası verme sayfası<----");
        System.out.println("Raf numarası vermek istediğiniz ürünün ıd numarasını gırınız");
        int ıdNo=scan.nextInt();
        boolean flag=false;
        for (urunBılgısı w:urunListesi
        ) {
            if (w.ıd==ıdNo){
                flag=true;
                System.out.println("lütfen ürünü yerleştirmek ıstediğiniz raf ismini giriniz");
                String rafIsmı= scan.next();
                w.rafNo=rafIsmı;
                break;
            }
        }
        if (!flag){
            System.out.println("bu ıd numarası ile eşleşen urun mevcut değildir");
        }
    }

    private static void urunCıkıs() {
        System.out.println("---->Ürün çıkış sayfası<----" );
        System.out.println("lütfen ürün çıkışı yapmak istediğiniz ürünün ıd numarasını gırınız" );
        int idNo = scan.nextInt();
        boolean flag = false;
        for (urunBılgısı w : urunListesi
        ) {
            if (w.ıd == idNo) {
                flag=true;
                System.out.println("depodan çıkarmak ıstedıgınız urun mıktarını gırınız" );
                double mıktar = scan.nextDouble();
                if (w.miktar >= mıktar) {
                    w.miktar -= mıktar;
                    System.out.println("ürün çıkış işleminiz tamamlandı" );
                    System.out.println("ürüne ait kalan mıktar-->" + w.miktar);
                    break;
                } else {
                    System.out.println("gırdıgınız mıktarda ürün depoda mevcut değildir." );
                    urunCıkıs();
                }
            }
        }
        if (!flag){
            System.out.println("bu id numarası ıle eşleşen urun mevcut değildir");
        }

    }

    private static void cıkıs() {
        System.out.println("Yine bekleriz");
    }


}


