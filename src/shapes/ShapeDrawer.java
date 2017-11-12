package shapes;

import utils.LineDrawer;
import utils.Point;

import java.awt.image.BufferedImage;

public final class ShapeDrawer implements Visitor {

    private BufferedImage base;

    //todo this will add the effective shapes to the final image
    @Override
    public void visit(final Square s) {
        //System.out.println("Rectangle something");
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
        //LineDrawer.drawLine(base, lt.getOffset(1, 1), rb.getOffset(-1, -1), s.getInnerColor());
        //LineDrawer.drawLine(base, rt.getOffset(-1, 1), lb.getOffset(1, -1), s.getInnerColor());
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
        //LineDrawer.drawLine(base, lt.getOffset(1, 1), rb.getOffset(-1, -1), r.getInnerColor());
        //LineDrawer.drawLine(base, rt.getOffset(-1, 1), lb.getOffset(1, -1), r.getInnerColor());
    }

    @Override
    public void visit(final Canvas s) {
        //System.out.println(s.getSizeX() + " " + s.getSizeY() + " " + s.getBackground().toString());
        base = new BufferedImage(s.getSizeX(), s.getSizeY(), BufferedImage.TYPE_INT_ARGB);
        for (int i = 0; i < s.getSizeX(); i++) {
            for (int j = 0; j < s.getSizeY(); j++) {
                base.setRGB(i, j, s.getBackground().getRGB());
            }
        }
    }

    @Override
    public void visit(final Diamond s) {
        Point t, r, l, b;
        t = s.getCenter().getOffset(0, s.getHeight() / 2);
        b = s.getCenter().getOffset(0, -s.getHeight() / 2);
        l = s.getCenter().getOffset(-s.getLength() / 2, 0);
        r = s.getCenter().getOffset(s.getLength() / 2, 0);

        LineDrawer.drawLine(base, t.getOffset(0, 1), b.getOffset(0, -1), s.getInnerColor());
        LineDrawer.drawLine(base, r.getOffset(1, 0), l.getOffset(-1, 0), s.getInnerColor());

        LineDrawer.drawLine(base, l, t, s.getBorderColor());
        LineDrawer.drawLine(base, t, r, s.getBorderColor());
        LineDrawer.drawLine(base, r, b, s.getBorderColor());
        LineDrawer.drawLine(base, b, l, s.getBorderColor());


    }

    @Override
    public void visit(final Line s) {
        LineDrawer.drawLine(base, s.getStart(), s.getEnd(), s.getBorderColor());
    }

    public BufferedImage getImage() {
        return base;
    }
}
