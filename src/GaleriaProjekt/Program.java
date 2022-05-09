package GaleriaProjekt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Program {

    public static void main(String[] args) throws IOException {
        Galeria galeria = new Galeria();
        System.out.println("cím szerint rendezés:");
        for (KiallitasiTargy targy : galeria.rendezCimSzerint()) {
            System.out.println(targy);
        }

        System.out.println("készítő szerint rendezés:");
        for (KiallitasiTargy targy : galeria.rendezKeszitoSzerint()) {
            System.out.println(targy);
        }

        //végül mutassuk be a megjelenítő metódust
        for (KiallitasiTargy targy : galeria) {
            /*
            instanceof:
                -összehasonlító operátorként is ismert, mivel összehasonlítja a példányt a típussal. Igazat vagy hamisat ad vissza. 
                Ha bármilyen null értékű változóval alkalmazzuk az instanceof operátort, akkor false értéket ad vissza.*/
            if (targy instanceof Festmeny) {
                ((Festmeny) targy).megjelenites();
            }

        }

        //kiírás:
        try {
            ObjectOutputStream objKi = new ObjectOutputStream(new FileOutputStream("galeria.bin"));
            objKi.writeObject(galeria);
            objKi.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
        }

        galeria = null;

        //Visszaolvasás
                
        try {
            ObjectInputStream objBe = new ObjectInputStream(new FileInputStream("galeria.bin"));
            galeria = (Galeria)objBe.readObject();
            objBe.close();          
            System.out.println("Visszaállítás:");
            for (KiallitasiTargy targy : galeria) {
                System.out.println(targy);
            }           
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
