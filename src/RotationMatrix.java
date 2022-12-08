public class RotationMatrix {
    double angle;
    double x;
    double y; // координаты центра вращения
    double width;
    double height;

    public RotationMatrix(double angle, double x, double y, double width, double height) {
        this.angle = angle;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public int[] coordinatesX() {
        int[] TankX=new int[]{(int)(x+width*0.5*Math.cos(angle)+height*0.5*Math.sin(angle)),
                (int)(x-width*0.5*Math.cos(angle)+height*0.5*Math.sin(angle)),
                (int)(x-width*0.5*Math.cos(angle)-height*0.5*Math.sin(angle)),
                (int)(x+width*0.5*Math.cos(angle)-height*0.5*Math.sin(angle)) };
        return TankX;
    }


}
