package s2.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
 /**
 *
 * @author s@scalingbits.com
 */
   public class SystemExitListener implements ActionListener{
      @Override
      public void actionPerformed(ActionEvent e) {
         System.exit(0);
      }
   }
