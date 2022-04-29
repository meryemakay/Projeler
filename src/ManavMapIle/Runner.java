package ManavMapIle;

public class Runner extends Statics {
    static{
        Statics.tumUrunler.put(++Urun.urunIdCount,new Urun(Urun.urunIdCount,"Domates", 12.2));
        Statics.tumUrunler.put(++Urun.urunIdCount,new Urun(Urun.urunIdCount,"Biber", 20.7));
        Statics.tumUrunler.put(++Urun.urunIdCount,new Urun(Urun.urunIdCount,"Patlıcan", 15.6));
        Statics.tumUrunler.put(++Urun.urunIdCount,new Urun(Urun.urunIdCount,"Ananas", 25.9));
        Statics.tumUrunler.put(++Urun.urunIdCount,new Urun(Urun.urunIdCount,"Karpuz", 9.5));
    }
    public static void main(String[] args) {

        AnaMenu.anaGirisEkrani();
        AnaMenu.cikisEkrani();

    }
}
