import java.awt.*;

public class Bullet {
    double x;
    double y;
    double Angle;
    double v=8;
    double Damage=2;
    int IndicationTank;

    public Bullet(double x, double y, double GunAngle, int IndicationTank) {
        this.x = x;
        this.y = y;
        this.Angle=GunAngle;
        this.IndicationTank=IndicationTank; // какой танк выстрелил
    }

    public void paint(Graphics g) {
        g.setColor(new Color(55, 250, 31, 255));
        g.fillOval((int) x, (int) y, 10, 10);
    }
    public boolean update() {
        x+=v*Math.sin(Math.toRadians(Angle));
        y-=v*Math.cos(Math.toRadians(Angle));
        if(x<-10||x>3000||y<-10||y>2000){
            return false;
        }
        return true;

    }

}
