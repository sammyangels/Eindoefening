package be.vdab.util;

/**
 *
 * @author Dekleermaeker Peter
 */
public interface IDatum {
    public void setDag(int dag);
    public int getDag();
    public void setMaand(int maand);
    public int getMaand();
    public void setJaar(int jaar);
    public int getJaar();
    public void setDatum(int dag, int maand, int jaar);
}
