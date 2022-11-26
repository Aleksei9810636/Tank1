import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
public class TankPanel extends JPanel implements KeyEventDispatcher  {
    Tank tank;

    public TankPanel(Tank tank) throws IOException {       //Это вероятно не надо
        this.tank=tank;
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {

        if (e.getID() == KeyEvent.KEY_PRESSED) {
            if (e.getKeyChar() == 'w')
                tank.typeOfEventW = true;
            if(e.getKeyChar() == 'a')
                tank.typeOfEventA = true;
            if(e.getKeyChar() == 's')
                tank.typeOfEventS = true;
            if(e.getKeyChar() == 'd')
                tank.typeOfEventD = true;
        }
        if(e.getID() == KeyEvent.KEY_RELEASED){
            if (e.getKeyChar() == 'w'){
                tank.typeOfEventW = false;
            }
            if (e.getKeyChar() == 'a'){
                tank.typeOfEventA = false;
            }
            if (e.getKeyChar() == 's'){
                tank.typeOfEventS = false;
            }
            if (e.getKeyChar() == 'd'){
                tank.typeOfEventD = false;
            }
        }



        return false;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        tank.paint(g);
        tank.UpdatePlace();
    }



}
