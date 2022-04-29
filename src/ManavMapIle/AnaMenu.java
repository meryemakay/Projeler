package ManavMapIle;

public class AnaMenu extends Statics {
    public static void anaGirisEkrani(){

        while (true){

            System.out.printf(Statics.B+"\n%50s\n\n","*** MARKETİMİZE HOŞGELDİNİZ ***");
            System.out.printf(Statics.Y+"%-30s %-30s %-25s\n","Hesap olusturmak icin 1","Giris yapmak icin 2","Cıkıs yapmak icin 3'ü tuşlayın");
            int tercih = TryCatch.intGirisi();
            switch(tercih){
                case 1: HesapIslemleri.hesapOlustur();
                case 2: HesapIslemleri.girisYap(); break;
                case 3: cikisEkrani();

        }
    }
}

    public static void cikisEkrani() {
        System.out.printf(Statics.B+"\n%40s","*** YİNE BEKLERİZ ***");
        System.exit(0);
    }
}

