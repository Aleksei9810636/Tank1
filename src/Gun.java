import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Gun extends  GameObject{
    double VAngle;
    double Angle;
    double MouseAngle;
    BufferedImage image= ImageIO.read(new File("imgs\\gun.png"));
    public Gun(double VAngle) throws IOException {
        this.VAngle=VAngle;
    }

    public void paint(Graphics g, double x,double y) {
        BufferedImage img=rotateImage(image, Angle);
        g.drawImage(img, (int) (x-img.getWidth()*0.5), (int) (y-img.getHeight()*0.5), null);
    }
    public void UpdatePlace(){
        System.out.println(Angle);
        System.out.println(MouseAngle);
        if(MouseAngle>Angle){
            if(MouseAngle-Angle<=180){
                Angle+=VAngle;
                System.out.println(1);
            } else {
                Angle-=VAngle;
                System.out.println(2);
            }
        }
        if(MouseAngle<Angle){
            if(Angle-MouseAngle<180){
                Angle-=VAngle;
                System.out.println(3);
            } else {
                Angle+=VAngle;
                System.out.println(4);
            }
        }
        if(Angle<0){ // эти два ифа добавлены в связи с багом. если изначально мышь слево, то происходито баг, а так все норм. Если что, можно просто сделать кнопку входа справо.
            Angle+=360;
        }
        if(Angle>360){
            Angle-=360;
        }

    }

}
