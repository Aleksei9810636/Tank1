import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Gun extends  GameObject{
    public Gun(double x, double y, double VMax, double a) throws IOException {
        super(x, y, VMax, a);
        image= ImageIO.read(new File("imgs\\gun.png"));
    }
    double vy;
    double angle;

//    public void paint(Graphics g) {
//        BufferedImage img1=rotateImage(img, angle);
//        Graphics2D g2d = (Graphics2D) g;
//        g2d.drawImage(img1, (int) (x-img1.getWidth()*0.5), (int) (y-img1.getHeight()*0.5), null);
//    }
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
}
