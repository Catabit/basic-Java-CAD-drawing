package utils;

public final class Point {
    private int x;
    private int y;

    public Point(final int inX, final int inY) {
        x = inX;
        y = inY;
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
}
