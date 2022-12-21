import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class KeyBoardGun extends GameObject {

        double VAngle;
        double Angle;
        boolean typeOfEvent4;
        boolean typeOfEvent6;
        BufferedImage image= ImageIO.read(new File("imgs\\gun.png"));

    public KeyBoardGun(double VAngle) throws IOException {
        this.VAngle = VAngle;
    }

    public void paint(Graphics g, double x, double y) {
            BufferedImage img=rotateImage(image, Angle);
            g.drawImage(img, (int) (x-img.getWidth()*0.5), (int) (y-img.getHeight()*0.5), null);
        }
        public void UpdatePlace(){
        if(typeOfEvent4){
            Angle-=VAngle;
        }
        if(typeOfEvent6){
            Angle+=VAngle;
        }
        }

    }


