package objectCreator;

import object.AbstractShape;
import object.Oval;

public class OvalCreator implements Tool {

    @Override
    public AbstractShape createShape(int x, int y, int depth) {
        return new Oval(x, y, depth);
    }
    
}
