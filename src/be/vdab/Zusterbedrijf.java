/*
 * To change this license header, choise License Headers in Project Properties.
 * To change this template file, choise Tools | Templates
 * and open the template in the editor.
 */

package be.vdab;

import java.io.*;
import java.util.*;

/**
 *
 * @author zi11
 */
public class Zusterbedrijf {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        Collection bedrijf = null;

        try {
            fis = new FileInputStream("h:\\personeel.dat");
            ois = new ObjectInputStream(fis);
            
            bedrijf = new TreeSet();
            bedrijf = (Collection)ois.readObject();
        }
        catch (Exception ex) {System.err.println(ex.getMessage()); }
        finally {
            if (ois != null) {
                try { ois.close(); }
                catch (IOException ex) {System.err.println(ex.getMessage()); }
            }
        }
        for (Object o : bedrijf)
            System.out.println(o);
        
    }
}
  
