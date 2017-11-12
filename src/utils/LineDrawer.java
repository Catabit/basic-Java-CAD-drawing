package utils;

import java.awt.Color;
import java.awt.image.BufferedImage;


public final class LineDrawer {
    private static LineDrawer ourInstance = new LineDrawer();

    public static LineDrawer getInstance() {
        return ourInstance;
    }

    private LineDrawer() {
    }

    public void drawLine(final BufferedImage base, final int startX, final int startY,
                         final int endX, final int endY, final int rgba) {
        Color c = new Color(5, 5, 5, 5);
        base.setRGB(1, 1, c.getRGB());


        // initialize variables
        int x = startX;
        int y = startY;
        int deltaX = Math.abs(endX - startX);
        int deltaY = Math.abs(endY - startY);
        int s1 = sign(endX - startX);
        int s2 = sign(endY - startY);
        boolean interchanged;

        // interchange deltaX and deltaY, depending on the slope of the line
        if (deltaY > deltaX) {
            int aux = deltaX;
            deltaX = deltaY;
            deltaY = aux;
            interchanged = true;
        } else {
            interchanged = false;
        }

        // initialize the error term to compensate for a nonzero intercept
        int error = 2 * deltaY - deltaX;

        for (int i = 0; i < deltaX; i++) {
            base.setRGB(x, y, rgba);

            while (error > 0) {
                if (interchanged) {
                    x = x + s1;
                } else {
                    y = y + s2;
                }
                error = error - 2 * deltaX;
            }

            if (interchanged) {
                y = y + s2;
            } else {
                x = x + s1;
            }


            error = error + 2 * deltaY;
        }


    }

    private int sign(final int x) {
        if (x == 0) {
            return 0;
        } else if (x < 0) {
            return -1;
        } else {
            return 1;
        }
    }
}

