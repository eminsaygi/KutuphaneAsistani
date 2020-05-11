
package com.eminsaygi.kutuphane;

 /**
  * Bu kısımda kitap sütun bilgilerini tanımladım
  */
public class Kitap {
    
    private int id;
    private String adi;
    private String yazar;
    private String tur;
    private String cevirmen;

    public Kitap(int id, String adı, String yazar, String tür, String cevirmen) {
        this.id = id;
        this.adi = adı;
        this.yazar = yazar;
        this.tur = tür;
        this.cevirmen = cevirmen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdı() {
        return adi;
    }

    public void setAdı(String adı) {
        this.adi = adı;
    }

    public String getYazar() {
        return yazar;
    }

    public void setYazar(String yazar) {
        this.yazar = yazar;
    }

    public String getTür() {
        return tur;
    }

    public void setTür(String tür) {
        this.tur = tür;
    }

    public String getCevirmen() {
        return cevirmen;
    }

    public void setCevirmen(String cevirmen) {
        this.cevirmen = cevirmen;
    }
    
    
    
}
