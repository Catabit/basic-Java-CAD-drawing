import shapes.*;

import javax.imageio.ImageIO;

import java.io.File;
import java.util.Scanner;

public abstract class Main {

    public static void main(final String[] args) {

        try {
            File in = new File(args[0]);
            File f = new File("drawing.png");
            Scanner sc = new Scanner(in);
            int numShapes = sc.nextInt();
            sc.nextLine();
            Shape[] shapes = new Shape[numShapes];
            ShapeDrawer v = new ShapeDrawer();

            for (int i = 0; i < numShapes; i++) {
                shapes[i] = ShapeBuilder.getInstance().buildShape(sc.nextLine());
            }

            for (Shape s : shapes) {
                s.accept(v);
            }


            ImageIO.write(v.getImage(), "PNG", f);


        } catch (java.io.IOException ex) {
            ex.printStackTrace();
        }
    }
}
