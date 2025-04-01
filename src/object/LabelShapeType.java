package object;

public enum LabelShapeType {
    RECT, OVAL;

    @Override
    public String toString() {
        switch (this) {
            case RECT: return "Rect";
            case OVAL: return "Oval";
            default: return super.toString();
        }
    }

    public static LabelShapeType fromString(String shape) {
        switch (shape.toLowerCase()) {
            case "rect": return RECT;
            case "oval": return OVAL;
            default: return RECT; 
        }
    }
}