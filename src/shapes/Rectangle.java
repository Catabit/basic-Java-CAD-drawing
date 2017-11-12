package shapes;

import utils.Point;

import java.awt.Color;

public class Rectangle implements Shape {
    private Point start;
    private int length;
    private int height;
    private Color borderColor;
    private Color innerColor;

    public final Color getBorderColor() {
        return borderColor;
    }

    public final Color getInnerColor() {
        return innerColor;
    }

    public final int getLength() {
        return length;
    }

    public final int getHeight() {
        return height;
    }

    public final Point getStart() {
        return start;
    }

    public Rectangle(final Point inStart, final int inLength, final int inHeight,
                  final Color inBorder, final Color inInner) {
        start = inStart;
        length = inLength;
        height = inHeight;
        borderColor = inBorder;
        innerColor = inInner;
    }

    @Override
    public final void accept(final Visitor v) {
        v.visit(this);
    }
}
