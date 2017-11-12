import shapes.*;

import javax.imageio.ImageIO;
import java.io.File;

public abstract class Main {

    public static void main(final String[] args) {


        ShapeDrawer v = new ShapeDrawer();
        Shape[] shapes = new Shape[9];
        shapes[0] = ShapeBuilder.getInstance().buildShape("CANVAS 600 1000 #000000 255");
        shapes[1] = ShapeBuilder.getInstance().buildShape("SQUARE 50 50 50 #FF0000 255 #00FF00 255");
        shapes[2] = ShapeBuilder.getInstance().buildShape("SQUARE 100 300 150 #0000FF 255 #00FF00 255");
        shapes[3] = ShapeBuilder.getInstance().buildShape("SQUARE 150 325 200 #FFFF00 255 #FF1188 255");
        shapes[4] = ShapeBuilder.getInstance().buildShape("RECTANGLE 700 100 75 350 #00FFFF 255 #FF00FF 255");
        shapes[5] = ShapeBuilder.getInstance().buildShape("SQUARE 600 350 100 #FF0000 255 #00FF00 255");
        shapes[6] = ShapeBuilder.getInstance().buildShape("SQUARE 775 350 100 #FF0000 255 #00FF00 255");
        shapes[7] = ShapeBuilder.getInstance().buildShape("DIAMOND 450 250 56 154 #FF0000 255 #00FF00 255");
        shapes[8] = ShapeBuilder.getInstance().buildShape("LINE 200 240 850 325 #FFFF85 255");
        for (Shape s : shapes) {
            s.accept(v);
        }


        File f = new File("drawing.png");
        try {
            ImageIO.write(v.getImage(), "PNG", f);
        } catch (java.io.IOException ex) {
            ex.printStackTrace();
        }
    }
}
