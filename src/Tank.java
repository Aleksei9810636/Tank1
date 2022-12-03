import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Tank extends  GameObject {


    public Tank(double x, double y, double VMax, double a) throws IOException {
        super(x, y, VMax, a);
    }
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

//    boolean isPolygonsIntersecting(Polygon a, Polygon b) {
//        for (int x=0; x<2; x++)
//        {
//            Polygon polygon = (x==0) ? a : b;
//
//            for (int i1=0; i1<polygon.getPoints().length; i1++)
//            {
//                int   i2 = (i1 + 1) % polygon.getPoints().length;
//                Point p1 = polygon.getPoints()[i1];
//                Point p2 = polygon.getPoints()[i2];
//
//                Point normal = new Point(p2.y - p1.y, p1.x - p2.x);
//
//                double minA = Double.POSITIVE_INFINITY;
//                double maxA = Double.NEGATIVE_INFINITY;
//
//                for (Point p : a.getPoints())
//                {
//                    double projected = normal.x * p.x + normal.y * p.y;
//
//                    if (projected < minA)
//                        minA = projected;
//                    if (projected > maxA)
//                        maxA = projected;
//                }
//
//                double minB = Double.POSITIVE_INFINITY;
//                double maxB = Double.NEGATIVE_INFINITY;
//
//                for (Point p : b.getPoints())
//                {
//                    double projected = normal.x * p.x + normal.y * p.y;
//
//                    if (projected < minB)
//                        minB = projected;
//                    if (projected > maxB)
//                        maxB = projected;
//                }
//
//                if (maxA < minB || maxB < minA)
//                    return false;
//            }
//        }
//
//        return true;
//    }
}

