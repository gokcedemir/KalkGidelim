import java.io.*;
import java.util.ArrayList;

public class Records {


    // Delimiter
    private static final String NEW_LINE = "\n";

    private static String filename;

    public Records(String filename) {
        this.filename = filename;
    }

    public static String getFilename() {
        return filename;
    }

    public void LoadRecord(ArrayList<DigerIhtiyaclar> liste) {

        BufferedReader BReader = null;
        String Info = "";
        DigerIhtiyaclar temp;
        try {

            BReader = new BufferedReader(new FileReader(filename));

            int i = 0;
            while ((Info = BReader.readLine()) != null) {
                temp = new DigerIhtiyaclar();

                liste.add(temp);
                String[] entry = Info.split(";");

                Sehir sehir = new Sehir(entry[0]);
                Ilce ilce = new Ilce(entry[1],entry[0]);
                liste.get(i).setSehir(sehir);
                liste.get(i).setIlce(ilce);
                liste.get(i).ilceIsmi = entry[1];
                liste.get(i).sehirIsmi = entry[0];
                liste.get(i).setName(entry[2]);
                liste.get(i).setAddress(entry[3]);
                liste.get(i).setTelefonNo(entry[4]);
                i++;
            }

        } catch (FileNotFoundException e1) {
            System.err.println("File not found.");
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            if (BReader != null) {
                try {
                    BReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
