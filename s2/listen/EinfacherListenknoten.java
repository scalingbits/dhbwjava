package s2.listen;
/**
 *
 * @author s@scalingbits.com
 */
public interface EinfacherListenknoten {
    /**
     * Einfuegen eines Nachfolgers
     * @param n einzufuegender Listenknoten
     */
   public void setNachFolger(EinfacherListenknoten n);
   /**
    * Auslesen des Nachfolgers
    * @return der Nachfolger
    */
   public EinfacherListenknoten getNachfolger();
}


