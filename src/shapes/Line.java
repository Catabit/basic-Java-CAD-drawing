package shapes;

import utils.Point;

import java.awt.Color;

public final class Line implements Shape {

    private Point start;
    private Point end;
    private Color borderColor;

    public Line(final Point inStart, final Point inEnd, final Color inBorder) {
        start = inStart;
        end = inEnd;
        borderColor = inBorder;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public Point getEnd() {
        return end;
    }

    public Point getStart() {
        return start;
    }

    @Override
    public void accept(final Visitor v) {
        v.visit(this);
    }
}
