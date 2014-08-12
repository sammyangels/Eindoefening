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
     *  de 99 is voor maand 0, deze gaat alleen maar aangesproken worden bij 
     *  een initializatie zonder parameters.
     */
    private int[] maxDag = { 99,31,29,31,30,31,30,31,31,30,31,30,31};
    private int schrikkel;
    
    public Datum(){
        setJaar(1584);        
        setMaand(1);        
        setDag(1);
    }
    
    public Datum(int dag, int maand, int jaar) {
        setJaar(jaar);        
        setMaand(maand);        
        setDag(dag);


    }
    
    @Override
    public void setDag(int dag) {
        if (!((jaar%4 == 0) && (jaar%100 != 0)))
            if (!(jaar%400 == 0))
                schrikkel = -1;
        else
                schrikkel = 0;
         if (dag >= 1 && dag <= maxDag[maand]+schrikkel)
            this.dag = dag;
        else
            System.err.println(dag + "/" + maand + "/" + jaar + " fout");

    }
    
    @Override
    public void setMaand(int maand){
        if (maand >= 1 && maand <= 12)
        this.maand = maand;
    }
    
    @Override
    public void setJaar(int jaar){
        if (jaar >= 1584 && jaar <= 4099)
            this.jaar = jaar;
    }
    
    @Override
    public void setDatum(int dag, int maand, int jaar){
        setDag(dag);
        setMaand(maand);
        setJaar(jaar);
    }
    
    @Override
    public int getDag(){
        return dag;
    }
    
    @Override
    public int getMaand(){
        return maand;
    }
    
    @Override 
    public int getJaar(){
        return jaar;
    }
    
    @Override
    public String toString(){
        return dag + "/" + maand + "/" + jaar;
    }
    
    @Override
    public int compareTo(Object d){       // Generics ? Object --> Datum
        if (dag == ((Datum)d).getDag() &&
                maand == ((Datum)d).getMaand() &&
                jaar == ((Datum)d).getJaar())
            return 0;
        else
            return -1;
    }
    
}
