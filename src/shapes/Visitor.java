package shapes;

public interface Visitor {
    void visit(Square s);
    void visit(Canvas s);
}
