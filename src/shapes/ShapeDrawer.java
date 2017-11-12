package shapes;

public class ShapeDrawer implements Visitor {

    private Canvas base;

    //todo this will add the effective shapes to the final image
    @Override
    public final void visit(final Rectangle r) {
        System.out.println("Rectangle something");
    }

    @Override
    public final void visit(final Canvas s) {
        base = s;
        System.out.println(s.getSizeX() + " " + s.getSizeY() + " " + s.getBackground().toString());
    }
}
