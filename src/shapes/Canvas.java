package shapes;

import utils.Color;

public final class Canvas implements Shape {
    private int sizeX, sizeY;
    private Color background;

    public Canvas(final int sizeX, final int sizeY, final Color background) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.background = background;
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public Color getBackground() {
        return background;
    }


    @Override
    public void accept(final Visitor v) {
        v.visit(this);
    }
}
