package be.vdab.util;

/**
 *
 * @author Dekleermaeker Peter
 */
public class DatumException extends Exception {
    
    /**
     * Integer om errorcodes op te halen en door te geven
     */
    private int throwable;
    
    /**
     * Basis constructor
     */
    public DatumException() {}
    
     /**
     * Eigen boodschap in exception gooien
     * @param boodschap eigen boodschap
     */
    public DatumException(String boodschap) {
        super(boodschap);
    }
    
    /**
     * Boodschap + errorcode in exception gooien
     * @param boodschap eigen boodschap
     * @param throwable errorCode
     */
    public DatumException(String boodschap, int throwable){
        super(boodschap);
        this.throwable = throwable;
    }
    
    /**
     * Errorcode in exception gooien
     * @param throwable errorCode
     */
    public DatumException(int throwable){
        this.throwable = throwable;
    }
    
    /**
     * ErrorCode ophalen
     * @return errorCode
     */
    public int getThrowable(){
        return throwable;
    }
    
}
