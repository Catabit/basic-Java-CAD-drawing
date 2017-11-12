package shapes;

import utils.Point;

import java.awt.Color;

public final class Circle implements Shape {
    private Point center;
    private int radius;
    private Color borderColor;
    private Color innerColor;

    public Circle(final Point center, final int radius,
                  final Color borderColor, final Color innerColor) {
        this.center = center;
        this.radius = radius;
        this.borderColor = borderColor;
        this.innerColor = innerColor;
    }

    public Point getCenter() {
        return center;
    }

    public int getRadius() {
        return radius;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public Color getInnerColor() {
        return innerColor;
    }

    @Override
    public void accept(final Visitor v) {
        v.visit(this);
    }
}
