import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Tank extends GameObject {


    public Tank(double x, double y, double VMax, double a) throws IOException {
        super(x, y, VMax, a);
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
        int[] TankX=new int[]{(int)(x+image.getWidth()*0.5*Math.cos(angle)+image.getHeight()*0.5*Math.sin(angle)),
                (int)(x-image.getWidth()*0.5*Math.cos(angle)+image.getHeight()*0.5*Math.sin(angle)),
                (int)(x-image.getWidth()*0.5*Math.cos(angle)-image.getHeight()*0.5*Math.sin(angle)),
                (int)(x+image.getWidth()*0.5*Math.cos(angle)-image.getHeight()*0.5*Math.sin(angle)) };
        return TankX;
    }
    public int[] getTankY() {
        int[] TankY=new int[]{(int)(y+image.getWidth()*0.5*Math.sin(angle)+image.getHeight()*0.5*Math.cos(angle)),
                (int)(y-image.getWidth()*0.5*Math.sin(angle)+image.getHeight()*0.5*Math.cos(angle)),
                (int)(y-image.getWidth()*0.5*Math.sin(angle)-image.getHeight()*0.5*Math.cos(angle)),
                (int)(y-image.getWidth()*0.5*Math.sin(angle)-image.getHeight()*0.5*Math.cos(angle)) };        // тут может быть лажа
        return TankY;
    }




}

