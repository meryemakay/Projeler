package ManavMapIle;

public class HesapIslemleri extends Statics {

    public static void hesapOlustur() {
        System.out.println(Statics.Y+"\nLütfen kullanıcı adınızı ve parolanızı girin : ");
        Statics.tumMusteriler.put(++Musteri.musteriIdCount,new Musteri(Musteri.musteriIdCount, Statics.scan.next(), Statics.scan.next()));
        System.out.println(Statics.B+"Müşteri kaydı başarıyla tamamlandı");

    }
    public static void girisYap() {
        System.out.print(Statics.Y+"Giriş yapmak için isminizi girin : ");
        String girilenIsim = Statics.scan.next();
        System.out.print(Statics.Y+"Parolanızı girin : ");
        String girilenParola = Statics.scan.next();

        boolean giris=false;
        if(Statics.tumMusteriler.values().stream().anyMatch(t-> t.getKullaniciAdi().equals(girilenIsim)&& t.getParola().equals(girilenParola))){
            System.out.println(Statics.B+"Giriş başarılı");
            giris=true;
            HesapIslemleri ıslem = new HesapIslemleri();
            ıslem.islemSec(ıslem, Statics.tumMusteriler.get(Utilities.musteriIdBul(girilenIsim,girilenParola)));

        }

        if (!giris){
            System.out.println(Statics.R+"Hatalı kullanıcı adı veya sifre\nLütfen tekrar deneyin");
            girisYap();
        }

    }
    public void islemSec(HesapIslemleri ıslem, Musteri musteri){

        int secim=0;
        while (secim != 3){
            System.out.println(Statics.Y+"Hesabınıza para yatırmak icin 1\nÜrünleri incelemek icin 2\nÇıkış yapmak icin 3'ü tuşlayın");
            secim = TryCatch.intGirisi();
            if (secim == 1)ıslem.paraYatir(musteri);
            else if (secim == 2) SepetIslemleri.urunSec(new SepetIslemleri(),musteri);
            else if(secim==3)break;
            else {
                System.out.println(Statics.R+"Hatalı seçim. Tekrar deneyin");
                islemSec(ıslem,musteri);
            }
        }
        AnaMenu.anaGirisEkrani();
    }
    public void paraYatir(Musteri musteri){
        System.out.print(Statics.Y+"Hesabınıza yatırmak istediginiz miktarı girin : ");
        double yatirilanPara = TryCatch.doubleGirisi();
        if (yatirilanPara>0){
            musteri.setBakiye(musteri.getBakiye()+yatirilanPara);
            System.out.println(Statics.B+"Para yatırma işlemi başarıyla gerçekleşti\nBakiyeniz : "+musteri.getBakiye());
        }else{
            System.out.println(Statics.R+"0'dan büyük bir deger girmelisiniz");
        }

    }
}

