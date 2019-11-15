package s1.block8;

public class LowClass extends TopClass {
    protected static int zaehler;

    public LowClass() {zaehler++;}

    protected static int getZaehler() {return zaehler;}

    protected void test (){
        System.out.println( getZaehler() + " Instanzen der Klasse LowClass erzeugt");
        System.out.println( TopClass.getZaehler() + " Instanzen der Klasse TopClass erzeugt");
    }

    public static void main(String[] args) {
        int size = 3;
        TopClass[]  feldT = new TopClass[size];
        LowClass[]  feldL = new LowClass[size];
        for ( int i=0; i<size; i++) feldT[i]= new TopClass();
        for ( int i=0; i<size; i++) {
            feldL[i]= new LowClass();
            feldL[i].test();
        }
        System.out.println(TopClass.getZaehler() + " Instanzen TopClass generiert, "+
                LowClass.getZaehler() + " Instanzen LowClass generiert");

    }

}
