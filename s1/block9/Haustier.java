package s1.block9;

public abstract class Haustier {

    private String name;
    private boolean steuerpflichtig;
    private double kostenTierarzt;

    /**
     * Get the value of kostenTierarzt
     *
     * @return the value of kostenTierarzt
     */
    public double getKostenTierarzt() {
        return kostenTierarzt;
    }

    /**
     * Set the value of kostenTierarzt
     *
     * @param kostenTierarzt new value of kostenTierarzt
     */
    public void setKostenTierarzt(double kostenTierarzt) {
        this.kostenTierarzt = kostenTierarzt;
    }


    /**
     * Get the value of steuerpflichtig
     *
     * @return the value of steuerpflichtig
     */
    public boolean getSteuerpflichtig() {
        return steuerpflichtig;
    }

    /**
     * Set the value of steuerpflichtig
     *
     * @param steuerpflichtig new value of steuerpflichtig
     */
    public void setSteuerpflichtig(boolean steuerpflichtig) {
        this.steuerpflichtig = steuerpflichtig;
    }


    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    public Haustier(String name, boolean steuerpflichtig, double kostenTierarzt) {
        this.name = name;
        this.steuerpflichtig = steuerpflichtig;
        this.kostenTierarzt = kostenTierarzt;
    }

    public String beschreibung() {
        String stpf = (steuerpflichtig) ? ", " : ", nicht ";
        String b = "Name :" + name
                + stpf + "steuerpflichtig, Kosten: "
                + kostenTierarzt;
        return b;
    }
}
