/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Gökçe Demir
 */
public class HavaYolu extends Ulasim
{
    private ArrayList<Ulasim> firmalar;

    public HavaYolu() {
        this.firmalar = new ArrayList();
    }
    
    public void menu() throws IOException
    {
        readFile();
        for (int i = 0; i < firmalar.size(); i++) {
            System.out.printf("%d- ",i);
            System.out.println(firmalar.get(i).getFirmaAdi());
        }

        BufferedReader readerr = new BufferedReader(new InputStreamReader(System.in));
        int  num=0, flag =0;
        String choice;
        do{
            System.out.println("Size uygun olan uçak firmasını seçiniz: ");
            num=0; flag=0;
            try{
                choice = readerr.readLine();
                num = Integer.parseInt(choice);
            }catch(NumberFormatException e) {
                System.out.println("Yanlış girdiniz. Lütfen tekrar deneyiniz!");
                flag=-1;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }while(num<0 || num>=firmalar.size() || flag==-1);
        System.out.println("Linke tıklayarak devam edebilirsiniz :) ");
        System.out.printf("%s\n", firmalar.get(num).getWebSite());
        System.out.println("İyi Yolculuklar.");
        
    }
    private void readFile() throws FileNotFoundException, IOException
    {
        FileReader reader = new FileReader("ucakFirmalari.csv");
            BufferedReader buffReader = new BufferedReader(reader);
            String readFile;  //read line by line file

            while((readFile = buffReader.readLine()) != null)
            {
                Ulasim temp = new Ulasim();
                String[] record = readFile.split(",");
                temp.setFirmaAdi(record[0]);
                temp.setWebSite(record[1]);
                firmalar.add(temp);
            }
    }
}
