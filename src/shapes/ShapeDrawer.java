package shapes;

import utils.LineDrawer;
import utils.Point;

import java.awt.image.BufferedImage;

public class ShapeDrawer implements Visitor {

    private BufferedImage base;

    //todo this will add the effective shapes to the final image
    @Override
    public final void visit(final Square r) {
        System.out.println("Rectangle something");
        Point lt, rt, lb, rb;
        lt = r.getStart();
        rt = new Point(r.getStart().x(), r.getStart().y() + r.getLength());
        lb = new Point(r.getStart().x() + r.getLength(), r.getStart().y());
        rb = new Point(r.getStart().x() + r.getLength(), r.getStart().y() + r.getLength());

        LineDrawer.drawLine(base, lt, rt, r.getBorderColor());
        LineDrawer.drawLine(base, rt, rb, r.getBorderColor());
        LineDrawer.drawLine(base, lb, rb, r.getBorderColor());
        LineDrawer.drawLine(base, lb, lt, r.getBorderColor());

        LineDrawer.drawLine(base, lt.getOffset(1, 1), rb.getOffset(-1, -1), r.getInnerColor());
        LineDrawer.drawLine(base, rt.getOffset(1, -1), lb.getOffset(-1, 1), r.getInnerColor());
    }

    @Override
    public final void visit(final Canvas s) {
        base = new BufferedImage(s.getSizeY(), s.getSizeX(), BufferedImage.TYPE_INT_ARGB);
        for (int i = 0; i < s.getSizeX(); i++) {
            for (int j = 0; j < s.getSizeY(); j++) {
                base.setRGB(j, i, s.getBackground().getRGB());
            }
        }
        System.out.println(s.getSizeX() + " " + s.getSizeY() + " " + s.getBackground().toString());
    }

    public final BufferedImage getImage() {
        return base;
    }
}
