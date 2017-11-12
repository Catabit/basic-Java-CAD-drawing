package shapes;

import utils.Pixel;
import utils.Point;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.LinkedTransferQueue;

public final class ShapeFiller {
    private ShapeFiller() {
    }

    public static void fill(final BufferedImage base, final Rectangle r) {
        Point lt, rt, lb, rb;
        lt = r.getStart();
        rt = new Point(r.getStart().x() + r.getLength(), r.getStart().y());
        lb = new Point(r.getStart().x(), r.getStart().y() + r.getHeight());
        rb = new Point(r.getStart().x() + r.getLength(), r.getStart().y() + r.getHeight());

        for (int x = lt.x() + 1; x < rt.x(); x++) {
            for (int y = lt.y() + 1; y < lb.y(); y++) {
                Pixel.set(base, x, y, r.getInnerColor().getRGB());
            }
        }
    }


    public static void fill(final BufferedImage base, final Square s) {
        Point lt, rt, lb, rb;
        lt = s.getStart();
        rt = new Point(s.getStart().x() + s.getLength(), s.getStart().y());
        lb = new Point(s.getStart().x(), s.getStart().y() + s.getLength());
        rb = new Point(s.getStart().x() + s.getLength(), s.getStart().y() + s.getLength());

        for (int x = lt.x() + 1; x < rt.x(); x++) {
            for (int y = lt.y() + 1; y < lb.y(); y++) {
                Pixel.set(base, x, y, s.getInnerColor().getRGB());
            }
        }
    }

    public static void floodFill(final BufferedImage base, final int x, final int y,
                                 final int target, final Color replacement) {
        boolean[][] hits = new boolean[base.getHeight()][base.getWidth()];

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));

        while (!queue.isEmpty()) {
            Point p = queue.remove();

            if (floodFillImageDo(base, hits, p.x(), p.y(), target, replacement.getRGB())) {
                queue.add(new Point(p.x(), p.y() - 1));
                queue.add(new Point(p.x(), p.y() + 1));
                queue.add(new Point(p.x() - 1, p.y()));
                queue.add(new Point(p.x() + 1, p.y()));
            }
        }

    }

    private static boolean floodFillImageDo(final BufferedImage image, final boolean[][] hits,
                                            final int x, final int y,
                                            final int targetColor, final int replacementColor) {
        if (y < 0) {
            return false;
        }
        if (x < 0) {
            return false;
        }
        if (y > image.getHeight() - 1) {
            return false;
        }
        if (x > image.getWidth() - 1) {
            return false;
        }
        if (hits[y][x]) {
            return false;
        }
        if (image.getRGB(x, y) == targetColor) {
            return false;
        }
        // valid, set it
        Pixel.set(image, x, y, replacementColor);
        hits[y][x] = true;
        return true;
    }
}

