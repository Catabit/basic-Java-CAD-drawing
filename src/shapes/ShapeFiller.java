package shapes;

import utils.Point;

import java.awt.image.BufferedImage;

public final class ShapeFiller {
    private ShapeFiller() {
    }

    public static void fill(final BufferedImage base, final Rectangle r) {
        Point lt, rt, lb, rb;
        lt = r.getStart();
        rt = new Point(r.getStart().x() + r.getLength(), r.getStart().y());
        lb = new Point(r.getStart().x(), r.getStart().y() + r.getHeight());
        rb = new Point(r.getStart().x() + r.getLength(), r.getStart().y() + r.getHeight());

        for (int x = lt.x() + 1; x < rt.x(); x++) {
            for (int y = lt.y() + 1; y < lb.y(); y++) {
                base.setRGB(x, y, r.getInnerColor().getRGB());
            }
        }
    }


    public static void fill(final BufferedImage base, final Square s) {
        Point lt, rt, lb, rb;
        lt = s.getStart();
        rt = new Point(s.getStart().x() + s.getLength(), s.getStart().y());
        lb = new Point(s.getStart().x(), s.getStart().y() + s.getLength());
        rb = new Point(s.getStart().x() + s.getLength(), s.getStart().y() + s.getLength());

        for (int x = lt.x() + 1; x < rt.x(); x++) {
            for (int y = lt.y() + 1; y < lb.y(); y++) {
                base.setRGB(x, y, s.getInnerColor().getRGB());
            }
        }
    }
}

