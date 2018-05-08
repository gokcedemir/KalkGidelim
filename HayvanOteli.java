import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;


public class HayvanOteli {

    private PriorityQueue<Barinak> queue;

    private ArrayList<Barinak> barinaklar;
    private Barinak barinak = new Barinak();
    protected Hayvan hayvan = new Hayvan();

    public ArrayList<Barinak> getBarinaklar() {
        return barinaklar;
    }
    private ArrayList<String> whichAnimal = new ArrayList<>();


    protected HayvanOteli()
    {
        barinaklar = new ArrayList<>();
        queue = new PriorityQueue<>();

        whichAnimal.add("KOPEK");
        whichAnimal.add("KUS");
        whichAnimal.add("TAVSAN");
        whichAnimal.add("HAMSTER");
        whichAnimal.add("YILAN");
        whichAnimal.add("KAPLUMBAGA");
        whichAnimal.add("IGUANA");
        whichAnimal.add("KEDI");
    }

    protected void main() throws IOException {
        Olustur();
        Hayvan hayvan = new Hayvan();

        System.out.println("=================================================================================\n");
        System.out.println("              Evcil hayvan otel menüsüne hoş geldiniz!\n");
        System.out.println("=================================================================================\n");

        System.out.println("Küçük dostunuza daha kolay hitap edebilmemiz için lütfen adını giriniz.");
        BufferedReader choice = new BufferedReader(new InputStreamReader(System.in));
        hayvan.animalName = choice.readLine().toUpperCase();
        System.out.println(hayvan.animalName + "'nın tatil yapması için lütfen bir şehir seçiniz.");

        System.out.println("1- ANKARA\n" +
                           "2- ANTALYA\n" +
                           "3- BOLU\n" +
                           "4- BURSA\n" +
                           "5- GAZİANTEP\n" +
                           "6- İSTANBUL\n" +
                           "7- İZMİR\n" +
                           "8- MUĞLA\n" +
                           "9- NEVŞEHİR\n" +
                           "10- TRABZON\n");
        
        System.out.println("Gitmek istediğiniz şehri şeçiniz: ");

        int n;

        String county = null;

        boolean loop = true;

        while (loop) {
            try {
            n = Integer.parseInt(choice.readLine());
            switch (n) {
                case 1:
                    county = "ANKARA";
                    loop = false;
                    break;
                case 2:
                    county = "ANTALYA";
                    loop = false;
                    break;
                case 3:
                    county = "BOLU";
                    loop = false;
                    break;
                case 4:
                    county = "BURSA";
                    loop = false;
                    break;
                case 5:
                    county = "GAZİANTEP";
                    loop = false;
                    break;
                case 6:
                    county = "ISTANBUL";
                    loop = false;
                    break;
                case 7:
                    county = "IZMİR";
                    loop = false;
                    break;
                case 8:
                    county = "MUGLA";
                    loop = false;
                    break;
                case 9:
                    county = "NEVSEHİR";
                    loop = false;
                    break;
                case 10:
                    county = "TRABZON";
                    loop = false;
                    break;
                default:
                    System.out.println("Yanlış numara girdiniz. Tekrar deneyiniz.\n");
                    break;
            }
        }catch (NumberFormatException e){
                System.out.println("Lütfen geçerli bir integer değeri girin.");
            }
        }
        System.out.println("Lütfen size en yakin ilçeyi giriniz.");

        Counties(county);

        loop = true;
        int kind;

        System.out.println(hayvan.animalName + "'nın turunu seciniz.");
        System.out.println("1- Kopek \n"   +
                "2- Kus \n"       +
                "3- Tavsan \n"    +
                "4- Hamster\n"    +
                "5- Yılan\n"      +
                "6- Kaplumbaga\n" +
                "7- Iguana\n"     +
                "8- Kedi\n");



        while (loop) {
            try {
                kind = Integer.parseInt(choice.readLine());
                switch (kind) {
                    case 1:
                        hayvan.whichAnimal = "KOPEK";
                        loop = false;
                        break;
                    case 2:
                        hayvan.whichAnimal = "KUS";
                        loop = false;
                        break;
                    case 3:
                        hayvan.whichAnimal = "TAVSAN";
                        loop = false;
                        break;
                    case 4:
                        hayvan.whichAnimal = "HAMSTER";
                        loop = false;
                        break;
                    case 5:
                        hayvan.whichAnimal = "YILAN";
                        loop = false;
                        break;
                    case 6:
                        hayvan.whichAnimal = "KAPLUMBAGA";
                        loop = false;
                        break;
                    case 7:
                        hayvan.whichAnimal = "IGUANA";
                        loop = false;
                        break;
                    case 8:
                        hayvan.whichAnimal = "KEDI";
                        loop = false;
                        break;
                    default:
                        System.out.println(hayvan.animalName + "'nın turunu seciniz.");
                        System.out.println("1- Kopek \n" +
                                "2- Kus \n" +
                                "3- Tavsan \n" +
                                "4- Hamster\n" +
                                "5- Yılan\n" +
                                "6- Kaplumbaga\n" +
                                "7- Iguana\n" +
                                "8- Kedi\n");
                        break;
                }
            }catch (NumberFormatException e){
                System.out.println("Lütfen geçerli bir integer değeri girin.");
            }
        }

        System.out.println(hayvan.animalName + "'nın cinsini giriniz. (Kopek - rottweiler)");
        hayvan.kindOfAnimal = choice.readLine().toUpperCase();

        System.out.println("İletişim için lütfen kendi adınızı, soyadınızı giriniz.");
        hayvan.animalOwner = choice.readLine().toUpperCase();

        System.out.println("\nSayın " + hayvan.animalOwner + ", " + hayvan.animalName +" için yer ayırtılmıştır. Lütfen giriş tarihinde gelirken "+ hayvan.animalName + "'nın" +
                " belgelerini unutmayın.\n" + hayvan.animalName + "'nın gelmesini dört gözle bekliyoruz :)\n");

        choice(county);
    }

    private void choice(String county) throws IOException {
        boolean loop = true;
        BufferedReader reader;
        while (loop) {
            try {
                System.out.println("\nBaşka bir işlem yapmak ister misiniz ?\n");
                System.out.println("1- Bulunduğum ilde bir hayvan oteli var mı ?");
                System.out.println("2- Bulunduğum ilçedeki hayvan otellerini günlük ücretlerine göre sıralayabilir miyiz ?");
                System.out.println("3- Ana menüye dön");
                reader = new BufferedReader(new InputStreamReader(System.in));
                int sec = Integer.parseInt(reader.readLine());
                switch (sec) {
                    case 1:
                        System.out.println();
                        printBarinaklar(county);
                        break;
                    case 2:
                        Collections.sort(barinaklar, new SortByPrice());

                        for (Barinak aBarinaklar : barinaklar) {
                            if (aBarinaklar.getCity().equals(county))
                                System.out.println(aBarinaklar);
                        }
                        queue.addAll(barinaklar);

                        break;
                    case 3:
                        loop = false;
                        break;
                    default:
                        break;
                }
            }catch (NumberFormatException e){
                System.out.println("Lütfen geçerli bir integer değeri girin.");
            }
        }
    }

    private void Olustur() throws IOException {

        DosyadanBarinakOku();
        DosyadanHayvanOku();
    }

    private void DosyadanBarinakOku() throws IOException
    {
        BufferedReader in = new BufferedReader(new FileReader("barinak.csv"));
        String str;

        while((str = in.readLine()) != null)
            BarinakEkle(str.toUpperCase());
    }

    private void DosyadanHayvanOku() throws IOException {

        BufferedReader in = new BufferedReader(new FileReader("evcilHayvanData.csv"));
        String str;

        while((str = in.readLine()) != null)
            HayvanEkle(str.toUpperCase());

    }

    private void BarinakEkle(String line)
    {
        barinak = new Barinak();

        String[] tokens = line.split(",");
        barinak.id = Integer.valueOf(tokens[0]);
        barinak.city = tokens[1];
        barinak.county = tokens[2];
        barinak.capacity = Integer.valueOf(tokens[3]);
        barinak.price = Integer.valueOf(tokens[4]);
        barinaklar.add(barinak);
    }

    private void printBarinaklar(String ilce) {
        for (int i = 0; i < barinaklar.size(); i++) {
            if (barinaklar.get(i).getCity().equals(ilce))
                System.out.println(barinaklar.get(i));
        }
    }
    private void Counties(String ilce) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int i, j;
        for (i = 0, j = 1; i < barinaklar.size(); i++) {
            if (barinaklar.get(i).getCity().equals(ilce)) {
                System.out.println(j + "- " + barinaklar.get(i).county);
                ++j;
            }
        }

        int flag;
        int choice;
        do{
            choice = 0;
            flag = 0;
            try{
                choice = Integer.parseInt(bufferedReader.readLine());
            }catch (NumberFormatException e){
                flag = -1;
            }
            if(choice < 0 || choice >= j|| flag == -1)
                System.out.println("Hatalı giriş yaptınız. Tekrar deneyiniz.");
        }while(choice <= 0 || choice >= j || flag == -1);
    }

    public void getBarinakByIlce(String ilce)
    {
        for (int i = 0; i < barinaklar.size(); i++) {

            barinak = barinaklar.get(i);

            if (barinak.county.equals(ilce))
            {
                System.out.println(barinak);
                return;
            }
        }

        for (int i = 0; i < barinaklar.size(); i++)
            System.out.println( i + "- " + barinaklar.get(i));

    }

    private void HayvanEkle(String line){
        hayvan = new Hayvan();

        String[] tokens = line.split(",");
        hayvan.animalName = tokens[0];
        hayvan.barinakId = Integer.valueOf(tokens[1]);
        hayvan.whichAnimal = tokens[2];
        hayvan.kindOfAnimal = tokens[3];
        hayvan.inputDate = tokens[4];
        hayvan.outputDate = tokens[5];
        hayvan.animalOwner = tokens[6];
        hayvan.phoneNumber = tokens[7];

        for (Barinak aBarinaklar : barinaklar) {
            barinak = aBarinaklar;
            if (barinak.id == hayvan.barinakId)
                barinak.addHayvan(hayvan);
        }

    }

    class SortByPrice implements Comparator<Barinak> {

        @Override
        public int compare(Barinak o1, Barinak o2) {
            return o1.price - o2.price;
        }
    }

    public PriorityQueue<Barinak> getQueue() {
        return queue;
    }

}