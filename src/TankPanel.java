import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.util.ArrayList;

public class TankPanel extends JPanel implements KeyEventDispatcher, MouseListener, MouseMotionListener {
    Tank tank1;
    Tank tank2;
    Wall wall;
    Gun gun1;
    KeyBoardGun keyBoardGun;
    boolean Push;
    double MouseX;
    double MouseY;
    Bullet bullet;
    ArrayList<Bullet> bullets= new ArrayList<>();

    public TankPanel(Tank tank1, Tank tank2, Wall wall, Gun gun, KeyBoardGun keyBoardGun ) throws IOException {       //Это вероятно не надо
        this.tank1 = tank1;
        this.wall=wall;
        this.gun1 =gun;
        this.tank2 = tank2;
        this.keyBoardGun=keyBoardGun;
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    //  Далее управление клавиатурой и мышкой




    @Override
    public void mouseClicked(MouseEvent e) {              // на отпускание
//        System.out.println("mouseClicked");
    }

    @Override
    public void mousePressed(MouseEvent e) {               //на нажатие
//        System.out.println("mousePressed");
        Bullet bullet=new Bullet(tank1.x, tank1.y, gun1.Angle, 1);
        bullets.add(bullet);

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
            System.out.println(e.getKeyCode());
            if (e.getKeyCode() == 39) {
                Bullet bullet=new Bullet(tank2.x, tank2.y, keyBoardGun.Angle, 2);
                bullets.add(bullet);
            }
            if (e.getKeyCode() == 100) {
                keyBoardGun.typeOfEvent4 = true;
            }
            if (e.getKeyCode() == 102) {
                keyBoardGun.typeOfEvent6 = true;
            }
        }
        if(e.getID() == KeyEvent.KEY_RELEASED){
            if (e.getKeyCode() == 100) {
                keyBoardGun.typeOfEvent4 = false;
            }
            if (e.getKeyCode() == 102) {
                keyBoardGun.typeOfEvent6 = false;
            }
        }

        if (e.getID() == KeyEvent.KEY_PRESSED) {
            if (e.getKeyChar() == 'w') {
                tank1.typeOfEventW = true;
            }
            if(e.getKeyChar() == 'a') {
                tank1.typeOfEventA = true;
            }
            if(e.getKeyChar() == 's') {
                tank1.typeOfEventS = true;
            }
            if(e.getKeyChar() == 'd') {
                tank1.typeOfEventD = true;
            }
            if (e.getKeyChar() == 'i') {                //////ijkl                            46   лево права дуло                 "стрелочка вправо" выстрел
                tank2.typeOfEventW = true;
            }
            if (e.getKeyChar() == 'j') {
                tank2.typeOfEventA = true;
            }
            if (e.getKeyChar() == 'k') {
                tank2.typeOfEventS = true;
            }
            if (e.getKeyChar() == 'l') {
                tank2.typeOfEventD = true;
            }
        }
        if(e.getID() == KeyEvent.KEY_RELEASED){
            if (e.getKeyChar() == 'w'){
                tank1.typeOfEventW = false;
            }
            if (e.getKeyChar() == 'a'){
                tank1.typeOfEventA = false;
            }
            if (e.getKeyChar() == 's'){
                tank1.typeOfEventS = false;
            }
            if (e.getKeyChar() == 'd'){
                tank1.typeOfEventD = false;
            }
            if (e.getKeyChar() == 'i') {
                tank2.typeOfEventW = false;
            }
            if (e.getKeyChar() == 'j') {
                tank2.typeOfEventA = false;
            }
            if (e.getKeyChar() == 'k') {
                tank2.typeOfEventS = false;
            }
            if (e.getKeyChar() == 'l') {
                tank2.typeOfEventD = false;
            }
        }
        return false;
    }








    public void updateCollisions(Graphics g){
        int[] Tank1X= tank1.getTankX();
        int[] Tank1Y= tank1.getTankY();

        int[] Tank2X= tank2.getTankX();
        int[] Tank2Y= tank2.getTankY();



        g.setColor(new Color(198, 205, 215));
        g.fillOval(Tank1X[0]-5, Tank1Y[0]-5, 10, 10);
        g.setColor(new Color(113, 166, 176));
        g.fillOval(Tank1X[1]-5, Tank1Y[1]-5, 10, 10);
        g.setColor(new Color(44, 121, 121));
        g.fillOval(Tank1X[2]-5, Tank1Y[2]-5, 10, 10);
        g.setColor(new Color(2, 19, 24));
        g.fillOval(Tank1X[3]-5, Tank1Y[3]-5, 10, 10);
        g.setColor(new Color(252, 252, 252));            // это центр
        g.fillOval((int)(tank1.x-1),(int) (tank1.y-1), 2, 2);


        Polygon tank1=new Polygon(Tank1X, Tank1Y, 4);
        if(tank1.intersects(wall.x, wall.y, wall.width, wall.height)){        //если пересекаются..

            if((this.tank1.x> wall.x && this.tank1.x<wall.x+ wall.width) && (this.tank1.y< wall.y) ){
                  this.tank1.y-=Math.abs(this.tank1.vy)+1;
            }

            if((this.tank1.x> wall.x && this.tank1.x<wall.x+ wall.width) && (this.tank1.y> wall.y+ wall.height) ){
                this.tank1.y+=Math.abs(this.tank1.vy)+1;
            }

            if((this.tank1.y> wall.y && this.tank1.y<wall.y+ wall.height) && (this.tank1.x< wall.x) ){
                this.tank1.x-=Math.abs(this.tank1.vy)+1;
            }
            if((this.tank1.y> wall.y && this.tank1.y<wall.y+ wall.height) && (this.tank1.x> wall.x+wall.width) ){
                this.tank1.x+=Math.abs(this.tank1.vy)+1;
            }
            g.setColor(new Color(55, 250, 31, 255));
            g.fillRect(10, 10, 1200, 20);
        }
    }
    public void GunAngle(){                                             ////// not tank2
        double Angle1=MouseX- tank1.x;
        double Angle2= tank1.y-MouseY;
        double angle=90-Math.toDegrees(Math.atan2(Angle2, Angle1));
        if(angle<0){
            gun1.MouseAngle=360+angle;
        } else {
            gun1.MouseAngle = angle;
        }

    }
    public void BulletList(Graphics g){
        for(Bullet bullet : bullets){ //bullets.get(i) = bullet
            bullet.paint(g);
            bullet.update();
        }

    }
    public void HitCheck() {
        int[] Tank1X = tank1.getTankX();
        int[] Tank1Y = tank1.getTankY();
        int[] Tank2X = tank2.getTankX();
        int[] Tank2Y = tank2.getTankY();
        Polygon tank2 = new Polygon(Tank2X, Tank2Y, 4);
        Polygon tank1 = new Polygon(Tank1X, Tank1Y, 4);


        for (int i = 0; i < bullets.size(); i++) {
            if (tank1.intersects(bullets.get(i).x, bullets.get(i).y, 10, 10) && bullets.get(i).IndicationTank == 2) {                   // отстойненько т.к. размер пули не читается
                this.tank1.HitPoints -= bullets.get(i).Damage;
            }
            if (tank2.intersects(bullets.get(i).x, bullets.get(i).y, 10, 10) && bullets.get(i).IndicationTank == 1) {                   // отстойненько т.к. размер пули не читается
                this.tank2.HitPoints -= bullets.get(i).Damage;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        updateCollisions(g);
        GunAngle();
        tank1.UpdatePlace();
        tank2.UpdatePlace();          ///

        gun1.UpdatePlace();
        keyBoardGun.UpdatePlace();
        BulletList(g);
        HitCheck();


        tank1.paint(g);
        tank2.paint(g);                    ///

        wall.paint(g);
        gun1.paint(g, tank1.x, tank1.y);
        keyBoardGun.paint(g, tank2.x, tank2.y);
    }



}
