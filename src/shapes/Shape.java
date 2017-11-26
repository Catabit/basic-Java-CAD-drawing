package shapes;

public interface Shape {
    void accept(Visitor v); //be drawn by the visitor
}
