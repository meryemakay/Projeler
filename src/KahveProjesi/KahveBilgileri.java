package KahveProjesi;

public class KahveBilgileri {
    private String boyut = "";
    private int fiyat = 0;

    public KahveBilgileri() {
    }

    public KahveBilgileri(String boyut, int fiyat) {
        this.boyut = boyut;
        this.fiyat = fiyat;
    }

    public String getBoyut() {
        return boyut;
    }

    public void setBoyut(String boyut) {
        this.boyut = boyut;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int x) {
        if (x == 1) {
            if (Islemler.hangiKahve.equalsIgnoreCase("Türk kahvesi")) {
                fiyat = 25;
            } else if (Islemler.hangiKahve.equalsIgnoreCase("Filtre kahve")) {
                fiyat = 20;
            } else if (Islemler.hangiKahve.equalsIgnoreCase("expresso")) {
                fiyat = 30;
            }
        } else if (x == 2) {
            if (Islemler.hangiKahve.equalsIgnoreCase("Türk kahvesi")) {
                fiyat = 35;
            } else if (Islemler.hangiKahve.equalsIgnoreCase("Filtre kahve")) {
                fiyat = 30;
            } else if (Islemler.hangiKahve.equalsIgnoreCase("expresso")) {
                fiyat = 40;
            }
        } else if (x == 3) {
            if (Islemler.hangiKahve.equalsIgnoreCase("Türk kahvesi")) {
                fiyat = 45;
            } else if (Islemler.hangiKahve.equalsIgnoreCase("Filtre kahve")) {
                fiyat = 35;
            } else if (Islemler.hangiKahve.equalsIgnoreCase("expresso")) {
                fiyat = 45;
            }
        }
    }

    @Override
    public String toString() {
        return "boyut='" + boyut + '\'' +
                ", fiyat='" + fiyat +
                '}';
    }
}
