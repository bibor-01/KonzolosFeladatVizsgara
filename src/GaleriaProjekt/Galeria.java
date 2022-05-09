package GaleriaProjekt;

import java.io.File;
import java.io.Serializable;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Galeria implements Iterable<KiallitasiTargy>, Serializable{

    private ArrayList<KiallitasiTargy> targyak;

    public Galeria(ArrayList<KiallitasiTargy> targyak) {
        this.targyak = targyak;
    }

    public Galeria() {
        targyak = new ArrayList<>();
        try {
            //készítő és cím
            Festmeny f1 = new Festmeny("keszito1", "cim3");
            //készítő és cím a mai dátummal
            Festmeny f2 = new Festmeny(LocalDate.now(), "keszito3", "cim2");
            //készítő és cím a hibás dátummal
            //Festmeny f3 = new Festmeny(LocalDate.parse("2022-11.14."), "keszito2", "cim1");
            //készítő és cím fájl eléréssel
            Festmeny f4 = new Festmeny(new File("kep.txt"), "keszito5", "cim4");
            //készítő és cím fájl eléréssel, mai dátummal
            Festmeny f5 = new Festmeny(new File("kep.txt"), LocalDate.now(), "keszito4", "cim5");
            targyak.add(f1);
            targyak.add(f2);
            //targyak.add(f3);
            targyak.add(f4);
            targyak.add(f5);
        } catch (HibasDatumException ex) {
            java.util.logging.Logger.getLogger(Galeria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }
    
    public void felvesz(KiallitasiTargy targy){
        targyak.add(targy);
    }

    public List<KiallitasiTargy> rendezCimSzerint() {
        Collections.sort(targyak, KiallitasiTargy.cimRendezo());
        return Collections.unmodifiableList(targyak);
    }

    public List<KiallitasiTargy> rendezKeszitoSzerint() {
        /*
        unmodifiableList:
            -a megadott lista nem módosítható nézetének megjelenítésére szolgál. 
             Ha bármilyen kísérlet történik a visszaadott lista módosítására akár
             közvetlenül, akár az iterátorán keresztül, az UnsupportedOperationException 
             kivételt eredményez.
        */
        Collections.sort(targyak, KiallitasiTargy.keszitoRendezo());

        return Collections.unmodifiableList(targyak);//<-A galéria legyen bejárható, amikor visszaadja tárgyait, nem módosítható (vagy másolat) listában.
    }

    @Override
    //Ez ahoz szükséges hogy forEach-el be tudjuk járni a galériát.A galéria legyen bejárható->eladat rész.
    public Iterator<KiallitasiTargy> iterator() {
        return Collections.unmodifiableList(targyak).iterator();
    }

}
