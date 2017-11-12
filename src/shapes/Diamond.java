package shapes;

import utils.Point;

import java.awt.*;

public class Diamond implements Shape{
    private Point center;
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

    public final Point getCenter() {
        return center;
    }

    public Diamond(final Point inCenter, final int inLength, final int inHeight,
                     final Color inBorder, final Color inInner) {
        center = inCenter;
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
