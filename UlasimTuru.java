import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Gökçe Demir
 */


enum UlasimTipi {
   havayolu,
   demiryolu,
   karayolu,
   denizyolu
}

public class UlasimTuru 
{
    /**
     * composition has-a relationship
     */
    protected Ulasim ulasim;
    ArrayList<Ulasim> ulasimTipleri;
    protected KaraYolu karayolu;
    protected HavaYolu havayolu;
    protected DemirYolu demiryolu;
    protected DenizYolu denizyolu;
    
    /**
     * 
     */
    public UlasimTuru()
    {
        this.ulasimTipleri = new ArrayList();
        
        karayolu = new KaraYolu();
        havayolu = new HavaYolu();
        demiryolu = new DemirYolu();
        denizyolu = new DenizYolu();
    }

    public void main() throws IOException {
        UlasimTuru obj = new UlasimTuru();
        obj.welcomeMessage();
    }

    /**
     * 
     * @throws IOException 
     */
    public void welcomeMessage() throws IOException
    {
        readFromFile();
        System.out.println("=================================================================================\n");
        System.out.println("                           Konaklama menüsüne hoşgeldiniz.                       \n");
        System.out.println("=================================================================================\n");
        System.out.println("0- ANKARA\n" +
                           "1- ANTALYA\n" +
                           "2- BOLU\n" +
                           "3- BURSA\n" +
                           "4- GAZİANTEP\n" +
                           "5- İSTANBUL\n" +
                           "6- İZMİR\n" +
                           "7- MUĞLA\n" +
                           "8- NEVŞEHİR\n" +
                           "9- TRABZON\n");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int  i=0, flag =0;
        String choice;
        do{
            System.out.println("Gitmek istediğiniz şehri şeçiniz: ");
            i=0; flag=0;
            try{
                choice = reader.readLine();
                i = Integer.parseInt(choice);
            }catch(NumberFormatException e) {
                System.out.println("Yanlış girdiniz. Lütfen tekrar deneyiniz!");
                flag=-1;
            }
        }while(i<0 || i>9 || flag==-1);


        UlasimTipi rVal = printMenu(ulasimTipleri.get(i));
        System.out.println(rVal);
        
        if("havayolu".equals(rVal.toString()))
            havayolu.menu();
        else if("denizyolu".equals(rVal.toString()))
            denizyolu.getMenu();
        else if("demiryolu".equals(rVal.toString()))
            demiryolu.getMenu();
        else if("karayolu".equals(rVal.toString()))
            karayolu.menu();
        
         //once finished
    }
    
    /**
     * 
     * @param obj
     * @return 
     */
    protected UlasimTipi printMenu(Ulasim obj)
    {
        int i=0;
        while(i < 4)
        {
            String name = obj.ulasimTipi[i]; 
            if( (name.compareTo("null")) != 0)
                System.out.printf("%d- %s\n", i, name);
            ++i;
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int  n=0, flag =0;
        String choice;
        do{
            System.out.println("Hangi ulaşım türünü tercih edersiniz: ");
            n=0; flag=0;
            try{
                choice = reader.readLine();
                n = Integer.parseInt(choice);
            }catch(NumberFormatException e) {
                System.out.println("Yanlış girdiniz. Lütfen tekrar deneyiniz!");
                flag=-1;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }while(n<0 || n>3 || flag==-1);

        switch (n) {
            case 0:
                return UlasimTipi.havayolu;
            case 1:
                return UlasimTipi.demiryolu;
            case 2:
                return UlasimTipi.karayolu;
            case 3:
                return UlasimTipi.denizyolu;
            default:
                break;
        }
        return null;
    }
    /**
     * @throws java.io.FileNotFoundException
     */
    public void readFromFile() throws FileNotFoundException, IOException
    {
        FileReader reader = new FileReader("sehirler.csv");
        BufferedReader buffReader = new BufferedReader(reader);
        String readFile;  //read line by line file
        
        int i = 0;
        while((readFile = buffReader.readLine()) != null)
        {
            this.ulasim = new Ulasim();
            String[] record = readFile.split(",");
            ulasim.sehir.setSehirAdi(record[0]);
            ulasim.ulasimTipi[0] = record[1];
            ulasim.ulasimTipi[1] = record[2];
            ulasim.ulasimTipi[2] = record[3];
            ulasim.ulasimTipi[3] = record[4];
            ulasimTipleri.add(ulasim);
        }
    }
   
    
}
