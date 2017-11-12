import shapes.*;

import javax.imageio.ImageIO;
import java.io.File;

public abstract class Main {

    public static void main(final String[] args) {


        ShapeDrawer v = new ShapeDrawer();
        Shape[] shapes = new Shape[4];
        shapes[0] = ShapeBuilder.getInstance().buildShape("CANVAS 600 1000 #000000 255");
        shapes[1] = ShapeBuilder.getInstance().buildShape("SQUARE 50 50 50 #FF0000 255 #00FF00 255");
        shapes[2] = ShapeBuilder.getInstance().buildShape("SQUARE 300 300 150 #0000FF 255 #00FF00 255");
        shapes[3] = ShapeBuilder.getInstance().buildShape("SQUARE 350 325 200 #FFFF00 255 #FF1188 255");

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
