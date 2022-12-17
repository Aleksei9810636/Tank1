import java.awt.*;

public class Bullet {
    double x;
    double y;
    double v=8;
    int i=0;

    public Bullet(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void point(Graphics g) {
        if(i==1) {
            g.setColor(new Color(55, 250, 31, 255));
            g.fillRect((int) x, 100, 30, 10);
            x += v;
        }
        if(x>1600){
            i=0;
            x=100;
        }
    }
}
