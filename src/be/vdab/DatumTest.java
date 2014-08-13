package be.vdab;

import be.vdab.util.*;

/**
 *
 * @author Dekleermaeker Peter
 */
public class DatumTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Datum d1 = new Datum(32,13,5100);
        Datum d2 = new Datum();
        System.out.println("1/1/1584 = " + d2);
        d2.setJaar(2000);
        System.out.println("1/1/2000 = " + d2);
        d2.setMaand(2);
        System.out.println("1/2/2000 = " + d2);
        d2.setDag(29);
        System.out.println("29/2/2000 = " + d2);
        d2.setJaar(1900);
        System.out.println("29/2/2000 = " + d2);
        d2.setDag(31);
        System.out.println("29/2/2000 = " + d2);
        d2.setMaand(1);
        System.out.println("29/1/2000 = " + d2);
        d2.setDag(31);
        System.out.println("31/1/2000 = " + d2);
        d2.setMaand(2);
        System.out.println("31/1/2000 = " + d2);
        d2.setJaar(1600);
        System.out.println("31/1/1600 = " + d2);
        
    }
    
}
