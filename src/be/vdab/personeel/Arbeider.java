package be.vdab.personeel;

import be.vdab.util.*;

/**
 *
 * @author Dekleermaeker Peter
 */
public class Arbeider extends Werknemer{
    
    private float uurloon = 9.76f;
    
    public Arbeider(int personeelsnummer, String naam, WerknemersDatum datumInDienst, 
                            float uurloon){
        super(personeelsnummer, naam, datumInDienst);
        this.uurloon = uurloon;
    }
    
    public void setUurloon(float uurloon){
        this.uurloon = uurloon;
    }
    
    public float getUurloon(){
        return uurloon;
    }
    
    @Override
    public double getVerloning(){
        return (uurloon * 7.6 * 65 / 3);
    }
    
    @Override 
    public String toString(){
        return super.toString() + "\t" + getVerloning();
    }
    
}
