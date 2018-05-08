
/**
 *
 * @author Gökçe Demir
 */
public class Ulasim 
{
    protected String[] ulasimTipi;
    //composition has-a relationship
    public Sehir sehir; 
    
    private String firmaAdi;
    private String webSite;

    public Ulasim()
    {
        ulasimTipi = new String[4];
        sehir = new Sehir();
    }

    /**
     * @return the firmaAdi
     */
    public String getFirmaAdi() {
        return firmaAdi;
    }

    /**
     * @param firmaAdi the firmaAdi to set
     */
    public void setFirmaAdi(String firmaAdi) {
        this.firmaAdi = firmaAdi;
    }

    /**
     * @return the webSite
     */
    public String getWebSite() {
        return webSite;
    }

    /**
     * @param webSite the webSite to set
     */
    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }
}
