import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class GidilecekYerler {

    private static String sehir;
    private static Set<Veri> mekanlar = new HashSet<>();
    private static int yer, name;

    public static void main(){
        Scanner inp1 = new Scanner(System.in);
        Scanner inp3 = new Scanner(System.in);

        boolean choice = true, cont=false;
        String answer;
        while (choice) {
            boolean city = false;

            while (!city){
                city = getCity();
            }

            switch (name) {
                case 1:
                    sehir = "Ankara";
                    break;
                case 2:
                    sehir = "Antalya";
                    break;
                case 3:
                    sehir = "Bolu";
                    break;
                case 4:
                    sehir = "Bursa";
                    break;
                case 5:
                    sehir = "Gaziantep";
                    break;
                case 6:
                    sehir = "istanbul";
                    break;
                case 7:
                    sehir = "izmir";
                    break;
                case 8:
                    sehir = "Mugla";
                    break;
                case 9:
                    sehir = "Nevsehir";
                    break;
                case 10:
                    sehir = "Trabzon";
                    break;
                default:
                    System.out.println("Lutfen verilen sehirlerden birini seciniz.");
                    cont = true;
            }

            if (cont)
                continue;
            boolean where = false, readerVar = false;

            while (!where){
                where = neresi();
            }

            while (!readerVar){
                readerVar = readerFunc();
            }

            System.out.println("Baska bir işlem yapmak istiyor musunuz? (E/H) \n> ");
            answer = inp3.nextLine();
            if (answer.equals("E") || answer.equals("e")) {
                choice = true;
                mekanlar.clear();
            } else if (answer.equals("H") || answer.equals("h")) {
                choice = false;
                mekanlar.clear();
            }
            else{
                System.out.println("Hatali secim. Cikis yapiliyor");
                System.out.println("Bizi seçtiğiniz için teşekkür ederiz.");
                choice = false;
                mekanlar.clear();
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
        boolean displayVar=false;
        while(!displayVar){
            displayVar = display();
        }
    }
    public static boolean display(){
        Scanner scan = new Scanner(System.in);
        Scanner scan1 = new Scanner(System.in);

        int choice=0;
        if (yer==1){
            int i=1;
            System.out.println(sehir + " ilimizde bulunan dogal guzellikler su sekildedir.");
            for (Veri v : mekanlar){
                System.out.println(i+" - "+v.mekanAdi+"\n   "+v.onBilgi);
                i++;
            }
            System.out.print("Seciminiz : ");
            try{
                choice = scan.nextInt();
            }catch (Exception e2){
                return false;
            }
            if (!(choice==1 || choice == 2 || choice == 3)){
                System.out.println("Hatali secim.");
                return false;
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
            try{
                choice = scan1.nextInt();
            }catch (Exception e1){
                System.out.println("Hatali secim.");
                return false;
            }
            if (!(choice==1 || choice == 2 || choice == 3)){
                System.out.println("Hatali secim.");
                return false;
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
            try{
                choice = scan1.nextInt();
            }catch (Exception e1){
                System.out.println("Hatali secim. Cikis yapiliyor.");
                return false;
            }
            if (!(choice==1 || choice == 2 || choice == 3)){
                System.out.println("Hatali secim.");
                return false;
            }
            i=1;
            for (Veri v : mekanlar){
                if (i==choice)
                    System.out.println(v.mekanAdi+"\n   "+v.detayliBilgi+"\n");
                i++;
            }
        }
        return true;
    }
    private static boolean neresi(){
        Scanner inp2 = new Scanner(System.in);
        Scanner inp4 = new Scanner(System.in);
        System.out.print("Nereye gitmek istiyosunuz?\n1 - Doğal Güzellikler\n2 - Müzeler ve Ören Yerleri\n3 - Restoranlar\n>");
        try {
            yer = inp2.nextInt();
        } catch (Exception e) {
            return false;
        }
        if (!(yer == 1 || yer == 2 || yer == 3)) {
            System.out.println("Hatali secim.");
            return false;
        }
        return true;
    }

    private static boolean readerFunc(){
        try {
            reader(yer);
        } catch (Exception e) {
            System.err.println("Hatali input  " + e);
            return false;
        }
        return true;
    }
    private static boolean getCity(){
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
        Scanner reader = new Scanner(System.in);  // Reading from System.in

        try {
            name = reader.nextInt(); // Scans the next token of the input as an int.
        } catch (Exception e) {
            System.out.println("Sayi giriniz.");
            return false;
        }
        return true;
    }
}
