package shapes;

import utils.Point;

import java.awt.Color;

public class Square implements Shape {
    private Point start;
    private int length;
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

    public final Point getStart() {
        return start;
    }

    public Square(final Point inStart, final int inLength,
                  final Color inBorder, final Color inInner) {
        start = inStart;
        length = inLength;
        borderColor = inBorder;
        innerColor = inInner;
    }

    @Override
    public final void accept(final Visitor v) {
        v.visit(this);
    }
}
