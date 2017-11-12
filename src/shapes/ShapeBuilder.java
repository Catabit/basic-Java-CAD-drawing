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
            sizey = ezInt(args[argCount++]);
            sizex = ezInt(args[argCount++]);
            return new Canvas(sizex, sizey,
                    ColorAdapter.parseColor(args[argCount++], ezInt(args[argCount])));
        } else if (shapeName.equals(ShapeType.SQUARE.text())) {
            Point start = new Point(ezInt(args[argCount++]), ezInt(args[argCount++]));
            int length = ezInt(args[argCount++]);
            return new Square(start, length,
                    ColorAdapter.parseColor(args[argCount++], ezInt(args[argCount++])),
                    ColorAdapter.parseColor(args[argCount++], ezInt(args[argCount])));
        } else if (shapeName.equals(ShapeType.RECTANGLE.text())) {
            Point start = new Point(ezInt(args[argCount++]), ezInt(args[argCount++]));
            int length = ezInt(args[argCount++]);
            int height = ezInt(args[argCount++]);
            return new Rectangle(start, length, height,
                    ColorAdapter.parseColor(args[argCount++], ezInt(args[argCount++])),
                    ColorAdapter.parseColor(args[argCount++], ezInt(args[argCount])));
        } else if (shapeName.equals(ShapeType.DIAMOND.text())) {
            Point center = new Point(ezInt(args[argCount++]), ezInt(args[argCount++]));
            int length = ezInt(args[argCount++]);
            int height = ezInt(args[argCount++]);
            return new Diamond(center, length, height,
                    ColorAdapter.parseColor(args[argCount++], ezInt(args[argCount++])),
                    ColorAdapter.parseColor(args[argCount++], ezInt(args[argCount])));
        } else if (shapeName.equals(ShapeType.LINE.text())) {
            Point start = new Point(ezInt(args[argCount++]), ezInt(args[argCount++]));
            Point end = new Point(ezInt(args[argCount++]), ezInt(args[argCount++]));
            return new Line(start, end,
                    ColorAdapter.parseColor(args[argCount++], ezInt(args[argCount])));
        }
        return null;
    }

    private static int ezInt(final String s) {
        return Integer.parseInt(s);
    }
}
