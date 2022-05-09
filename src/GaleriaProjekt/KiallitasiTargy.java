package GaleriaProjekt;

import java.io.Serializable;
import java.text.Collator;
import java.time.LocalDate;
import java.util.Comparator;

class KeszitoComparator implements Comparator<KiallitasiTargy> {

    @Override
    public int compare(KiallitasiTargy egyik, KiallitasiTargy masik) {
        Collator coll = Collator.getInstance();
        return coll.compare(egyik.getKeszito(), masik.getCim());
    }

}

class CimComparator implements Comparator<KiallitasiTargy> {

    @Override
    public int compare(KiallitasiTargy egyik, KiallitasiTargy masik) {
        Collator coll = Collator.getInstance();
        return coll.compare(egyik.getKeszito(), masik.getCim());
    }

}

public abstract class KiallitasiTargy implements Serializable{

    /*
    LocalDate: 
     -LocalDateegy megváltoztathatatlan dátum-idő objektum, 
      amely egy dátumot reprezentál, 
      amelyet gyakran év-hónap-napként tekintenek.
     -equals módszert az összehasonlításhoz kell használni.
    
     */
    private LocalDate letrehozas;
    private String keszito, cim;

    public KiallitasiTargy(String keszito, String cim) throws HibasDatumException {
        this(LocalDate.now()/*<-Ha nem adunk meg dátumot, akkor a mai dátum kerül beállításra.*/, keszito, cim);
    }

    public KiallitasiTargy(LocalDate letrehozas, String keszito, String cim) throws HibasDatumException {
        /*
        isAfter:
         -A Java LocalDate osztályának isAfter() metódusa ellenőrzi, 
          hogy ez a dátum a megadott dátum után van-e.*/
        if (letrehozas.isAfter(LocalDate.now())) {
            throw new HibasDatumException("Nem létező dátum");
        }
        this.letrehozas = letrehozas;
        this.keszito = keszito;
        this.cim = cim;
    }

    public LocalDate getLetrehozas() {
        return letrehozas;
    }

    public String getKeszito() {
        return keszito;
    }

    public String getCim() {
        return cim;
    }
    
    public static CimComparator cimRendezo(){
        return new CimComparator();
    }
    
    public static KeszitoComparator keszitoRendezo(){
        return new KeszitoComparator();
    }

    @Override
    public String toString() {
        return "KiallitasiTargy{" + "letrehozas=" + letrehozas + ", keszito=" + keszito + ", cim=" + cim + '}';
    }

}
