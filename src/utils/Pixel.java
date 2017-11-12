package utils;

import java.awt.image.BufferedImage;

public final class Pixel {

    private Pixel() {
    }

    public static void set(final BufferedImage base, final int x, final int y, final int argb) {
        if ((x >= 0 && x < base.getWidth()) && (y >= 0 && y < base.getHeight())) {
            base.setRGB(x, y, argb);
        }
        //todo return a bool to skip the line
    }
}
