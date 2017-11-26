package utils;

import java.awt.Color;
import java.awt.image.BufferedImage;


public final class LineDrawer {

    private LineDrawer() {
    }

    public static void drawLine(final BufferedImage base,
                                final Point start, final Point end, final Color color) {

        // initialize variables
        int x = start.x();
        int y = start.y();
        int deltaX = Math.abs(end.x() - start.x());
        int deltaY = Math.abs(end.y() - start.y());
        int s1 = sign(end.x() - start.x());
        int s2 = sign(end.y() - start.y());
        boolean interchanged;

        // interchange deltaX and deltaY, depending on the slope of the line
        if (deltaY > deltaX) {
            int aux = deltaY;
            deltaY = deltaX;
            deltaX = aux;
            interchanged = true;
        } else {
            interchanged = false;
        }
        // initialize the error term to compensate for a nonzero intercept
        int error = 2 * deltaY - deltaX;
        for (int i = 0; i <= deltaX; i++) {
            PixelColor.set(base, x, y, color.getRGB());
            //base.setRGB(x, y, color.getRGB());
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

    private static int sign(final int x) {
        if (x == 0) {
            return 0;
        } else if (x < 0) {
            return -1;
        } else {
            return 1;
        }
    }
}

