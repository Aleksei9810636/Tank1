import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameObject {
        public static BufferedImage rotateImage(BufferedImage img, double angle) {
            double sin = Math.abs(Math.sin(Math.toRadians(angle))),
                    cos = Math.abs(Math.cos(Math.toRadians(angle)));
            int w = img.getWidth();
            int h = img.getHeight();
            int newW = (int) Math.floor(w*cos + h*sin);
            int newH = (int) Math.floor(h*cos + w*sin);
            BufferedImage rotated = new BufferedImage(newW, newH, BufferedImage.TYPE_4BYTE_ABGR);
            Graphics2D g = rotated.createGraphics();
//        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            g.translate((newW-w)/2, (newH-h)/2);
            g.rotate(Math.toRadians(angle), w/2.0, h/2.0);
            g.drawRenderedImage(img, null);
            g.dispose();
            return rotated;
        }       // Оно поварачивает картинку



    }

