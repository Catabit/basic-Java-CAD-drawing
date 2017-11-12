import shapes.*;
import utils.ShapeType;

public abstract class Main {

    public static void main(final String[] args) {


        Visitor v = new ShapeDrawer();
        Shape s = ShapeBuilder.getInstance().buildShape("CANVAS 100 200 #FFAA0F 99");

        s.accept(v);

    }
}
