package Depo_Team;

public class urunBılgısı {
    public String urunIsmi;
    public String uretici;
    public String birimi;
    public int ıd;
    public double miktar;
    public String rafNo;

    public urunBılgısı() {
    }

    public urunBılgısı(String urunIsmi, String uretici, String birimi, int ıd) {
        this.urunIsmi = urunIsmi;
        this.uretici = uretici;
        this.birimi = birimi;
        this.ıd = ıd;
    }

    @Override
    public String toString() {
        return  "urunIsmi='" + urunIsmi + '\'' +
                ", uretici='" + uretici + '\'' +
                ", birimi='" + birimi + '\'' +
                ", ıd=" + ıd +
                ", miktar=" + miktar +
                ", rafNo=" + rafNo;
    }
}


