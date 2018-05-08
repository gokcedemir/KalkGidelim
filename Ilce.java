public class Ilce{

    private String ilceAdi;
    private String sehirAdi;


    public Ilce(String ilceAdi, String sehirAdi){
        this.ilceAdi = ilceAdi;
        this.sehirAdi = sehirAdi;
    }

    public String getIlceAdi() {
        return ilceAdi;
    }

    public String getSehirAdi() {
        return sehirAdi;
    }

    public double getDistance(){

        double distance = 0;

        if(getSehirAdi().equals("Istanbul")){//Istanbul
            switch (getIlceAdi()){
                case "Catalca": distance = 1; break;
                case "Beylikduzu": distance = 2;break;
                case "Avcilar": distance = 3;break;
                case "Eyup": distance = 4;break;
                case "Fatih": distance = 5;break;
                case "Kagithane": distance = 6;break;
                case "Sisli": distance = 7;break;
                case "Uskudar": distance = 8;break;
                case "Kadikoy": distance = 9;break;
                case "Maltepe": distance = 10;break;
                default: System.err.println("Ilce bulunamadi. "); distance = 99; break;

            }
        }else if(getSehirAdi().equals("Izmir")){//Izmır
            switch (getIlceAdi()){
                case "Cesme": distance = 1;break;
                case "Urla": distance = 2;break;
                case "Menderes": distance = 3;break;
                case "Bayindir": distance = 4;break;
                default: System.err.println("Ilce bulunamadi. "); distance = 99; break;
            }
        }else if(getSehirAdi().equals("Antalya")){
            switch (getIlceAdi()){
                case "Kas": distance = 1;break;
                case "Elmali": distance = 2;break;
                case "Manavgat": distance = 3;break;
                case "Alanya": distance = 4;break;
                default: System.err.println("Ilce bulunamadi. "); distance = 99; break;
            }
        }else if(getSehirAdi().equals("Ankara")){
            switch (getIlceAdi()){
                case "Beypazari": distance = 1;break;
                case "Kizilcahamam": distance = 2;break;
                case "Cubuk": distance = 3;break;
                case "Akyurt": distance = 4;break;
                default: System.err.println("Ilce bulunamadi. "); distance = 99; break;
            }
        }else if(getSehirAdi().equals("Bursa")){
            switch (getIlceAdi()){
                case "Karacabey": distance = 1;break;
                case "Mudanya": distance = 2;break;
                case "Gemlik": distance = 3;break;
                case "Yenisehir": distance = 4;break;
                default: System.err.println("Ilce bulunamadi. "); distance = 99; break;
            }
        }else if(getSehirAdi().equals("Bolu")){
            switch (getIlceAdi()){
                case "Goynuk": distance = 1;break;
                case "Mudurnu": distance = 2;break;
                case "Bolu Merkez": distance = 3;break;
                case "Gerede": distance = 4;break;
                default: System.err.println("Ilce bulunamadi. "); distance = 99; break;
            }
        }else if(getSehirAdi().equals("Gaziantep")){
            switch (getIlceAdi()){
                case "Islahiye": distance = 1;break;
                case "Nurdagi": distance = 2;break;
                case "Sehitkamil": distance = 3;break;
                case "Nizip": distance = 4;break;
                default: System.err.println("Ilce bulunamadi. "); distance = 99; break;
            }
        }else if(getSehirAdi().equals("Mugla")){
            switch (getIlceAdi()){
                case "Bodrum": distance = 1;break;
                case "Marmaris": distance = 2;break;
                case "Ula": distance = 3;break;
                case "Dalaman": distance = 4;break;
                default: System.err.println("Ilce bulunamadi. "); distance = 99; break;
            }
        }else if(getSehirAdi().equals("Nevsehir")){
            switch (getIlceAdi()){
                case "Gulsehir": distance = 1;break;
                case "Hacibektas": distance = 2;break;
                case "Kozakli": distance = 3;break;
                case "Urgup": distance = 4;break;
                default: System.err.println("Ilce bulunamadi. "); distance = 99; break;
            }
        }else if(getSehirAdi().equals("Trabzon")){
            switch (getIlceAdi()){
                case "Tonya": distance = 1;break;
                case "Akcaabat": distance = 2;break;
                case "Yomra": distance = 3;break;
                case "Of": distance = 4;break;
                default: System.err.println("Ilce bulunamadi. "); distance = 99; break;
            }
        }

        return distance;
    }

}

