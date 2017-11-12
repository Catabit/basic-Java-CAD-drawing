package utils;

import java.awt.image.BufferedImage;

public final class Point {
    private int x;
    private int y;
    private int colorRGB;

    public Point(final int inX, final int inY) {
        x = inX;
        y = inY;
    }

    private Point(final int inX, final int inY, final int inRGB) {
        this(inX, inY);
        this.colorRGB = inRGB;
    }

    public int getColorRGB() {
        return colorRGB;
    }

    public void setColorRGB(final int color) {
        this.colorRGB = color;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public Point getOffset(final int offX, final int offY) {
        return new Point(x + offX, y + offY);
    }

    public Point getOffset(final int offX, final int offY, final BufferedImage base) {
        return new Point(x + offX, y + offY, base.getRGB(x + offX, y + offY));
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}
