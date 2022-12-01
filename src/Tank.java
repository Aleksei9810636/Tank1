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
}

