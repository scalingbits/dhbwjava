package s2.generics;
/**
 *
 * @author s@scalingbits.com
 */
public class Bier extends Getraenk {
   private final String brauerei;
   
   public Bier(String b) { brauerei = b;}
   public String getBrauererei() {
        return brauerei;
   }
   @Override
   public String toString() {return "Bier von " + brauerei;}
}