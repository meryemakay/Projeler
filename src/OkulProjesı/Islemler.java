package OkulProjesı;

import java.util.Scanner;

public class Islemler implements IslemlerIntf{

    static Scanner scan = new Scanner(System.in);
static int scm=0;


    public static void IslemlerMenu(int i) {

        Islemler obj=new Islemler();


        scm=i;

        System.out.println("lutfen bır secım yapınız");
        System.out.println("1-ekleme 2-arama 3-lısteleme 4-sılme 5-anaMenu 6-cıkıs");



    int secım=TryCatches.integerGiris();
    scan.nextLine();

switch(secım){
    case 1:
        obj.ekleme();
     IslemlerMenu(scm);
        break;
    case 2:
        obj.arama();
        IslemlerMenu(scm);
        break;
    case 3:
        obj.listeleme();
        IslemlerMenu(scm);
        break;
    case 4:
        obj.silme();
        IslemlerMenu(scm);
        break;
    case 5:
        obj.anaMenu();
        IslemlerMenu(scm);
        break;
    case 6:
        obj.cikis();
        IslemlerMenu(scm);
        break;
    default:
        System.out.println("hatalı gırıs tekrar deneyın");
IslemlerMenu(scm);
}


    }

    @Override
    public void ekleme() {
        System.out.println("kımlıkm no gırınız");
        String kımlıkNo=scan.next();
        kimlikKontrol(kımlıkNo);
if(scm==1){
    ogrencıBılgıKydet(kımlıkNo);
}else ogretmenBılgıKydet(kımlıkNo);

    }

    private void ogretmenBılgıKydet(String kımlıkNo) {
        System.out.println("ad soyad yas bolum ve sıcıl gırınız");
        scan.nextLine();
        String adSoyad=scan.nextLine();
        String yas=scan.next();
        String bolum=scan.next();
        String sıcıl=scan.next();

        Ogretmen obj=new Ogretmen(adSoyad,yas,bolum,sıcıl);

        Ogretmen.ogretmenLısyesıMap.put(kımlıkNo,obj);

    }

    private void ogrencıBılgıKydet(String  kımlıkNo) {
        System.out.println("ad soyad gırınız");
        scan.nextLine();

        String adSoyad=scan.nextLine();
        System.out.println("yas gırınız");

        String yas=scan.next();
        System.out.println("numara gırınız");

        String numara=scan.next();

        System.out.println("sınıf gırınız");

        String sınıf=scan.next();

Ogrenci obj=new Ogrenci(adSoyad,yas,numara,sınıf);

Ogrenci.ogrencıLısyesıMap.put(kımlıkNo,obj);



    }

    private void kimlikKontrol(String kımlıkNo) {
        if(Ogrenci.ogrencıLısyesıMap.containsKey(kımlıkNo)||Ogretmen.ogretmenLısyesıMap.containsKey(kımlıkNo)){
            System.out.println("bu kımlık no ıle kayıt alınmıstı");
            AnaMenu.giris();
        }

    }

    @Override
    public void arama() {
        System.out.println("kımlıkm no gırınız");
        String kımlıkNo = scan.next();
        if (scm == 1) {
            if (Ogrenci.ogrencıLısyesıMap.containsKey(kımlıkNo)) {
                System.out.println(Ogrenci.ogrencıLısyesıMap.get(kımlıkNo));


            }else System.out.println("kayıtlı olmayan ogrencı");
        } else if (scm == 2) {


            if (Ogretmen.ogretmenLısyesıMap.containsKey(kımlıkNo)) {
                System.out.println(Ogretmen.ogretmenLısyesıMap.get(kımlıkNo));
            }else System.out.println("kayıtlı olmayan ogrtmn");
        }


    }
    @Override
    public void listeleme() {
if(scm==1){
    System.out.println(Ogrenci.ogrencıLısyesıMap);
}else if (scm==2){
    System.out.println(Ogretmen.ogretmenLısyesıMap);
}


    }

    @Override
    public void silme() {

        System.out.println("kımlıkm no gırınız");
        String kımlıkNo = scan.next();
if (scm == 1) {
    if(Ogretmen.ogretmenLısyesıMap.containsKey(kımlıkNo)) {
        Ogrenci.ogrencıLısyesıMap.remove(kımlıkNo);
        System.out.println(kımlıkNo + " no l uogrencı sılındı");
    } else
        System.out.println("kımlıkno mevcut degıl");
    }else if (scm == 2) {

      if(Ogretmen.ogretmenLısyesıMap.containsKey(kımlıkNo)){
            Ogretmen.ogretmenLısyesıMap.remove(kımlıkNo);
            System.out.println(kımlıkNo+ " no lu ogrtmn sılındı");
        }else         System.out.println("kımlıkno mevcut degıl");

}
}







    @Override
    public void anaMenu() {
            AnaMenu.giris();

    }

    @Override
    public void cikis() {
        System.out.println("*** gule gule ***");

    }
}
