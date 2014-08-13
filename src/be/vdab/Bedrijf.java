package be.vdab;

import java.util.*;
import be.vdab.util.*;
import be.vdab.personeel.*;
import be.vdab.kader.*;
import java.io.*;

/**
 *
 * @author Dekleermaeker Peter
 */
public class Bedrijf {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
    FileOutputStream fos = null;
    ObjectOutputStream oos = null;
        
        Set bedrijf = new TreeSet();
        try {
            bedrijf.add(new Arbeider(1, "Anna", new WerknemersDatum(1,2,1980),15));
            bedrijf.add(new Bediende(2, "Brenda",new WerknemersDatum(1,3,1980),1500));
            bedrijf.add(new Arbeider(3, "Carla", new WerknemersDatum(1,2,1979), 15));
            bedrijf.add(new Bediende(4, "Daniella", new WerknemersDatum(1,3,1978), 1500));
            bedrijf.add(new Kaderlid(5, "Els", new WerknemersDatum(13,2,1977),2500,"chef"));
        } catch (Exception ex) {System.out.println(ex);}
            
        
        
        for (Object o : bedrijf)
            System.out.println(o);
    
        try {
            fos = new FileOutputStream("h:\\personeel.dat");
            oos = new ObjectOutputStream(fos);
            
            oos.writeObject(bedrijf);
        }
        catch (IOException ex) {System.err.println(ex.getMessage()); }
        finally {
            if (oos != null) {
                try { oos.close(); }
                catch (IOException ex) {System.err.println(ex.getMessage()); }
            }
        }
        
    }
    
}
