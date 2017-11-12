package shapes;

public class Rectangle implements Shape {

    @Override
    public final void accept(final Visitor v) {
        v.visit(this);
    }
}
