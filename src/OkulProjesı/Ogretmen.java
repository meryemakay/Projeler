package OkulProjesı;

import java.util.HashMap;
import java.util.Map;

public class Ogretmen extends Kisi {


   static Map<String,Ogretmen > ogretmenLısyesıMap = new HashMap<>();

    private String bolum="";
private String sıcıl="";


    public Ogretmen(){

    }


    public Ogretmen(String adSoyad, String yas, String bolum, String sıcıl) {
        super(adSoyad, yas);
        this.bolum = bolum;
        this.sıcıl = sıcıl;


    }


    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }

    public String getSıcıl() {
        return sıcıl;
    }

    public void setSıcıl(String sıcıl) {
        this.sıcıl = sıcıl;
    }

    @Override
    public String toString() {
        return "Ogretmen{" +
                "bolum='" + bolum + '\'' +
                ", sıcıl='" + sıcıl + '\'' +
                "} " + super.toString();
    }
}
