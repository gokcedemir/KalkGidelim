import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static java.lang.Math.abs;

public class DigerIhtiyaclar {

    protected Sehir sehir;
    protected Ilce ilce;
    protected String ilceIsmi;
    protected String sehirIsmi;

    protected String name; // ATM, Hastane adı.
    protected String Address;


    protected String telefonNo;

    protected int ilceSecimi;
    protected int sehirSecimi;
    protected int aranan;
    public Records records;

    BinarySearchTree tree;


    public Sehir getSehir() {
        return sehir;
    }

    public void setSehir(Sehir sehir) {
        this.sehir = sehir;
    }

    public Ilce getIlce() {
        return ilce;
    }

    public void setIlce(Ilce ilce) {
        this.ilce = ilce;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }



    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    protected double distance;


    public String getTelefonNo() {
        return telefonNo;
    }

    public void setTelefonNo(String telefonNo) {
        this.telefonNo = telefonNo;
    }


    ArrayList<DigerIhtiyaclar> liste;

    public DigerIhtiyaclar(){ liste = new ArrayList<>(); tree = new BinarySearchTree();}




    public DigerIhtiyaclar(int sehir, int ilce, int aranan){
        String filename = "";
        sehirSecimi=sehir;
        ilceSecimi=ilce;
        this.aranan = aranan;
        liste = new ArrayList<>();

        if(aranan==1)
            filename = "ATM.csv";
        else if(aranan == 2)
            filename = "Hastane.csv";
        else if(aranan == 3)
            filename = "Camii.csv";
        else if(aranan == 4)
            filename = "AVM.csv";
        else if(aranan == 5)
            filename = "Otopark.csv";
        else if(aranan == 6)
            filename = "Market.csv";
        else if(aranan == 7)
            filename = "Eczane.csv";


        records = new Records(filename);
        tree = new BinarySearchTree();
    }


    public void get(){


        for (int i = 0; i < liste.size(); i++) {
            if(liste.get(i).sehirIsmi.equals(getSehir(sehirSecimi))){
                liste.get(i).setDistance((double)ilceSecimi-liste.get(i).getIlce().getDistance());
                if(liste.get(i).getDistance() < 0)
                    liste.get(i).setDistance(abs(liste.get(i).getDistance() + 0.5));
                tree.insert(liste.get(i));
            }
        }

        tree.inorder();
    }


    public int compareTo(DigerIhtiyaclar obj) {
        if (obj.getDistance() == this.distance)
            return 0;

        else if (this.distance < obj.distance)
            return -1;
        else
            return 1;
    }

    public String getSehir(int n){
        String ret = "";
        switch (n){
            case 1: ret = "Ankara"; break;
            case 2: ret = "Antalya"; break;
            case 3: ret = "Bolu"; break;
            case 4: ret = "Bursa"; break;
            case 5: ret = "Gaziantep"; break;
            case 6: ret = "Istanbul"; break;
            case 7: ret = "Izmir"; break;
            case 8: ret = "Mugla"; break;
            case 9: ret = "Nevsehir"; break;
            case 10: ret = "Trabzon"; break;
            default: ret = null;
        }
        sehirIsmi = ret;
        return ret;
    }

    @Override
    public String toString(){
        return "----------------\n"+getName() +"\n"+ getAddress()+"\n"+ getTelefonNo()+"\nUzaklik(Birim): "+getDistance();
    }

    public void main() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));  // Reading from System.in
        boolean check = true;
        int sehirSecimi=0,ilceSecimi=0,yer=0;
        String input = "";
        System.out.println("=================================================================================\n");
        System.out.println("                    Diger Ihtiyaclar bolumune hosgeldiniz                        \n");
        System.out.println("=================================================================================\n");
        System.out.println("Sehir seciniz: ");

        System.out.println("1- Ankara");
        System.out.println("2- Antalya");
        System.out.println("3- Bolu");
        System.out.println("4- Bursa");
        System.out.println("5- Gaziantep");
        System.out.println("6- Istanbul");
        System.out.println("7- Izmir");
        System.out.println("8- Mugla");
        System.out.println("9- Nevsehir");
        System.out.println("10- Trabzon");
        System.out.println();


        int flag=0;
        do{
            flag = 0;
            try{
                System.out.print("Seciminiz: ");
                input = reader.readLine();
                sehirSecimi = Integer.parseInt(input);
            }catch(NumberFormatException e) {
                System.out.println(input + " girildi. Bir SAYI giriniz");
                flag=-1;
            }
        }while(sehirSecimi<=0 || sehirSecimi>10 || flag==-1);


        System.out.println("Ilce seciniz: ");
        if(sehirSecimi == 1){ // Ankara
            System.out.println("1- Beypazari");
            System.out.println("2- Kizilcahamam");
            System.out.println("3- Cubuk");
            System.out.println("4- Akyurt");
        }else if(sehirSecimi == 2) { // Antalya
            System.out.println("1- Kas");
            System.out.println("2- Elmali");
            System.out.println("3- Manavgat");
            System.out.println("4- Alanya");
        }else if(sehirSecimi == 3) { // Bolu
            System.out.println("1- Goynuk");
            System.out.println("2- Mudurnu");
            System.out.println("3- Bolu Merkez");
            System.out.println("4- Gerede");
        }else if(sehirSecimi == 4) { // Bursa
            System.out.println("1- Karacabey");
            System.out.println("2- Mudanya");
            System.out.println("3- Gemlik");
            System.out.println("4- Yenisehir");
        }else if(sehirSecimi == 5) { //Gaziantep
            System.out.println("1- Islahiye");
            System.out.println("2- Nurdagi");
            System.out.println("3- Sehitkamil");
            System.out.println("4- Nizip");
        }else if(sehirSecimi == 6) { //Istanbul
            System.out.println("1- Catalca");
            System.out.println("2- Beylikdüzü");
            System.out.println("3- Avcılar");
            System.out.println("4- Eyüp");
            System.out.println("5- Fatih");
            System.out.println("6- Kagıthane");
            System.out.println("7- Sisli");
            System.out.println("8- Uskudar");
            System.out.println("9- Kadikoy");
            System.out.println("10- Maltepe");
        }else if(sehirSecimi == 7) { //Izmir
            System.out.println("1- Cesme");
            System.out.println("2- Urla");
            System.out.println("3- Menderes");
            System.out.println("4- Bayindir");
        }else if(sehirSecimi == 8) { // Mugla
            System.out.println("1- Bodrum");
            System.out.println("2- Marmaris");
            System.out.println("3- Ula");
            System.out.println("4- Dalaman");
        }else if(sehirSecimi == 9) { // Nevsehir
            System.out.println("1- Gulsehir");
            System.out.println("2- Hacibektas");
            System.out.println("3- Kozakli");
            System.out.println("4- Urgup");
        }else if(sehirSecimi == 10) { //Trabzon
            System.out.println("1- Tonya");
            System.out.println("2- Akcaabat");
            System.out.println("3- Yomra");
            System.out.println("4- Of");
        }
        System.out.println();

        do{
            flag = 0;
            try{
                System.out.print("Seciminiz: ");
                input = reader.readLine();
                ilceSecimi = Integer.parseInt(input);
                if(sehirSecimi == 6 && ( ilceSecimi>0 && ilceSecimi <=10 ))
                    break;
            }catch(NumberFormatException e) {
                System.out.println(input + " girildi. Bir SAYI giriniz");
                flag=-1;
            }
        }while(ilceSecimi<=0 ||  ilceSecimi>4 || flag==-1);

        System.out.println("Neyi aradiginizi seciniz: ");
        System.out.println("1- ATM");
        System.out.println("2- Hastane");
        System.out.println("3- Camii");
        System.out.println("4- Alisveris Merkezi");
        System.out.println("5- Otopark");
        System.out.println("6- Market");
        System.out.println("7- Eczane");
        System.out.println();

        do{
            flag = 0;
            try{
                System.out.print("Seciminiz: ");
                input = reader.readLine();
                yer = Integer.parseInt(input);

            }catch(NumberFormatException e) {
                System.out.println(input + " girildi. Bir SAYI giriniz");
                flag=-1;
            }
        }while(yer<=0 || yer>7 || flag==-1);


        DigerIhtiyaclar other = new DigerIhtiyaclar(sehirSecimi,ilceSecimi,yer);
        other.records.LoadRecord(other.liste);
        other.get();
        System.out.println("----------------");
    }


}

