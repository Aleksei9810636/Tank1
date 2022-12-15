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

    public void paint(Graphics g, double x,double y) {
        BufferedImage img1=rotateImage(img, angle);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(img1, (int) (x-img1.getWidth()*0.5), (int) (y-img1.getHeight()*0.5), null);
    }

}
