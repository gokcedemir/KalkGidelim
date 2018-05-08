import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args){
        String sentinel;

        try {
            System.out.println("=================================================================================");
            System.out.println("\n\t\t\t\t\"kalkgidelim\" e hoş geldiniz.\n");
            System.out.println("\t\"O da mı tatile gitmiş :/ \" demeyin! Kalkın gidelim. =)\n");
            System.out.println("=================================================================================");

            BufferedReader reader;
            KonaklamaUI konaklamaUI;
            GidilecekYerler gidilecekYerler;
            Etkinlikler etkinlikler;
            HayvanOteli hayvanOteli;
            UlasimTuru ulasimTuru;
            DigerIhtiyaclar digerIhtiyaclar;

            do {
                System.out.println("\nSize nasıl yardımcı olabiliriz ? :)\n");

                System.out.println("1- Nerede kalabilirim ?");
                System.out.println("2- Nereleri gezebilirim ?");
                System.out.println("3- Yakında hangi etkinlikler var ?");
                System.out.println("4- Evcil hayvanım ben yokken nerede kalabilir ?");
                System.out.println("5- Nasıl gidebilirim ?");
                System.out.println("6- Gittiğim yerde diğer ihtiyaçlarımı nerede karşılayabilirim ?\n");
                System.out.println("Çıkmak için 'E' ye basınız.\n");

                reader = new BufferedReader(new InputStreamReader(System.in));
                sentinel = reader.readLine().toUpperCase(); // Scans the next token of the input as an int.
                try {
                    switch (sentinel) {
                        case "1":
                            konaklamaUI = new KonaklamaUI();
                            konaklamaUI.main();
                            break;
                        case "2":
                            gidilecekYerler = new GidilecekYerler();
                            gidilecekYerler.main();
                            break;
                        case "3":
                            etkinlikler = new Etkinlikler();
                            break;
                        case "4":
                            hayvanOteli = new HayvanOteli();
                            hayvanOteli.main();
                            break;
                        case "5":
                            ulasimTuru = new UlasimTuru();
                            ulasimTuru.main();
                            break;
                        case "6":
                            digerIhtiyaclar = new DigerIhtiyaclar();
                            digerIhtiyaclar.main();
                            break;
                        default:
                            break;
                    }
                }catch (NumberFormatException e){
                    System.out.println("Lütfen geçerli bir integer değeri girin.");
                }

            } while (!sentinel.equals("E"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}