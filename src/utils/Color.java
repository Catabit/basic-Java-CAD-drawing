package utils;

public final class Color {
    private int r, g, b, a;


    public Color(final int r, final int g, final int b, final int a) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }

    public Color(final String input, final int alpha) {
        String out = input.substring(1);
        String val;
        val = out.substring(0, 2);
        this.r = Integer.parseInt(val, 16);
        val = out.substring(2, 4);
        this.g = Integer.parseInt(val, 16);
        val = out.substring(4, 6);
        this.b = Integer.parseInt(val, 16);
        this.a = alpha;
    }

    @Override
    public String toString() {
        return "[r" + r + ", g" + g + ", b" + b + ", a" + a + "]";
    }
}
