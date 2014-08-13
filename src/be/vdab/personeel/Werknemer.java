package be.vdab.personeel;

import be.vdab.util.*;
import java.io.Serializable;

/**
 *
 * @author Dekleermaeker
 */
public abstract class Werknemer implements Serializable,
                                    Comparable<Werknemer>{
    private int personeelsnummer=-1;
    private WerknemersDatum datumInDienst;
    private String naam="nog niet ingevuld";
    
    
    public Werknemer(){}
    
    public Werknemer(int personeelsnummer, String naam, WerknemersDatum datumInDienst) {
        try {
            setPersoneelnummer(personeelsnummer);
            setNaam(naam);
            setDatumInDienst(datumInDienst);
        } catch (Exception ex) {System.out.println(ex);}
    }
    
    public void setPersoneelnummer(int personeelsnummer) throws Exception{
        if (personeelsnummer >0)
            this.personeelsnummer = personeelsnummer;
        else
            throw new Exception("personeelsnummer moet groter als 0 zijn");
    }
    
    public void setNaam(String naam) throws Exception{
        if (naam != null)
            this.naam = naam;
        else
            throw new Exception("Naam mag niet null zijn");
    }
    
    public void setDatumInDienst(WerknemersDatum datumInDienst){
        this.datumInDienst = datumInDienst;
    }
    
    public int getPersoneelsnummer(){
        return personeelsnummer;
    }
    
    public String getNaam(){
        return naam;
    }
    
    public WerknemersDatum getDatumInDienst(){
        return datumInDienst;
    }
    
    @Override 
    public String toString(){
        return datumInDienst + "\t" + personeelsnummer + "\t" + naam;
    }
    
    @Override
    public int compareTo(Werknemer w){
        WerknemersDatum d = w.getDatumInDienst();
        return datumInDienst.compareTo(d);
    }
    
    public abstract double getVerloning();
            
}
