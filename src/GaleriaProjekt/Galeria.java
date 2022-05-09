
package GaleriaProjekt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Galeria {
    private ArrayList<KiallitasiTargy> targyak;

    public Galeria(ArrayList<KiallitasiTargy> targyak) {
        this.targyak = targyak;
    }

    public Galeria() {
    }
    
    
    public List<KiallitasiTargy> rendezCimSzerint(){
        Collections.sort(targyak, KiallitasiTargy.cimRendezo());
        return Collections.unmodifiableList(targyak);
    }
    
    public List<KiallitasiTargy> rendezKeszitoSzerint(){
        Collections.sort(targyak, KiallitasiTargy.keszitoRendezo());
        return Collections.unmodifiableList(targyak);
    }
    
}
