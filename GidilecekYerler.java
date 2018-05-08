import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.System.exit;

public class GidilecekYerler {

    private static String sehir;
    private static Set<Veri> mekanlar = new HashSet<>();
    private static int yer;

    public void main(){
        BufferedReader inp2 = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader inp3 = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader;
        boolean choice = true, cont=false;
        String answer;

        System.out.println("=================================================================================\n");
        System.out.println("                 Gidilecek Yerler menüsüne hoşgeldiniz.\n");
        System.out.println("=================================================================================\n");

        int n;

        while (choice) {
            try {
                System.out.println("0- ANKARA\n" +
                        "1- ANTALYA\n" +
                        "2- BOLU\n" +
                        "3- BURSA\n" +
                        "4- GAZİANTEP\n" +
                        "5- İSTANBUL\n" +
                        "6- İZMİR\n" +
                        "7- MUĞLA\n" +
                        "8- NEVŞEHİR\n" +
                        "9- TRABZON\n" +
                        "10- Ana menüye dön.\n");
                System.out.println("Gitmek istediğiniz şehri şeçiniz: ");
                reader = new BufferedReader(new InputStreamReader(System.in));  // Reading from System.in

                n = Integer.parseInt(reader.readLine()); // Scans the next token of the input as an int.

                switch (n) {
                    case 0:
                        sehir = "Ankara";
                        break;
                    case 1:
                        sehir = "Antalya";
                        break;
                    case 2:
                        sehir = "Bolu";
                        break;
                    case 3:
                        sehir = "Bursa";
                        break;
                    case 4:
                        sehir = "Gaziantep";
                        break;
                    case 5:
                        sehir = "istanbul";
                        break;
                    case 6:
                        sehir = "izmir";
                        break;
                    case 7:
                        sehir = "Mugla";
                        break;
                    case 8:
                        sehir = "Nevsehir";
                        break;
                    case 9:
                        sehir = "Trabzon";
                        break;
                    case 10:
                        choice = false;
                        break;
                    default:
                        System.out.println("Lutfen verilen sehirlerden birini seciniz.");
                        cont = true;
                }
                if(!choice)
                    break;
                if (cont)
                    continue;

                boolean loop = true;
                while(loop) {
                    System.out.print("Nereye gitmek istiyorsunuz?\n1 - Doğal Güzellikler\n2 - Müzeler ve Ören Yerleri\n3 - Restoranlar\n>");
                    yer = Integer.parseInt(inp2.readLine());
                    if (yer <= 1 && yer >= 3)
                        System.out.println("Hatali secim.");
                    else
                        loop = false;
                }
                try {
                    reader(yer);
                } catch (Exception e) {
                    System.err.println("Hatali input  ");
                }

                System.out.println("Baska bir işlem yapmak istiyor musunuz? (EVET/HAYIR) \n> ");
                answer = inp3.readLine();
                if (answer.equals("EVET") || answer.equals("Evet") || answer.equals("evet")) {
                    choice = true;
                    mekanlar.clear();
                } else if (answer.equals("HAYIR") || answer.equals("Hayır") || answer.equals("hayır"))
                    choice = false;
            }catch (NumberFormatException e){
                System.out.println("Lütfen geçerli bir integer değeri girin.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Bizi seçtiğiniz için teşekkür ederiz.");
    }

    public static void reader(int file) throws IOException {
        switch (file){
            case 1: splitter("dogalguzellikler.csv");
                break;
            case 2:
                splitter("muzeler.csv");
                break;
            case 3: splitter("restoranlar.csv");
                break;

        }
    }
    public static void splitter(String file) throws IOException {
        BufferedReader b = new BufferedReader(new FileReader(file));
        String row;
        String[] cols=new String[10];
        while ( (row = b.readLine())!=null) {
            cols = row.split(",");
            if(cols[0].equals(sehir)) {
                Veri veri = new Veri();
                veri.setSehirAdi(cols[0]);
                veri.setMekanAdi(cols[1]);
                veri.setOnBilgi(cols[2]);
                veri.setDetayliBilgi(cols[3]);
                mekanlar.add(veri);
            }
        }

        display();
    }
    public static void display(){
        Scanner scan = new Scanner(System.in);
        int choice;
        if (yer==1){
            int i=1;
            System.out.println(sehir + " ilimizde bulunan dogal guzellikler su sekildedir.");
            for (Veri v : mekanlar){
                System.out.println(i+" - "+v.mekanAdi+"\n   "+v.onBilgi);
                i++;
            }
            System.out.print("Seciminiz : ");
            choice = scan.nextInt();
            if (choice < 1 && choice > i){
                System.out.println("Hatali secim.");
                exit(1);
            }
            i=1;
            for (Veri v : mekanlar){
                if (i==choice)
                    System.out.println(v.mekanAdi+"\n   "+v.detayliBilgi);
                i++;
            }
        }
        if (yer==2){
            int i=1;
            System.out.println(sehir + " ilimizde bulunan muze ve oren yerleri su sekildedir.");
            for (Veri v : mekanlar){
                System.out.println(i+" - "+v.mekanAdi+"\n   "+v.onBilgi+"\n");
                i++;
            }
            System.out.print("Seciminiz : ");
            choice = scan.nextInt();
            if (choice < 1 && choice > i){
                System.out.println("Hatali secim.");
                exit(1);
            }
            i=1;
            for (Veri v : mekanlar){
                if (i==choice)
                    System.out.println(v.mekanAdi+"\n   "+v.detayliBilgi+"\n");
                i++;
            }
        }
        if (yer==3){
            int i=1;
            System.out.println(sehir + " ilimizde bulunan yoresel restoranlar su sekildedir.\n");
            for (Veri v : mekanlar){
                System.out.println(i+" - "+v.mekanAdi+"\n   "+v.onBilgi);
                i++;
            }
            System.out.print("Seciminiz :  ");
            choice = scan.nextInt();
            if (choice < 1 && choice > i){
                System.out.println("Hatali secim.");
                exit(1);
            }
            i=1;
            for (Veri v : mekanlar){
                if (i==choice)
                    System.out.println(v.mekanAdi+"\n   "+v.detayliBilgi+"\n");
                i++;
            }
        }
    }
}
