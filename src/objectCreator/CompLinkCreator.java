package objectCreator;

import object.AbstractLink;
import object.CompositionLink;
import object.Port;

public class CompLinkCreator implements Tool {

    @Override
    public AbstractLink createLink(Port fromPort, Port toPort) {
        return new CompositionLink(fromPort, toPort);
    }
    
}