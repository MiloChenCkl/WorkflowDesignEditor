package objectCreator;

import object.AbstractLink;
import object.AssociationLink;
import object.Port;

public class AssocLinkCreator implements Tool {

    @Override
    public AbstractLink createLink(Port fromPort, Port toPort) {
        return new AssociationLink(fromPort, toPort);
    }
    
}