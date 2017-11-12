package utils;

public enum ShapeType { //todo add all the possible shapes here
    CANVAS("CANVAS"),
    RECTANGLE("RECTANGLE"),
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
