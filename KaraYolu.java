
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Gökçe Demir
 */
public class KaraYolu extends Ulasim
{ 
    private ArrayList<Ulasim> firmalar;

    public KaraYolu() {
        this.firmalar = new ArrayList();
    }
    
    public void menu() throws IOException
    {
        readFile();
        System.out.println("0- Taksi\n"
                + "1- Otobüs Bileti\n"
                +"3- BlaBlaCar");

        BufferedReader readerr = new BufferedReader(new InputStreamReader(System.in));
        int  num=0, flag =0;
        String choice;
        do{
            System.out.println("Yapmak istediğiniz işlemi seçiniz: ");
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
        }while((num!=0 && num!=1 && num!=3 )|| flag==-1);
        
        if(num == 0) //taksi
            System.out.println("Linke tıklayarak devam edebilirsiniz :) \n"
                    + " https://www.uber.com/tr/");
        else if(num == 1)
        {

            for (int i = 0; i < firmalar.size(); i++) {
                System.out.printf("%d- ",i);
                System.out.println(firmalar.get(i).getFirmaAdi());
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            do{
                System.out.println("Size uygun olan otobüs firmasını seçiniz: ");
                num=0; flag=0;
                try{
                    choice = reader.readLine();
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
        }
        else if(num == 3)
        {
            System.out.println("Linke tıklayarak devam edebilirsiniz :) \n"
                    + " https://www.blablacar.com.tr/");
        }
        
        System.out.println("İyi Yolculuklar.");
    }
    private void readFile() throws FileNotFoundException, IOException
    {
        FileReader reader = new FileReader("otobusFirmalari.csv");
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
