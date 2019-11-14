package s1.block6;

public class Adresse {
    public String ort;
    public String plz;
    public String strasse;
    public String hausnr;

    public Adresse (String o, String p, String s, String h){
        ort     = o;
        plz     = p;
        strasse = s;
        hausnr  = h;
    }

    public Adresse (Adresse orig) {
        ort     = orig.ort;
        plz     = orig.plz;
        strasse = orig.strasse;
        hausnr  = orig.hausnr;
    }
}
