package be.vdab.util;

import java.io.*;

/**
 *
 * @author Dekleermaeker Peter
 */
public class WerknemersDatum extends Datum {
    
    private final int oDag = 12;
    private final int oMaand = 2;
    private final int oJaar = 1977;
    
    public WerknemersDatum(int dag, int maand, int jaar) throws Exception{
        if ((new Datum(oDag, oMaand, oJaar)).compareTo(new Datum(dag, maand, jaar)) > 0)
            throw new Exception("Datum voor oprichting bedrijf");
        setDag(dag);
        setMaand(maand);
        setJaar(jaar);
    }
    
}
