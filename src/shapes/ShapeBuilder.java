package shapes;

import utils.ColorAdapter;
import utils.Point;
import utils.ShapeType;

import java.util.ArrayList;

public final class ShapeBuilder {
    private static ShapeBuilder ourInstance = new ShapeBuilder();

    public static ShapeBuilder getInstance() {
        return ourInstance;
    }

    private ShapeBuilder() {
    }

    public Shape buildShape(final String input) {
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
            int length = ezInt(args[argCount++]) - 1;

            return new Square(start, length,
                    ColorAdapter.parseColor(args[argCount++], ezInt(args[argCount++])),
                    ColorAdapter.parseColor(args[argCount++], ezInt(args[argCount])));

        } else if (shapeName.equals(ShapeType.RECTANGLE.text())) {
            Point start = new Point(ezInt(args[argCount++]), ezInt(args[argCount++]));
            int height = ezInt(args[argCount++]) - 1;
            int length = ezInt(args[argCount++]) - 1;

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

        } else if (shapeName.equals(ShapeType.TRIANGLE.text())) {
            Point p1 = new Point(ezInt(args[argCount++]), ezInt(args[argCount++]));
            Point p2 = new Point(ezInt(args[argCount++]), ezInt(args[argCount++]));
            Point p3 = new Point(ezInt(args[argCount++]), ezInt(args[argCount++]));

            return new Triangle(p1, p2, p3,
                    ColorAdapter.parseColor(args[argCount++], ezInt(args[argCount++])),
                    ColorAdapter.parseColor(args[argCount++], ezInt(args[argCount])));

        } else if (shapeName.equals(ShapeType.POLYGON.text())) {
            int num = ezInt(args[argCount++]);
            ArrayList<Point> pts = new ArrayList<>(num);
            for (int k = 0; k < num; k++) {
                pts.add(new Point(ezInt(args[argCount++]), ezInt(args[argCount++])));
            }

            return new Polygon(num, pts,
                    ColorAdapter.parseColor(args[argCount++], ezInt(args[argCount++])),
                    ColorAdapter.parseColor(args[argCount++], ezInt(args[argCount])));

        } else if (shapeName.equals(ShapeType.CIRCLE.text())) {
            Point center = new Point(ezInt(args[argCount++]), ezInt(args[argCount++]));
            int radius = ezInt(args[argCount++]);

            return new Circle(center, radius,
                    ColorAdapter.parseColor(args[argCount++], ezInt(args[argCount++])),
                    ColorAdapter.parseColor(args[argCount++], ezInt(args[argCount])));
        }

        return null;
    }

    /**
     * Function used locally to reduce the footprint of Integer.parseInt(String).
     *
     * @param s input string
     * @return parsed integer
     */
    private static int ezInt(final String s) {
        return Integer.parseInt(s);
    }
}
