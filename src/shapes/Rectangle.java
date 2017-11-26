package shapes;

import utils.Point;

import java.awt.Color;

public final class Rectangle implements Shape {
    private Point start;
    private int length;
    private int height;
    private Color borderColor;
    private Color innerColor;


    public Rectangle(final Point inStart, final int inLength, final int inHeight,
                     final Color inBorder, final Color inInner) {
        start = inStart;
        length = inLength;
        height = inHeight;
        borderColor = inBorder;
        innerColor = inInner;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public Color getInnerColor() {
        return innerColor;
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    public Point getStart() {
        return start;
    }

    @Override
    public void accept(final Visitor v) {
        v.visit(this);
    }
}
