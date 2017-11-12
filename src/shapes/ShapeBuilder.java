package shapes;

import utils.ColorAdapter;
import utils.Point;
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
            int sizex, sizey;
            sizex = Integer.parseInt(args[1]);
            sizey = Integer.parseInt(args[2]);
            return new Canvas(sizex, sizey, ColorAdapter.parseColor(args[3], Integer.parseInt(args[4])));
        } else if (shapeName.equals(ShapeType.SQUARE.text())) {
            Point start = new Point(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
            int length = Integer.parseInt(args[3]);
            return new Square(start, length,
                    ColorAdapter.parseColor(args[4], Integer.parseInt(args[5])),
                    ColorAdapter.parseColor(args[6], Integer.parseInt(args[7])));
        }
        return null;
    }
}
