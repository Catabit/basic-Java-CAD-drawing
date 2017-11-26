package shapes;

public interface Visitor {
    void visit(Square s); //draw said shape
    void visit(Rectangle s);
    void visit(Canvas s);
    void visit(Diamond s);
    void visit(Line s);
    void visit(Triangle s);
    void visit(Polygon s);
    void visit(Circle s);
}
