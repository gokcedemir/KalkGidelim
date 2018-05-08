import java.util.ArrayList;

public class Barinak implements Comparable<Barinak> {

    public String city;
    public String county;
    public int capacity;
    public int price;                // gunluk kiralama ucreti
    public ArrayList<Hayvan> hayvanlar;
    public int id;

    public Barinak()
    {
        hayvanlar = new ArrayList<Hayvan>();
    }

    public void addHayvan(Hayvan hayvan)
    {
        hayvanlar.add(hayvan);
    }

    public Barinak getBarinak()
    {
        return this;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return  city + ", " + county + ", Kapasite : " +
                capacity + ", Günlük Ücreti : " + price + "TL";
    }

    @Override
    public int compareTo(Barinak o) {
        return 0;
    }
}