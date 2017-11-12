package utils;

import java.awt.Color;

public final class ColorAdapter {

    private ColorAdapter() {
    }

    public static Color parseColor(final String input, final int alpha) {
        final int hexRadix = 16;
        String out = input.substring(1);
        String val;
        val = out.substring(0, 2);
        int r = Integer.parseInt(val, hexRadix);
        val = out.substring(2, 4);
        int g = Integer.parseInt(val, hexRadix);
        val = out.substring(4, 6);
        int b = Integer.parseInt(val, hexRadix);

        return new Color(r, g, b, alpha);
    }


}
