package be.vdab.util;

/**
 *
 * @author Dekleermaeker Peter
 */
public class Datum implements IDatum, 
                              Comparable<Datum>{
    private int dag=1;
    private int maand=1;
    private int jaar=1584;
    
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
    private int schrikkel=0;
    
    
    /**
     * constructor om een datum op te vullen
     * @param dag integer
     * @param maand integer
     * @param jaar integer
     */
    public Datum(int dag, int maand, int jaar) {

    	try {
        	if (DatumValidatie(jaar, 'j'))
        		this.jaar = jaar;  
        	schrikkel();
        	if (DatumValidatie(maand, 'm'))
        		this.maand = maand;
        	if (DatumValidatie(dag, 'd'))
        		this.dag = dag;
        	
  		
    	} catch (DatumException ex) {
    		System.out.println("<<" + ex.getThrowable()+ ">> " + ex);
    	}
    }
    

    /**
     * Setter voor dag
     * @param dag integer
     */
    @Override
    public void setDag(int dag) {
        try {
        	if (DatumValidatie(dag, maand, jaar))
        		this.dag = dag;
        } 
        catch (DatumException ex) {
                System.out.println("<<" + ex.getThrowable()+ ">> " + ex);
        }
    }
    
    /**
     * setter voor maand
     * @param maand integer
     */
    @Override
    public void setMaand(int maand){
        try {
        	if (DatumValidatie(dag, maand, jaar))
        		this.maand = maand;
        }
        catch (DatumException ex) {
                System.out.println("<<" + ex.getThrowable()+ ">> " + ex);
        }
    }
    
    /**
     * setter voor jaar
     * @param jaar integer
     */
    @Override
    public void setJaar(int jaar){
        try {
        	if (DatumValidatie(dag, maand, jaar))
        		this.jaar = jaar; 
        }
        catch (DatumException ex) {
            System.out.println("<<" + ex.getThrowable()+ ">> " + ex);
        }
    	schrikkel();
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
     * compareTo
     */
    @Override
    public int compareTo(Datum d){       
        return (jaar*10000+maand*100+dag)-(d.getJaar()*10000+d.getMaand()*100+d.getDag());
    }
    
    /**
     * Berekening schrikkeljaar
     */
    private void schrikkel(){
        if (!((jaar%4 == 0) && (jaar%100 != 0)))
            if (!(jaar%400 == 0))
                schrikkel = -1;
        else
                schrikkel = 0;
    }
    
    /**
     * Validatie volledige datum
     * @param dd int
     * @param mm int 
     * @param jj int
     * @return altijd true, bij een probleem wordt er een exception gethrowed
     * @throws DatumException
     */
    private boolean DatumValidatie(int dd, int mm, int jj) throws DatumException{
    	if (mm != 2)
    		schrikkel = 0;
    	if (!(jj >= 1584 && jj <= 4099))
                throw new DatumException("Jaar niet in de geldige range(1584-4099) ",jj); 
    	if (!(mm >= 1 && mm <= 12))
                throw new DatumException("Maand niet in de geldige range(1-12) ",mm);
    	if (!(dd >= 1 && dd <= maxDag[mm]+schrikkel))
    			throw new DatumException("dag niet in de geldige range (1-"+(maxDag[mm]+schrikkel)+") ",dd);
    	return true;
    }
    
    /** 
     * Validatie van apparte datum velden
     * @param datumVeld int (dag, maand of jaar)
     * @param check char aanduiding welk datumveld
     * @return altijd true, bij een probleem wordt er een exception gethrowed
     * @throws DatumException
     */
    private boolean DatumValidatie(int datumVeld, char check) throws DatumException{
    	switch (check){
    	case 'j' :	
            if (!(datumVeld >= 1584 && datumVeld <= 4099))
                throw new DatumException("Jaar niet in de geldige range(1584-4099) ",datumVeld); 
            break;
    	case 'm':
    		if (!(datumVeld >= 1 && datumVeld <= 12))
                throw new DatumException("Maand niet in de geldige range(1-12) ",datumVeld);
    		break;
    	case 'd':
    		if (!(datumVeld >= 1 && datumVeld <= maxDag[maand]+schrikkel))
    			throw new DatumException("dag niet in de geldige range (1-"+(maxDag[maand]+schrikkel)+") ",datumVeld);
    	}
    	return true;
    }
    
}
