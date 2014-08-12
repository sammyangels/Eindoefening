package be.vdab.util;

/**
 *
 * @author Dekleermaeker Peter
 */
public class Datum implements IDatum, 
                              Comparable{
    private int dag;
    private int maand;
    private int jaar;
    
    /**
     * array met de maximaal aantal dagen per maand. <p>
     * de 99 is voor maand 0, deze gaat alleen maar aangesproken worden bij 
     * een initializatie zonder parameters. <p>
     * februari heeft 29 dagen + de waarde in schrikkel.
     */
    private int[] maxDag = { 99,31,29,31,30,31,30,31,31,30,31,30,31};
    
    /**
     * variable om te helpen in de berekening van de maand februari voor
     * schrikkeljaren.<p>
     * 0 is een schrikkeljaar <p>
     * -1 is GEEN schrikkeljaar <p>
     */
    private int schrikkel;
    
    /**
     * Initializatie contructor zonder waardes
     * init waarde = 1/1/1584
     */
    public Datum(){
        setJaar(1584);        
        setMaand(1);        
        setDag(1);
    }
    
    /**
     * constructor om een datum op te vullen
     * @param dag integer
     * @param maand integer
     * @param jaar integer
     */
    public Datum(int dag, int maand, int jaar) {
        setJaar(jaar);        
        setMaand(maand);        
        setDag(dag);
    }

    /**
     * Setter voor dag
     * @param dag integer
     */
    @Override
    public void setDag(int dag) {
        this.dag = dag;
    }
    
    /**
     * setter voor maand
     * @param maand integer
     */
    @Override
    public void setMaand(int maand){
        this.maand = maand;
    }
    
    /**
     * setter voor jaar
     * @param jaar integer
     */
    @Override
    public void setJaar(int jaar){
            this.jaar = jaar;
    }
    
    /**
     * setter voor de volledige datum
     * @param dag integer
     * @param maand integer
     * @param jaar integer
     */
    @Override
    public void setDatum(int dag, int maand, int jaar){
        setDag(dag);
        setMaand(maand);
        setJaar(jaar);
    }
    
    /**
     * getter voor dag
     * @return dag integer
     */
    @Override
    public int getDag(){
        return dag;
    }
    
    /**
     * getter voor maand
     * @return maand integer
     */
    @Override
    public int getMaand(){
        return maand;
    }
    
    /**
     * getter voor jaar
     * @return jaar integer
     */
    @Override 
    public int getJaar(){
        return jaar;
    }
    
    /**
     * Override voor string waarde van de class datum
     * @return dd/mm/jjjj
     */
    @Override
    public String toString(){
        return dag + "/" + maand + "/" + jaar;
    }
    
    /**
     * Comparable van datum
     * @param d Object
     * @return  0 is gelijk
     *          -1 is niet gelijk
     */
    @Override
    public int compareTo(Object d){       // Generics ? Object --> Datum
        if (dag == ((Datum)d).getDag() &&
                maand == ((Datum)d).getMaand() &&
                jaar == ((Datum)d).getJaar())
            return 0;
        else
            return -1;
    }
    
    private Boolean DatumValidatie() throws DatumException{
        
        if (!(jaar >= 1584 && jaar <= 4099))
            throw new DatumException("Jaar niet in de geldige range(1584-4099)",jaar);
        
        if (!(maand >= 1 && maand <= 12))
            throw new DatumException("Maand niet in de geldige range(1-12)",maand);
        
        if (!((jaar%4 == 0) && (jaar%100 != 0)))
            if (!(jaar%400 == 0))
                schrikkel = -1;
        else
                schrikkel = 0;
         if (!(dag >= 1 && dag <= maxDag[maand]+schrikkel))
             throw new DatumException("dag niet in de geldige range (1-"+maxDag[maand]+schrikkel+")",dag);

         return true;

    }
    
}
