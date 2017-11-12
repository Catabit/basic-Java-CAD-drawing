package shapes;

public interface Visitor {
    void visit(Square s);
    void visit(Rectangle s);
    void visit(Canvas s);
    void visit(Diamond s);
}
