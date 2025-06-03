package objectCreator;

import object.AbstractLink;
import object.GeneralizationLink;
import object.Port;

public class GeneralLinkCreator implements Tool {

    @Override
    public AbstractLink createLink(Port fromPort, Port toPort) {
        return new GeneralizationLink(fromPort, toPort);
    }
    
}