package OkulProjesı;

import java.util.HashMap;
import java.util.Map;

public class Ogrenci extends Kisi {

  static  Map<String,Ogrenci > ogrencıLısyesıMap = new HashMap<>();


    private String numara = "";
    private String sınıf = "";

    public Ogrenci() {


    }

    public Ogrenci(String adSoyad, String yas, String numara, String sınıf) {
        super(adSoyad, yas);
        this.numara = numara;
        this.sınıf = sınıf;
    }

    public String getNumara() {
        return numara;
    }

    public void setNumara(String numara) {
        this.numara = numara;
    }

    public String getSınıf() {
        return sınıf;
    }

    public void setSınıf(String sınıf) {
        this.sınıf = sınıf;
    }

    @Override
    public String toString() {
        return "Ogrenci{" +
                "numara='" + numara + '\'' +
                ", sınıf='" + sınıf + '\'' +
                "} " + super.toString();
    }
}

