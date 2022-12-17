import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.util.ArrayList;

public class TankPanel extends JPanel implements KeyEventDispatcher, MouseListener, MouseMotionListener {
    Tank tank;
    Wall wall;
    Gun gun;
    boolean Push;
    double MouseX;
    double MouseY;
    Bullet bullet;

    public TankPanel(Tank tank, Wall wall, Gun gun) throws IOException {       //Это вероятно не надо
        this.tank=tank;
        this.wall=wall;
        this.gun=gun;
        addMouseListener(this);
        addMouseMotionListener(this);
        bullet =new Bullet(tank.x, tank.y);
    }

    //  Далее управление клавиатурой и мышкой




    @Override
    public void mouseClicked(MouseEvent e) {              // на отпускание
//        System.out.println("mouseClicked");
    }

    @Override
    public void mousePressed(MouseEvent e) {               //на нажатие
//        System.out.println("mousePressed");
        bullet.i=1;

    }

    @Override
    public void mouseReleased(MouseEvent e) {              // хз что но похоже на отпускание
//       System.out.println("mouseReleased");
    }

    @Override
    public void mouseEntered(MouseEvent e) {                //видимо когда наводим на панель
        //       System.out.println("mouseEntered");
    }

    @Override
    public void mouseExited(MouseEvent e) {                 //видимо конда уводим с панели
//        System.out.println("mouseExited");
    }

    @Override
    public void mouseDragged(MouseEvent e) {           //движется и зажата
    }

    @Override
    public void mouseMoved(MouseEvent e) {             // движется и не зажата
        MouseX=e.getX();
        MouseY=e.getY();
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {

        if (e.getID() == KeyEvent.KEY_PRESSED) {
            if (e.getKeyChar() == 'w') {
                tank.typeOfEventW = true;
            }
            if(e.getKeyChar() == 'a') {
                tank.typeOfEventA = true;
            }
            if(e.getKeyChar() == 's') {
                tank.typeOfEventS = true;
            }
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
        if(tank1.intersects(wall.x, wall.y, wall.width, wall.height)){        //если пересекаются..

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
            g.setColor(new Color(55, 250, 31, 255));
            g.fillRect(10, 10, 1200, 20);
        }
    }
    public void GunAngle(){
        double Angle1=MouseX- tank.x;
        double Angle2=tank.y-MouseY;
        double angle=90-Math.toDegrees(Math.atan2(Angle2, Angle1));
        if(angle<0){
            gun.MouseAngle=360+angle;
        } else {
            gun.MouseAngle = angle;
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        updateCollisions(g);
        GunAngle();
        tank.UpdatePlace();
        gun.UpdatePlace();

        tank.paint(g);
        wall.paint(g);
        gun.paint(g, tank.x, tank.y);
        bullet.point(g);
    }



}
