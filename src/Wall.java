import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Wall {
    double x;
    double y;
    double width;
    double height;
    Rectangle2D rectangle = new Rectangle2D.Double();

    public Wall(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        rectangle.setRect(x, y, width, height);
    }

    public void paint(Graphics g) {
        g.setColor(new Color(146, 231, 252));
        g.fillRect((int)x, (int)y, (int) width, (int) height);
    }
}
