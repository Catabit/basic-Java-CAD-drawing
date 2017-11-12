package shapes;

import shapes.Rectangle;

public interface Visitor {
    void visit(Rectangle s);
    void visit(Canvas s);
}
