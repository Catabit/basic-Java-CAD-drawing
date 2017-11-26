package shapes;

import utils.LineDrawer;
import utils.PixelColor;
import utils.Point;
import utils.ShapeFiller;
import java.awt.Color;
import java.awt.image.BufferedImage;

public final class ShapeDrawer implements Visitor {

    private BufferedImage base;

    @Override
    public void visit(final Canvas s) {
        // the CANVAS shape will reinitialize the base raster
        // and fill it with the given background color
        base = new BufferedImage(s.getSizeX(), s.getSizeY(), BufferedImage.TYPE_INT_ARGB);
        for (int i = 0; i < s.getSizeX(); i++) {
            for (int j = 0; j < s.getSizeY(); j++) {
                base.setRGB(i, j, s.getBackground().getRGB());
            }
        }
    }

    @Override
    public void visit(final Square s) {
        Point lt, rt, lb, rb;
        lt = s.getStart();
        rt = new Point(s.getStart().x() + s.getLength(), s.getStart().y());
        lb = new Point(s.getStart().x(), s.getStart().y() + s.getLength());
        rb = new Point(s.getStart().x() + s.getLength(), s.getStart().y() + s.getLength());

        LineDrawer.drawLine(base, lt, rt, s.getBorderColor());
        LineDrawer.drawLine(base, rt, rb, s.getBorderColor());
        LineDrawer.drawLine(base, lb, rb, s.getBorderColor());
        LineDrawer.drawLine(base, lb, lt, s.getBorderColor());

        ShapeFiller.fill(base, s);
    }

    @Override
    public void visit(final Rectangle r) {
        Point lt, rt, lb, rb;
        lt = r.getStart();
        rt = new Point(r.getStart().x() + r.getLength(), r.getStart().y());
        lb = new Point(r.getStart().x(), r.getStart().y() + r.getHeight());
        rb = new Point(r.getStart().x() + r.getLength(), r.getStart().y() + r.getHeight());

        LineDrawer.drawLine(base, lt, rt, r.getBorderColor());
        LineDrawer.drawLine(base, rt, rb, r.getBorderColor());
        LineDrawer.drawLine(base, lb, rb, r.getBorderColor());
        LineDrawer.drawLine(base, lb, lt, r.getBorderColor());

        ShapeFiller.fill(base, r);
    }

    @Override
    public void visit(final Line s) {
        LineDrawer.drawLine(base, s.getStart(), s.getEnd(), s.getBorderColor());
    }

    @Override
    public void visit(final Diamond s) {
        Point t, r, l, b;
        t = s.getCenter().getOffset(0, s.getHeight() / 2);
        b = s.getCenter().getOffset(0, -s.getHeight() / 2);
        l = s.getCenter().getOffset(-s.getLength() / 2, 0);
        r = s.getCenter().getOffset(s.getLength() / 2, 0);
        //the int/2 does not require any rounding (i.e. 5/2 = 2 )

        LineDrawer.drawLine(base, l, t, s.getBorderColor());
        LineDrawer.drawLine(base, t, r, s.getBorderColor());
        LineDrawer.drawLine(base, r, b, s.getBorderColor());
        LineDrawer.drawLine(base, b, l, s.getBorderColor());

        ShapeFiller.floodFill(base, s.getCenter().x(), s.getCenter().y(),
                s.getBorderColor().getRGB(), s.getInnerColor());
    }

    @Override
    public void visit(final Triangle s) {
        final int divider = 3;
        LineDrawer.drawLine(base, s.getP1(), s.getP2(), s.getBorderColor());
        LineDrawer.drawLine(base, s.getP2(), s.getP3(), s.getBorderColor());
        LineDrawer.drawLine(base, s.getP3(), s.getP1(), s.getBorderColor());
        int x = (s.getP1().x() + s.getP2().x() + s.getP3().x()) / divider;
        int y = (s.getP1().y() + s.getP2().y() + s.getP3().y()) / divider;
        ShapeFiller.floodFill(base, x, y, s.getBorderColor().getRGB(), s.getInnerColor());

    }

    @Override
    public void visit(final Polygon s) {
        int x = 0, y = 0; // the fill center position
        for (int i = 0; i < s.getNumPoints() - 1; i++) {
            Point p1 = s.getPoints().get(i);
            Point p2 = s.getPoints().get(i + 1);
            x += p1.x();
            y += p1.y();
            LineDrawer.drawLine(base, p1, p2, s.getBorderColor());
        }
        LineDrawer.drawLine(base, s.getPoints().get(s.getNumPoints() - 1), s.getPoints().get(0),
                s.getBorderColor()); // line between the last and first point

        x += s.getPoints().get(s.getNumPoints() - 1).x();
        y += s.getPoints().get(s.getNumPoints() - 1).y();
        x /= s.getNumPoints();
        y /= s.getNumPoints();

        ShapeFiller.floodFill(base, x, y, s.getBorderColor().getRGB(), s.getInnerColor());
    }

    @Override
    public void visit(final Circle s) {
        int xc = s.getCenter().x();
        int yc = s.getCenter().y();
        int r = s.getRadius();
        int x = 0, y = r;
        int d = 3 - 2 * r;
        while (y >= x) {
            // for each pixel we will
            // draw all eight pixels
            drawCircle(xc, yc, x, y, s.getBorderColor());
            x++;

            // check for decision parameter
            // and correspondingly
            // update d, x, y
            if (d > 0) {
                y--;
                d = d + 4 * (x - y) + 10;
            } else {
                d = d + 4 * x + 6;
            }
            drawCircle(xc, yc, x, y, s.getBorderColor());
        }

        ShapeFiller.floodFill(base, s.getCenter().x(), s.getCenter().y(),
                s.getBorderColor().getRGB(), s.getInnerColor());

    }

    private void drawCircle(final int xc, final int yc, final int x, final int y, final Color c) {
        PixelColor.set(base, xc + x, yc + y, c.getRGB());
        PixelColor.set(base, xc - x, yc + y, c.getRGB());
        PixelColor.set(base, xc + x, yc - y, c.getRGB());
        PixelColor.set(base, xc - x, yc - y, c.getRGB());
        PixelColor.set(base, xc + y, yc + x, c.getRGB());
        PixelColor.set(base, xc - y, yc + x, c.getRGB());
        PixelColor.set(base, xc + y, yc - x, c.getRGB());
        PixelColor.set(base, xc - y, yc - x, c.getRGB());
    }

    public BufferedImage getImage() {
        return base;
    }
}
