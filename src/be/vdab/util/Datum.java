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
    
    private int rollbackDag, rollbackMaand, rollbackJaar;
    
    /**
     * array met de maximaal aantal dagen per maand. <p>
     * de 0 is voor maand 0, deze wordt niet gebruikt <p>
     * februari heeft 29 dagen + de waarde in schrikkel.
     */
    private int[] maxDag = { 0,31,29,31,30,31,30,31,31,30,31,30,31};
    
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
        this.dag = 1;
        this.maand = 1;
        this.jaar = 1584;
    }
    
    /**
     * constructor om een datum op te vullen
     * @param dag integer
     * @param maand integer
     * @param jaar integer
     */
    public Datum(int dag, int maand, int jaar) {
        rollbackDag = this.dag;
        rollbackMaand = this.maand;
        rollbackJaar = this.jaar;
        try {
            this.dag = dag;
            this.maand = maand;
            this.jaar = jaar;
            DatumValidatie();
        }
        catch (DatumException ex) {
                System.err.println("<<" + ex.getThrowable()+ ">> " + ex);
                this.dag = rollbackDag;
                this.maand = rollbackMaand;
                this.jaar = rollbackJaar;
        }
    }

    /**
     * Setter voor dag
     * @param dag integer
     */
    @Override
    public void setDag(int dag) {
        rollbackDag = this.dag;
        try {
            this.dag = dag;
            DatumValidatie();
        } 
        catch (DatumException ex) {
                System.err.println("<<" + ex.getThrowable()+ ">> " + ex);
                this.dag = rollbackDag; 
        }
    }
    
    /**
     * setter voor maand
     * @param maand integer
     */
    @Override
    public void setMaand(int maand){
        rollbackMaand = this.maand;
        try {
            this.maand = maand;
            DatumValidatie();
        }
        catch (DatumException ex) {
                System.err.println("<<" + ex.getThrowable()+ ">> " + ex);
                this.maand = rollbackMaand;
        }
    }
    
    /**
     * setter voor jaar
     * @param jaar integer
     */
    @Override
    public void setJaar(int jaar){
        rollbackJaar = this.jaar;
        try {
            this.jaar = jaar;
            DatumValidatie();
        }
        catch (DatumException ex) {
            System.err.println("<<" + ex.getThrowable()+ ">> " + ex);
            this.jaar = rollbackJaar;
        }
    }
    
    /**
     * setter voor de volledige datum
     * @param dag integer
     * @param maand integer
     * @param jaar integer
     */
    @Override
    public void setDatum(int dag, int maand, int jaar){
        setJaar(jaar);
        setMaand(maand);
        setDag(dag);
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
    
    private void DatumValidatie() throws DatumException{
        
        if (!(jaar >= 1584 && jaar <= 4099))
            throw new DatumException("Jaar niet in de geldige range(1584-4099) ",jaar);
        
        if (!(maand >= 1 && maand <= 12))
            throw new DatumException("Maand niet in de geldige range(1-12) ",maand);
        
        if (!((jaar%4 == 0) && (jaar%100 != 0)))
            if (!(jaar%400 == 0))
                schrikkel = -1;
        else
                schrikkel = 0;
         if (!(dag >= 1 && dag <= maxDag[maand]+schrikkel))
             throw new DatumException("dag niet in de geldige range (1-"+(maxDag[maand]+schrikkel)+") ",dag);
    }
    
}
