package ift3913.tp1.metrics;

public class Metrics {
    
    Metrics() {}
    
    public double ana;
    public int nom;
    public int noa;
    public int itc;
    public int etc;
    public int cac;
    public int dit;
    public int cld;
    public int noc;
    public int nod;
    
    public void print() {
        System.out.println("Metrics:");
        System.out.println("ANA: " + ana);
        System.out.println("NOM: " + nom);
        System.out.println("NOA: " + noa);
        System.out.println("ITC: " + itc);
        System.out.println("ETC: " + etc);
        System.out.println("CAC: " + cac);
        System.out.println("DIT: " + dit);
        System.out.println("CLD: " + cld);
        System.out.println("NOC: " + noc);
        System.out.println("NOD: " + nod);
    }
    
    public String toString(){
    	return "ANA: " + ana 
    	+ "\nNOM: " + nom 
    	+ "\nNOA: " + noa 
    	+ "\nITC: " + itc
        + "\nETC: " + etc
        + "\nCAC: " + cac
        + "\nDIT: " + dit
        + "\nCLD: " + cld
        + "\nNOC: " + noc
        + "\nNOD: " + nod;
    }
}
