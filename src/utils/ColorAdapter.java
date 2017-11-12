package utils;

import java.awt.Color;

public final class ColorAdapter {

    private ColorAdapter() {
    }

    public static Color parseColor(final String input, final int alpha) {
        String out = input.substring(1);
        String val;
        val = out.substring(0, 2);
        int r = Integer.parseInt(val, 16);
        val = out.substring(2, 4);
        int g = Integer.parseInt(val, 16);
        val = out.substring(4, 6);
        int b = Integer.parseInt(val, 16);

        return new Color(r, g, b, alpha);
    }


}
