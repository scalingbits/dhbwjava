package s2.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
 /**
 *
 * @author s@scalingbits.com
 */
   public class SystemExitListener implements ActionListener{
      @Override
      /**
       * Diese Methode führt eine Aktion aus. Sie beendet die Anwendung!
       * @param args die EIngabeparamter werden ignoriert
       */
      public void actionPerformed(ActionEvent e) {
         System.exit(0);
      }
   }
