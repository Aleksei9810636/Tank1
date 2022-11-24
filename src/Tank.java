import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Tank {
    double x;
    double y;
    double vx;
    double vy;
    double VMax;
    double a;
    String typeOfEventW;
    String typeOfEventA;
    String typeOfEventS;
    String typeOfEventD;
    BufferedImage image;
    long time;
    long dt;

    public Tank(double x, double y, double VMax, double a) throws IOException {
        this.x = x;
        this.y = y;
        this.VMax = VMax;
        this.a = a;
        image = ImageIO.read(new File("imgs\\Tank1.jpg"));
    }

    public void paint(Graphics g) {
        g.drawImage(image, (int) x, (int) y, image.getWidth(), image.getHeight(), null);
    }

    public void UpdetePlace() {
        dt = System.currentTimeMillis() - time;     // Пачему  не работает время?
        x = vx * dt;
        y = vy*dt;

        if (typeOfEventW == "typed") {
            vx += 0.1;
        } else {
            if (vx > 0) {
                vx -= a * dt;
            }
            if (vx < 0) {
                vx += a * dt;
            }

            time = System.currentTimeMillis();
        }

    }
}
