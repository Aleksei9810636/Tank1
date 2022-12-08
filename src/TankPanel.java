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

    public void updateCollisions(Graphics g){
        int[] TankX=tank.getTankX();
        int[] TankY=tank.getTankY();
        g.setColor(new Color(198, 205, 215));
        g.fillOval(TankX[0]-5, TankY[0]-5, 10, 10);
        g.setColor(new Color(113, 166, 176));
        g.fillOval(TankX[1]-5, TankY[1]-5, 10, 10);
        g.setColor(new Color(44, 121, 121));
        g.fillOval(TankX[2]-5, TankY[2]-5, 10, 10);
        g.setColor(new Color(2, 19, 24));
        g.fillOval(TankX[3]-5, TankY[3]-5, 10, 10);
        g.setColor(new Color(252, 252, 252));            // это центр
        g.fillOval((int)(tank.x-1),(int) (tank.y-1), 2, 2);
        Polygon tank1=new Polygon(TankX, TankY, 4);
        if(tank1.intersects(wall.x, wall.y, wall.width, wall.height)){
            g.setColor(new Color(73, 248, 10));
            g.fillRect(10, 10, 1200, 20);


            if((tank.x> wall.x && tank.x<wall.x+ wall.width) && (tank.y< wall.y) ){
                  tank.y-=Math.abs(tank.vy)+1;
            }

            if((tank.x> wall.x && tank.x<wall.x+ wall.width) && (tank.y> wall.y+ wall.height) ){
                tank.y+=Math.abs(tank.vy)+1;
            }

            if((tank.y> wall.y && tank.y<wall.y+ wall.height) && (tank.x< wall.x) ){
                tank.x-=Math.abs(tank.vy)+1;
            }
            if((tank.y> wall.y && tank.y<wall.y+ wall.height) && (tank.x> wall.x+wall.width) ){
                tank.x+=Math.abs(tank.vy)+1;
            }

            g.setColor(new Color(246, 252, 69));
        }



    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        tank.UpdatePlace();
        gun.UpdatePlace();

        tank.paint(g);
        wall.paint(g);
        gun.paint(g);
        updateCollisions(g);
    }




}
