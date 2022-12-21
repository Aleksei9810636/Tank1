
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Tank extends GameObject {
    double x;
    double y;
    double VAngle;
    double vy;
    double VMax;
    double a;
    double angle=0.0;
    double HitPoints;
    double laja;


    BufferedImage image= ImageIO.read(new File("imgs\\Tank1.jpg"));
    boolean typeOfEventW;
    boolean typeOfEventA;
    boolean typeOfEventS;
    boolean typeOfEventD;

    public void paint(Graphics g) {
        BufferedImage img=rotateImage(image, angle);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(img, (int) (x-img.getWidth()*0.5), (int) (y-img.getHeight()*0.5), null);
        g.setColor(new Color(75, 68, 68));
        g.drawRect( (int)laja, 900, 900, 10);
        g.setColor(new Color(238, 12, 12));
        g.fillRect( (int)laja, 900,(int) HitPoints, 10);
        if(HitPoints<=0){
            g.setColor(new Color(0, 224, 205));
            g.fillRect(0,0,2000,2000);
        }
    }
    public Tank(double x, double y, double VMax, double a, double HitPoints, double laja) throws IOException {
        this.x = x;
        this.y = y;
        this.VAngle=0;
        this.vy=0;
        this.VMax = VMax;
        this.a = a;
        this.HitPoints=HitPoints;
        this.laja=laja;

    }


                 // если что х и у это координаты центра танка

    public void UpdatePlace() {
        double angleInRadians = Math.toRadians(angle);
        x += vy * Math.sin(angleInRadians);
        y -= vy * Math.cos(angleInRadians);
        angle += VAngle * 1;
        if (typeOfEventW != typeOfEventS) {
            if ((Math.abs(vy)) < VMax) {
                if (typeOfEventW) {
                    vy = vy + a;
                } else {
                    vy = vy - a;
                }
            }
        } else {
            if (Math.abs(vy) <= a) {
                vy = 0;
            } else {
                vy = vy - Math.signum(vy) * a;
            }
        }


        if (typeOfEventA != typeOfEventD) {
            if ((Math.abs(VAngle)) < VMax) {
                if (typeOfEventA) {
                    VAngle -= a;
                } else {
                    VAngle += a;
                }
            }
        } else {
            if (Math.abs(VAngle) <= a) {
                VAngle = 0;
            } else {
                VAngle -= Math.signum(VAngle) * a;
            }
        }

    }

    public int[] getTankX() {
        int w = image.getWidth();
        int h = image.getWidth();
        double s = Math.sin(Math.toRadians(angle));
        double c = Math.cos(Math.toRadians(angle));
        int[] TankX=new int[]{
                (int)(x+w*0.5*c+h*0.5*s),
                (int)(x-w*0.5*c+h*0.5*s),
                (int)(x-w*0.5*c-h*0.5*s),
                (int)(x+w*0.5*c-h*0.5*s) };
        return TankX;
    }
    public int[] getTankY() {
        int w = image.getWidth();
        int h = image.getWidth();
        double s = Math.sin(Math.toRadians(angle));
        double c = Math.cos(Math.toRadians(angle));
        int[] TankY=new int[]{
                (int)(y+w*0.5*s-h*0.5*c),
                (int)(y-w*0.5*s-h*0.5*c),
                (int)(y-w*0.5*s+h*0.5*c),
                (int)(y+w*0.5*s+h*0.5*c),
        };        // тут может быть лажа
        return TankY;
    }




}

