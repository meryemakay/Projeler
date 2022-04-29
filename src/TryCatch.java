import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatch {
    static Scanner scan = new Scanner(System.in);
    static int giris;
    static String kelime;

    public static void main(String[] args) {
        int sayi = intGirisi();
        System.out.println(sayi);
        // scan.nextLine(); denemek icin ikisini ayni anda calistirinca dummy lazim
        // dummyleri projelerinizde calismaniz lazım
        // String kontrol = stringGirisi();
        // System.out.println(kontrol);
    }

    public static int intGirisi() {
        try {
            giris = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("sayi gir");
            scan.nextLine();
            intGirisi();
        }
        return giris;
    }

    public static String stringGirisi() {
        try {
            kelime = scan.nextLine();
            String kontrol = kelime.replaceAll("\\D", "");
            String kontrol2 = kelime.replaceAll("\\w", "");
            if (kontrol.length() != 0 || kontrol2.length() != 0) {
                throw new InputMismatchException("harf disinda karakter yok");
            }
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            stringGirisi();
        }

        return kelime;
    }
}

