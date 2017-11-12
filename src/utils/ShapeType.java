package utils;

public enum ShapeType { //todo add all the possible shapes here
    CANVAS("CANVAS"),
    LINE("LINE"),
    SQUARE("SQUARE"),
    RECTANGLE("RECTANGLE"),
    DIAMOND("DIAMOND"),
    TRIANGLE("TRIANGLE"),
    CIRCLE("CIRCLE"),
    POLYGON("POLYGON");

    private final String name;

    ShapeType(final String name) {
        this.name = name;
    }

    public String text() {
        return name;
    }
}
