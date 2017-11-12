package shapes;

import utils.Color;
import utils.ShapeType;

public final class ShapeBuilder {
    private static ShapeBuilder ourInstance = new ShapeBuilder();

    public static ShapeBuilder getInstance() {
        return ourInstance;
    }

    private ShapeBuilder() {
    }

    public Shape buildShape(final String input) { //todo add all the shape construction here
        String[] args = input.split(" ");
        String shapeName = args[0];
        if (shapeName.equals(ShapeType.CANVAS.text())) {
            int sizex, sizey, alpha;
            sizex = Integer.parseInt(args[1]);
            sizey = Integer.parseInt(args[2]);
            return new Canvas(sizex, sizey, new Color(args[3], Integer.parseInt(args[4])));
        } else if (shapeName.equals(ShapeType.CIRCLE.text())) {
            System.out.println("SHOULD BE A CIRCLE");
        }
        return null;
    }
}
