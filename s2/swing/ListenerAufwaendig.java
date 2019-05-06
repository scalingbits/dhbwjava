package s2.swing;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
 
/**
 *
 * @author s@scalingbits.com
 */
public class ListenerAufwaendig implements MouseListener{
    @Override public void mouseClicked(MouseEvent mEvent) {
        System.out.println("MouseClick wurde auf Position ["
                + mEvent.getX() + ","
                + mEvent.getY() + "] "
                + mEvent.getClickCount() + " mal geklickt");
    }
    @Override public void mouseEntered(MouseEvent mEvent) 
        { /* leere Implementierung, erzwungen */ }
    @Override public void mouseExited(MouseEvent mEvent) 
        { /* leere Implementierung, erzwungen */ }
    @Override public void mousePressed(MouseEvent mEvent)
        { /* leere Implementierung, erzwungen */ }
    @Override public void mouseReleased(MouseEvent mEvent)
     { /* leere Implementierung, erzwungen */ }
}