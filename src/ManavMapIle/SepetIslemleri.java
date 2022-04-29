package ManavMapIle;

public class SepetIslemleri extends Statics {

    public void urunListele() {
        Statics.tumUrunler.values().stream().forEach(Utilities::urunListele);
    }

    public static void urunSec(SepetIslemleri islem, Musteri musteri) {
        islem.urunListele();
        int secim=1;

        while (secim != 0){
            System.out.println(Statics.Y+"Sepete eklemek istediginiz ürün numarasını giriniz\nÖdeme yapmak icin 0'a basınız"); // çıkış işlemi ekle
            secim= TryCatch.intGirisi();
            if (secim == 0){islem.satinAl(islem,musteri); break;}
            else if(Statics.tumUrunler.containsKey(secim)){
                System.out.println(Statics.Y+"Kaç kilogram istediginizi giriniz");

                if (musteri.getSepet().getUrunKiloMap().containsKey(Statics.tumUrunler.get(secim))){
                    musteri.getSepet().getUrunKiloMap().computeIfPresent(Statics.tumUrunler.get(secim),(k, v)-> (v+ TryCatch.doubleGirisi()));
                }else{
                    double kilo = TryCatch.doubleGirisi();
                    musteri.getSepet().getUrunKiloMap().put(Statics.tumUrunler.get(secim),kilo);
                }

                System.out.println(Statics.B+"  *Sepetteki Ürünler*");
                musteri.getSepet().getUrunKiloMap().entrySet().
                        forEach(Utilities::sepetiYazdir);
                System.out.println(Statics.B+"Sepet Toplamı : "+ (float)islem.sepetToplamiHesapla(musteri));

            }else {
                System.out.println(Statics.R+"Böyle bir ürün bulunmamaktadır");
                urunSec(islem,musteri);
            }
        }
    }

    private double sepetToplamiHesapla(Musteri musteri) {
        double toplamFiyat;

        /*
            Lambda kullanmadan hesaplama yöntemi
            for(Map.Entry<Urun,Double> each: musteri.getSepet().getUrunKiloMap().entrySet() ){
            toplamFiyat +=  each.getKey().getBirimFiyat()*each.getValue();
       }
       */

        toplamFiyat = musteri.getSepet().getUrunKiloMap().entrySet().
                stream().
                mapToDouble(Utilities::fiyatHesapla).
                reduce(0,Double::sum);
        musteri.getSepet().setToplamFiyat(toplamFiyat);
        return toplamFiyat;

    }
    private void urunCikar(Musteri musteri) {
        System.out.println(Statics.Y+"Sepetten çıkarmak istediginiz ürün numarasını giriniz");
        musteri.getSepet().getUrunKiloMap().entrySet().
                forEach(Utilities::sepetiIdNoIleYazdir);
        int secim = TryCatch.intGirisi();
        if (Statics.tumUrunler.containsKey(secim)){
            try {
                musteri.getSepet().getUrunKiloMap().remove(Statics.tumUrunler.get(secim));
                musteri.getSepet().setToplamFiyat(sepetToplamiHesapla(musteri));
            } catch (Exception e) {
                System.out.println(Statics.R+"Hatalı id girdiniz");
            }
        }else System.out.println(Statics.R+"Böyle bir ürün yok");

    }

    public void satinAl(SepetIslemleri ıslem, Musteri musteri) {
        System.out.println(Statics.B+"Sepetteki ürünlerin toplam tutarı : "+ (float)musteri.getSepet().getToplamFiyat());
        if(musteri.getSepet().getToplamFiyat()<=0){
            System.out.println(Statics.R+"Sepetiniz boş");
            urunSec(ıslem,musteri);
        }else if (musteri.getBakiye()>=musteri.getSepet().getToplamFiyat()){
            musteri.setBakiye(musteri.getBakiye()-musteri.getSepet().getToplamFiyat());
            System.out.println(Statics.B+"Ödemeniz başarıyla gerçekleşti\nKalan bakiyeniz : "+ (float)musteri.getBakiye());
            musteri.getSepet().getUrunKiloMap().clear();
        }else{
            System.out.println(Statics.R+"Bakiyenizi aştınız. Bakiye : "+ (float)musteri.getBakiye()+ Statics.Y+"\nSepetinizden ürün cıkarmak icin 1\nPara yatırmak icin 2'yi tuşlayın");
            int secim = TryCatch.intGirisi();
            if (secim==1) urunCikar(musteri);
            else if(secim==2) new HesapIslemleri().paraYatir(musteri);

            satinAl(ıslem,musteri);
        }
    }


}

