
/**
 *
 * @author Gökçe Demir
 */
public class Sehir 
{
    private  String sehirAdi ;

    /*No parameter constructor*/
    public Sehir()
    {
        this.sehirAdi="";
    }
    
    
    public Sehir(String isim)
    {
        this.sehirAdi = isim;
    }

    /**
     * @return the sehirAdi
     */
    public String getSehirAdi() {
        return sehirAdi;
    }

    /**
     * @param sehirAdi the sehirAdi to set
     */
    public void setSehirAdi(String sehirAdi) {
        this.sehirAdi = sehirAdi;
    }

    
}
