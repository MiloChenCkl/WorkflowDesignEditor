package objectCreator;

import object.AbstractLink;
import object.AbstractShape;
import object.Port;

public interface Tool {

    default AbstractShape createShape(int x, int y, int depth) {
        return null;
    }

    default AbstractLink createLink(Port start, Port end) {
        return null;
    }

    default boolean isLinkTool() {
        return false;
    }
}

