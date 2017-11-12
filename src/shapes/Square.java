package shapes;

import utils.Point;

import java.awt.Color;

public final class Square implements Shape {
    private Point start;
    private int length;
    private Color borderColor;
    private Color innerColor;

    public  Color getBorderColor() {
        return borderColor;
    }

    public  Color getInnerColor() {
        return innerColor;
    }

    public  int getLength() {
        return length;
    }

    public  Point getStart() {
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
    public  void accept(final Visitor v) {
        v.visit(this);
    }
}
