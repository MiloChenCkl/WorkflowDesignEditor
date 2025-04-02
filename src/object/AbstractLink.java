package object;

import java.awt.Graphics2D;

public abstract class AbstractLink {
    private Port fromPort;
    private Port toPort;

    protected void createLink(Port fromPort, Port toPort){
        this.fromPort = fromPort;
        this.toPort = toPort;
    }

    public Port getFromPort(){
        return this.fromPort;
    }    

    public void setFromPort(Port fromPort){
        this.fromPort = fromPort;
    }

    public Port getToPort(){
        return this.toPort;
    }

    public void setToPort(Port toPort){
        this.toPort = toPort;
    }
    
    public abstract void drawLink(Graphics2D g2d);
}
