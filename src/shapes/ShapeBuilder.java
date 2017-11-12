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
        int argCount = 0;
        String shapeName = args[argCount++];
        if (shapeName.equals(ShapeType.CANVAS.text())) {
            int sizex, sizey;
            sizey = Integer.parseInt(args[argCount++]);
            sizex = Integer.parseInt(args[argCount++]);
            return new Canvas(sizex, sizey, ColorAdapter.parseColor(args[argCount++], Integer.parseInt(args[argCount++])));
        } else if (shapeName.equals(ShapeType.SQUARE.text())) {
            Point start = new Point(Integer.parseInt(args[argCount++]), Integer.parseInt(args[argCount++]));
            int length = Integer.parseInt(args[argCount++]);
            return new Square(start, length,
                    ColorAdapter.parseColor(args[argCount++], Integer.parseInt(args[argCount++])),
                    ColorAdapter.parseColor(args[argCount++], Integer.parseInt(args[argCount++])));
        } else if (shapeName.equals(ShapeType.RECTANGLE.text())) {
            Point start = new Point(Integer.parseInt(args[argCount++]), Integer.parseInt(args[argCount++]));
            int length = Integer.parseInt(args[argCount++]);
            int height = Integer.parseInt(args[argCount++]);
            return new Rectangle(start, length, height,
                    ColorAdapter.parseColor(args[argCount++], Integer.parseInt(args[argCount++])),
                    ColorAdapter.parseColor(args[argCount++], Integer.parseInt(args[argCount++])));
        } else if (shapeName.equals(ShapeType.DIAMOND.text())) {
            Point center = new Point(Integer.parseInt(args[argCount++]), Integer.parseInt(args[argCount++]));
            int length = Integer.parseInt(args[argCount++]);
            int height = Integer.parseInt(args[argCount++]);
            return new Diamond(center, length, height,
                    ColorAdapter.parseColor(args[argCount++], Integer.parseInt(args[argCount++])),
                    ColorAdapter.parseColor(args[argCount++], Integer.parseInt(args[argCount++])));
        }
        return null;
    }
}
