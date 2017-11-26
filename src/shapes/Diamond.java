package shapes;

import utils.Point;

import java.awt.Color;

public final class Diamond implements Shape {
    private Point center;
    private int length;
    private int height;
    private Color borderColor;
    private Color innerColor;


    public Diamond(final Point inCenter, final int inLength, final int inHeight,
                   final Color inBorder, final Color inInner) {
        center = inCenter;
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

    public Point getCenter() {
        return center;
    }

    @Override
    public void accept(final Visitor v) {
        v.visit(this);
    }
}
