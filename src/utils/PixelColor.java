package utils;

import java.awt.image.BufferedImage;

public final class PixelColor {

    private PixelColor() {
    }

    /**
     * Used to ease the flow of setting pixel values.
     * @param base image raster
     * @param x x coord
     * @param y y coord
     * @param argb the color in 32 bit int form
     */
    public static void set(final BufferedImage base, final int x, final int y, final int argb) {
        if ((x >= 0 && x < base.getWidth()) && (y >= 0 && y < base.getHeight())) {
            base.setRGB(x, y, argb);
        }
    }
}
