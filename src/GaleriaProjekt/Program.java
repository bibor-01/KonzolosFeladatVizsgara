package GaleriaProjekt;

public class Program {

    public static void main(String[] args) {
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
    }

}
