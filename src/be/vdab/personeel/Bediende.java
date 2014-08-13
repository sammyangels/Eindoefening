package be.vdab.personeel;

import be.vdab.util.*;

/**
 *
 * @author Dekleermaeker Peter
 */
public class Bediende extends Werknemer{
    
    private double maandwedde = 1129.47d;
    
    public Bediende(int personeelsnummer, String naam, WerknemersDatum datumInDienst,
                                double maandwedde){
        super(personeelsnummer, naam, datumInDienst);
        this.maandwedde = maandwedde;
    }
    
    public void setMaandwedde(double maandwedde){
        this.maandwedde = maandwedde;
    }
    
    public double getMaandwedde(){
        return maandwedde;
    }
    
    @Override
    public double getVerloning(){
        return maandwedde;
    }
    
    @Override
    public String toString(){
        return super.toString() + "\t" + getVerloning();
    }
}
