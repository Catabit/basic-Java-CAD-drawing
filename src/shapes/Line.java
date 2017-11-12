package shapes;

import utils.Point;

import java.awt.Color;

public class Line implements Shape {

    private Point start;
    private Point end;
    private Color borderColor;

    public Line(final Point inStart, final Point inEnd, final Color inBorder) {
        start = inStart;
        end = inEnd;
        borderColor = inBorder;
    }

    public final Color getBorderColor() {
        return borderColor;
    }

    public final Point getEnd() {
        return end;
    }

    public final Point getStart() {
        return start;
    }

    @Override
    public final void accept(final Visitor v) {
        v.visit(this);
    }
}
