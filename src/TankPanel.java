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

        if (e.getID() == KeyEvent.KEY_TYPED) {
            if(e.getKeyChar() == 'w')
                tank.typeOfEventW = "typed";
            if(e.getKeyChar() == 'a')
                tank.typeOfEventA = "typed";
            if(e.getKeyChar() == 's')
                tank.typeOfEventS = "typed";
            if(e.getKeyChar() == 'd')
                tank.typeOfEventD = "typed";
        }



        return false;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        tank.paint(g);
        tank.UpdetePlace();
    }



}
