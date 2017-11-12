package utils;

public enum ShapeType { //todo add all the possible shapes here
    CANVAS("CANVAS"),
    SQUARE("SQUARE"),
    RECTANGLE("RECTANGLE"),
    DIAMOND("DIAMOND"),
    TRIANGLE("TRIANGLE"),
    CIRCLE("CIRCLE");

    private final String name;

    ShapeType(final String name) {
        this.name = name;
    }

    public String text() {
        return name;
    }
}
