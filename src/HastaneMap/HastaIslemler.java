package HastaneMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import static HastaneMap.Islemler.hastaneMenusu;

public class HastaIslemler {
    static Scanner scan = new Scanner(System.in);
    static Map<Integer, String> hastaListesiMap = new HashMap<>();
    static int hastaIDNo=666;


    public static void hastaListesi() throws InterruptedException {
        hastaListesiMap.put(111, "Warren, Traven, Allerji");
        hastaListesiMap.put(222, "Petanow, William, Bas agrisi");
        hastaListesiMap.put(333, "Sophia, George, Diabet");
        hastaListesiMap.put(444, "Emma, Tristan, Soguk alginligi");
        hastaListesiMap.put(555, "Darian, Luis, Migren");
        hastaListesiMap.put(666, "Peter, Cole, Kalp hastaliklari");
        Thread.sleep(5000);

    }

    public static void hastaMenusu() throws InterruptedException {

        Scanner scan=new Scanner(System.in);
        System.out.println("============= HASTA MENUSU =============\n" +

                "\n" +
                "\t   1- Hasta Ekle\t\n" +
                "\t   2- Hasta Listesi Yazdir\n" +
                "\t   3- Hasta Durumu Listele\n" +
                "\t   4- Hasta Silme\n" +
                "\t   5- ANAMENU\n" +
                "\t   6-CIKIS");
        int tercih = scan.nextInt();

        switch (tercih) {
            case 1: //Hasta Ekle
                hastaEkle();
                hastaMenusu();
                break;
            case 2: //Hasta Listesi Yazdir
                hastaListesiYazdir();
                hastaMenusu();

                break;
            case 3: //

                break;
            case 4: //

                break;
            case 5: // ANAMENU
                hastaneMenusu();
                break;
            case 6://CIKIS
                hastaMenusuCikis();
                break;

            default:
                System.out.println("Lutfen gecerli tercih yapiniz");
                Thread.sleep(5000);

        }

    }

    private static void hastaListesiYazdir() throws InterruptedException {
        System.out.println("*****  HASTA LISTELEME ***** ");
        System.out.println(	"HastaIdNo	ismi   soyadi  AktuelDurum\n"+
                "----------------------------------------------------");
        Set<Map.Entry<Integer,String>> hastaListSet = hastaListesiMap.entrySet();
        for (Map.Entry<Integer,String> each : hastaListSet ) {
            Integer eachKey=each.getKey();
            String eachValue=each.getValue();
            String valueArr[]=eachValue.split(", ");
            System.out.printf("%1d %-8s %-8s %-8s  \n" , eachKey, valueArr[0],valueArr[1],valueArr[2]);
            Thread.sleep(5000);

        }
    }

    private static void hastaEkle() throws InterruptedException {
        Hasta obj=new Hasta();

        System.out.println("============= HASTA EKLME =============");
        System.out.println("Hasta ismi girin: ");
        String hastaAdi = scan.nextLine();
        System.out.println(" Hasta Soyisim girin: ");
        String hastaSoyadi = scan.nextLine();
        System.out.println("Hasta aktuel durumunu girin: ");
        String aktuelDurum = scan.nextLine();
        String eklenecekValue = obj.getHastaID()  + ", " + hastaAdi + ", "+ hastaSoyadi+ ", " + aktuelDurum;
        hastaListesiMap.put(obj.getHastaID(), eklenecekValue);
        System.out.println("Eklemek istediginiz Hasta " + hastaIDNo + " ID numarasi ileile sisteme basarili sekilde eklendi");
        hastaIDNo+=111;
        Thread.sleep(5000);

    }

    private static void hastaMenusuCikis() throws InterruptedException {
        System.out.println("==>AnaMenuye donmek icin 1'e\n" +
                "==>Cikis icin 0'a basin");
        int secim = scan.nextInt();
        if(secim==1){
            hastaneMenusu();
        }else if(secim==0){
            System.out.println("Sistemden cikisiniz gerceklesti");
      Thread.sleep(5000);
        }
    }
}
