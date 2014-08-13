package be.vdab.kader;

import be.vdab.util.*;
import be.vdab.personeel.*;

/**
 *
 * @author Dekleermaeker Peter
 */
public class Kaderlid extends Bediende{
    
    private String functietitel="manager";
    
    public Kaderlid(int personeelsnummer, String naam, WerknemersDatum datumInDienst,
                                double maandwedde, String functietitel){
        super(personeelsnummer, naam, datumInDienst, maandwedde);
        this.functietitel = functietitel;
    }
    
    public void setFunctietitel(String functietitel){
        this.functietitel = functietitel;
    }
    
    public String getFunctietitel(){
        return functietitel;
    }
    
}
