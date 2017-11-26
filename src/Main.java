import shapes.ShapeBuilder;
import shapes.ShapeDrawer;
import shapes.Shape;

import javax.imageio.ImageIO;

import java.io.File;
import java.util.Scanner;

public abstract class Main {

    public static void main(final String[] args) {

        try {
            File in = new File(args[0]);
            File out = new File("drawing.png");
            Scanner sc = new Scanner(in);
            int numShapes = sc.nextInt();
            sc.nextLine();
            // store the shapes in an array to remind of the 'layered' image editing tehnique.
            Shape[] shapes = new Shape[numShapes];
            ShapeDrawer v = new ShapeDrawer();

            for (int i = 0; i < numShapes; i++) {
                // read the next line from the input and send it to the factory.
                shapes[i] = ShapeBuilder.getInstance().buildShape(sc.nextLine());
            }

            for (Shape s : shapes) {
                s.accept(v);
            }


            ImageIO.write(v.getImage(), "PNG", out);


        } catch (java.io.IOException ex) {
            ex.printStackTrace();
        }
    }
}
