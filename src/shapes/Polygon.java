package shapes;

import utils.Point;

import java.awt.Color;
import java.util.ArrayList;

public final class Polygon implements Shape {
    private ArrayList<Point> points;
    private int numPoints;
    private Color borderColor;
    private Color innerColor;

    public Polygon(final int inNum, final ArrayList<Point> inPoints,
                   final Color inBorder, final Color inInner) {
        numPoints = inNum;
        points = inPoints;
        borderColor = inBorder;
        innerColor = inInner;
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public int getNumPoints() {
        return numPoints;
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
