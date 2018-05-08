import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Etkinlikler {

    PriorityQueue<Etkinlik> etkinlikSirasi;
    ArrayList<Etkinlik> siraliEtkinlik;
    String sehirAdi;

    /**
     * Bu bir yuvalanmış sınıftır. Her verisi düzgün çalışmakta. İçini açıp bakmaya gerek yok.
     */
    public class Etkinlik implements Comparable<Etkinlik> {

        Date etkinlikTarihi;
        String etkinlikTuru;
        String etkinlikAlani;
        String etkinlikIlce;
        String etkinlikIl;
        String etkinlikSahibi;

        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        public Etkinlik(String etkinlikBilgi) throws ParseException {
            String[] etkinlikBilgiArrayi = etkinlikBilgi.split(",");
            etkinlikTarihi = formatter.parse(etkinlikBilgiArrayi[0]);
            etkinlikTuru = etkinlikBilgiArrayi[1];
            etkinlikSahibi = etkinlikBilgiArrayi[2];
            etkinlikAlani = etkinlikBilgiArrayi[3];
            etkinlikIlce = etkinlikBilgiArrayi[4];
        }

        public Date getEtkinlikTarihi() {
            return etkinlikTarihi;
        }

        public String getEtkinlikTuru() {
            return etkinlikTuru;
        }

        public String getEtkinlikAlani() {
            return etkinlikAlani;
        }

        public String getEtkinlikIlce() {
            return etkinlikIlce;
        }

        public String getEtkinlikIl() {
            return etkinlikIl;
        }

        public String getEtkinlikSahibi() {
            return etkinlikSahibi;
        }

        public void setEtkinlikTarihi(Date etkinlikTarihi) {
            this.etkinlikTarihi = etkinlikTarihi;
        }

        public void setEtkinlikTuru(String etkinlikTuru) {
            this.etkinlikTuru = etkinlikTuru;
        }

        public void setEtkinlikAlani(String etkinlikAlani) {
            this.etkinlikAlani = etkinlikAlani;
        }

        public void setEtkinlikIlce(String etkinlikIlce) {
            this.etkinlikIlce = etkinlikIlce;
        }

        public void setEtkinlikIl(String etkinlikIl) {
            this.etkinlikIl = etkinlikIl;
        }

        public void setEtkinlikSahibi(String etkinlikSahibi) {
            this.etkinlikSahibi = etkinlikSahibi;
        }

        @Override
        public int compareTo(Etkinlik etkinlik) {
            if (this.etkinlikTarihi.after(etkinlik.getEtkinlikTarihi()))
                return 1;
            else if (this.etkinlikTarihi.before(etkinlik.getEtkinlikTarihi()))
                return -1;
            else
                return 0;

        }

        public String toString() {
            return "\nEtkinlik türü:   " + getEtkinlikTuru() +
                    "\nEtkinlik tarihi: " + getEtkinlikTarihi() +
                    "\nEtkinlik ilçesi: " + getEtkinlikIlce() +
                    "\nEtkinlik adı:    " + getEtkinlikSahibi() +
                    "\nEtkinlik alanı:  " + getEtkinlikAlani() + "\n";
        }
    }

    public int etkinliklerArayuzu() {
        Boolean loop = true;
        int ilkGiris = 0;
        Integer komut = 0;
        BufferedReader komutAl = new BufferedReader(new InputStreamReader(System.in));

        while (loop) {

            if (ilkGiris == 0) {
                bugünküEtkinlikler();
                ilkGiris++;
            }

            System.out.println("Çıkış için -1; etkinlik için numarasını girin: ");
            System.out.println("1 -> SERGİ\n2 -> KONSER\n3 -> FUAR\n4 -> SEMİNER\n");
            try {
                komut = Integer.parseInt(komutAl.readLine());
            } catch (Exception e) {
                System.out.println("Hatalı girdi, tekrar deneyin. ");
                continue;
            }
            if (komut == -1)
                loop = false;
            switch (komut) {
                case 1:
                    sergiListeleme();
                    break;
                case 2:
                    konserListeleme();
                    break;
                case 3:
                    fuarListeleme();
                    break;
                case 4:
                    seminerListeleme();
                    break;
                default:
                    if (komut != -1)
                        System.out.println("Geçersiz bir sayı girdiniz: " + komut);
            }
        }
        girisBilgisi();
        return 0;
    }

    public Etkinlikler() {
        etkinlikSirasi = new PriorityQueue<>();
        siraliEtkinlik = new ArrayList<>();
        girisBilgisi();
        //dosyadanOku();
        //etkinlikDosyaDuzenle();
        //etkinliklerArayuzu();
    }

    public void tarihSıralayıcı(String tarih) {
        if (tarih.length() != 10) {
            System.out.println("This format is not supported.");
        } else {
            DateFormat format = new SimpleDateFormat("dd/MM//yyyy HH:mm");
            try {
                Date istenen = format.parse(tarih);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

    }

    public void ekranaBas() {

        Iterator<Etkinlik> etkinlikIterator = siraliEtkinlik.iterator();
        while (etkinlikIterator.hasNext()) {
            Etkinlik e = etkinlikIterator.next();
            System.out.println(e.toString());

        }
    }

    public void bugünküEtkinlikler() {
        Iterator<Etkinlik> etkinlikIterator = siraliEtkinlik.iterator();
        Date today = new Date();
        Date tomorrow = new Date(today.getTime() + (1000 * 60 * 60 * 24));
        System.out.println("Bir gün içerisindeki etkinlikler sıralanıyor:");
        while (etkinlikIterator.hasNext()) {
            Etkinlik e = etkinlikIterator.next();
            if (e.getEtkinlikTarihi().before(tomorrow))
                System.out.println(e);
        }
    }

    public void sergiListeleme() {
        int sergiSayisi = 0;
        for (Etkinlik e : siraliEtkinlik) {
            if (e.getEtkinlikTuru().equals("Sergi")) {
                System.out.println(e.toString());
                sergiSayisi++;
            }
        }
        if (sergiSayisi == 0)
            System.out.println("Yakın zamanlarda sergi bulunamadı.");
    }

    public void konserListeleme() {
        int konserSayisi = 0;
        for (Etkinlik e : siraliEtkinlik) {
            if (e.getEtkinlikTuru().equals("Konser")) {
                System.out.println(e.toString());
                konserSayisi++;
            }
        }
        if (konserSayisi == 0)
            System.out.println("Yakın zamanlarda konser bulunamadı.");
    }

    public void fuarListeleme() {
        int fuarSayisi = 0;
        for (Etkinlik e : siraliEtkinlik) {
            if (e.getEtkinlikTuru().equals("Fuar")) {
                System.out.println(e.toString());
                fuarSayisi++;
            }
        }
        if (fuarSayisi == 0)
            System.out.println("Yakın zamanlarda fuar bulunamadı.");
    }

    public void seminerListeleme() {
        int seminerSayisi = 0;
        for (Etkinlik e : siraliEtkinlik) {
            if (e.getEtkinlikTuru().equals("Seminer")) {
                System.out.println(e.toString());
                seminerSayisi++;
            }
        }
        if (seminerSayisi == 0)
            System.out.println("Yakın zamanlarda seminer bulunamadı.");
    }

    /**
     * Bu yöntem dosyadan verileri okur.
     */
    public void dosyadanOku() {
        String csvFile = this.sehirAdi + "etkinlik.csv";
        String line;
        BufferedReader br = null;
        try {

            br = new BufferedReader(new FileReader(csvFile));

            while ((line = br.readLine()) != null) {
                try {
                    Etkinlik gecici = new Etkinlik(line);
                    etkinlikSirasi.offer(gecici);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Bu yöntem, dosyadan okuduğu verileri, zamana göre yeniden okur ve düzeltir.
     * Bunu yaparken, çıkan sıralı veriyi de arrayliste atar.
     */
    public void etkinlikDosyaDuzenle() {

        String outFile = this.sehirAdi + "etkinlik.csv";
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        PrintWriter pw = null;
        Date today = new Date();

        while (etkinlikSirasi.peek().getEtkinlikTarihi().before(today))
            etkinlikSirasi.poll();

        try {
            pw = new PrintWriter(new BufferedWriter(new FileWriter(outFile, false)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (etkinlikSirasi.size() > 0) {
            Etkinlik e = etkinlikSirasi.poll();
            siraliEtkinlik.add(e);
            pw.println(formatter.format(e.getEtkinlikTarihi()) + "," + e.getEtkinlikTuru() + "," + e.getEtkinlikSahibi() + "," +
                    e.getEtkinlikAlani() + "," + e.getEtkinlikIlce());
        }
        pw.flush();
        pw.close();

    }

    public void girisBilgisi() {

        int secim = 0;
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Boolean loop = true;

        System.out.println("===========================================================\n");
        System.out.println("             Etkinlik seçim menüsüne hoşgeldiniz.\n");
        System.out.println("===========================================================\n");

        System.out.println("Bulunduğunuz şehri seçiniz(Ankara için 1, çıkış için -1)");
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

        while (loop) {
            try {
                secim = Integer.parseInt(input.readLine());
                switch (secim) {
                    case 1:
                        this.sehirAdi = "ankara";
                        loop = false;
                        break;
                    case 2:
                        this.sehirAdi = "antalya";
                        loop = false;
                        break;
                    case 3:
                        this.sehirAdi = "bolu";
                        loop = false;
                        break;
                    case 4:
                        this.sehirAdi = "bursa";
                        loop = false;
                        break;
                    case 5:
                        this.sehirAdi = "gaziantep";
                        loop = false;
                        break;
                    case 6:
                        this.sehirAdi = "istanbul";
                        loop = false;
                        break;
                    case 7:
                        this.sehirAdi = "izmir";
                        loop = false;
                        break;
                    case 8:
                        this.sehirAdi = "mugla";
                        loop = false;
                        break;
                    case 9:
                        this.sehirAdi = "nevsehir";
                        loop = false;
                        break;
                    case 10:
                        this.sehirAdi = "trabzon";
                        loop = false;
                        break;
                    default:
                        if(secim != -1) {
                            System.out.println("Bu şehirlerden birini seçin: 1- ANKARA...");
                            break;
                        }
                }
                if(secim == -1)
                    break;
            } catch (Exception e) {
                System.out.println("Tekrar dene.");
            }
        }
        if(secim != -1) {
            etkinlikSirasi.clear();
            siraliEtkinlik.clear();
            dosyadanOku();
            etkinlikDosyaDuzenle();
            etkinliklerArayuzu();
        }
    }

}
