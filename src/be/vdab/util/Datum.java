package be.vdab.util;

/**
 *
 * @author Dekleermaeker Peter
 */
public class Datum implements IDatum {
    private int dag;
    private int maand;
    private int jaar;
    
    public Datum(int dag, int maand, int jaar) {
        setDag(dag);
        setMaand(maand);
        setJaar(jaar);
        
    }
    
    @Override
    public void setDag(int dag) {
        if (dag >= 1 && dag <= 31) // uitbreiden
            this.dag = dag;
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
}
