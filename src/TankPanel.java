import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
public class TankPanel extends JPanel implements KeyEventDispatcher  {
    Tank tank;
    Wall wall;
    Gun gun;
    boolean Push;

    public TankPanel(Tank tank, Wall wall, Gun gun) throws IOException {       //Это вероятно не надо
        this.tank=tank;
        this.wall=wall;
        this.gun=gun;

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

    public void updateCollisions(){
//        if ( (tank.x > wall.x)&&(tank.x<(wall.x+ wall.width-tank.img.getWidth()))              )

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        tank.UpdatePlace();
        updateCollisions();

        tank.paint(g);
        wall.paint(g);
        gun.paint(g);
        gun.UpdatePlace();
    }




}
