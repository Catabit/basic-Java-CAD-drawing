package shapes;

import utils.Point;

import java.awt.Color;

public final class Triangle implements Shape {

    private Point p1;
    private Point p2;
    private Point p3;
    private Color borderColor;
    private Color innerColor;

    public Triangle(final Point p1, final Point p2, final Point p3,
                    final Color borderColor, final Color innerColor) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.borderColor = borderColor;
        this.innerColor = innerColor;
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public Point getP3() {
        return p3;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public Color getInnerColor() {
        return innerColor;
    }

    @Override
    public final void accept(final Visitor v) {
        v.visit(this);
    }
}
