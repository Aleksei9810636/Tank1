
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

