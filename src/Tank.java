import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Tank {
    double x;
    double y;
    double VAngle;
    double vy;
    double VMax;
    double a;
    boolean typeOfEventW;
    boolean typeOfEventA;
    boolean typeOfEventS;
    boolean typeOfEventD;
    BufferedImage image;
    double angle=0.0;


    public Tank(double x, double y, double VMax, double a) throws IOException {
        this.x = x;
        this.y = y;
        this.VAngle=0;
        this.vy=0;
        this.VMax = VMax;
        this.a = a;
        image = ImageIO.read(new File("imgs\\Tank1.jpg"));
    }

    public void paint(Graphics g) {
        BufferedImage img=rotateImage(image, angle);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(img, (int) (x-img.getWidth()*0.5), (int) (y-img.getHeight()*0.5), null);
        System.out.println(x + "           " + y);
    }

    public static BufferedImage rotateImage(BufferedImage img, double angle) {
        double sin = Math.abs(Math.sin(Math.toRadians(angle))),
                cos = Math.abs(Math.cos(Math.toRadians(angle)));
        int w = img.getWidth();
        int h = img.getHeight();
        int newW = (int) Math.floor(w*cos + h*sin);
        int newH = (int) Math.floor(h*cos + w*sin);
        BufferedImage rotated = new BufferedImage(newW, newH, BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D g = rotated.createGraphics();
//        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g.translate((newW-w)/2, (newH-h)/2);
        g.rotate(Math.toRadians(angle), w/2.0, h/2.0);
        g.drawRenderedImage(img, null);
        g.dispose();
        return rotated;
    }       // Оно поварачивает картинку

    public void UpdatePlace(){
        double angleInRadians = Math.toRadians(angle);
        x += vy * Math.sin(angleInRadians);
        y -= vy * Math.cos(angleInRadians);
        angle+=VAngle*0.5;

        if (typeOfEventW != typeOfEventS) {
            if ((Math.abs(vy)) < VMax) {
                if (typeOfEventW){
                    vy = vy + a;
                }else {
                    vy = vy - a;
                }
            }
        }
        else {
            if(Math.abs(vy)<=a){
                vy=0;
            }else {
                vy = vy - Math.signum(vy) * a;
            }
        }


        if (typeOfEventA != typeOfEventD) {
            if ((Math.abs(VAngle)) < VMax) {
                if (typeOfEventA){
                    VAngle -= a;
                }else {
                    VAngle += a;
                }
            }
        }
        else {
            if(Math.abs(VAngle)<=a){
                VAngle=0;
            }else {
                VAngle -= Math.signum(VAngle) * a;
            }
        }



    }



}

