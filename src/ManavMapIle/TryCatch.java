package ManavMapIle;

import java.util.InputMismatchException;

public class TryCatch extends Statics {

    public static double doubleGirisi() {
        double giris = 0;
        boolean flag = true;

        while (flag) {
            try {
                giris = Statics.scan.nextDouble();
                Statics.scan.nextLine();
                flag = false;
            } catch (InputMismatchException e) {
                Statics.scan.nextLine();
                System.out.println(Statics.R+"Lütfen bir sayı giriniz");
            }
        }
        return giris;
    }

    public static int intGirisi(){
        int giris=0;
        boolean flag=true;

        while(flag){
            try {
                giris= Statics.scan.nextInt();
                Statics.scan.nextLine();
                flag =false;

            }catch (InputMismatchException e){
                Statics.scan.nextLine();
                System.out.println(Statics.R+"Lütfen bir sayı giriniz");
            }
        }
        return giris;
    }
}

