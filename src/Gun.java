import java.awt.*;
import java.io.IOException;

public class Gun extends  GameObject{
    public Gun(double x, double y, double VMax, double a) throws IOException {
        super(x, y, VMax, a);
    }
    public  void paint(Graphics g){
        g.fillRect((int) (x+img.getWidth()*0.5), (int) (y+img.getHeight()*0.5), 20, 20) ;
    }
}
