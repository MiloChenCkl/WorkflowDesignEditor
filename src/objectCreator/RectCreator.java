package objectCreator;

import object.AbstractShape;
import object.Rect;

public class RectCreator implements Tool {

    @Override
    public AbstractShape createShape(int x, int y, int depth) {
        return new Rect(x, y, depth);
    }

}
