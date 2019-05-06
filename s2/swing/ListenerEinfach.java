package s2.swing;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
 
public class ListenerEinfach extends MouseAdapter{
    @Override public void mouseClicked(MouseEvent mEvent) {
        System.out.println("MouseClick wurde auf Position ["
                + mEvent.getX() + ","
                + mEvent.getY() + "] "
                + mEvent.getClickCount() + " mal geklickt");
    }
}
