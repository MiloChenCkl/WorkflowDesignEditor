package object;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class Oval extends AbstractShape {

    
    public Oval(int x, int y, int depth) {
        portArrayList = new ArrayList<Port>(4);
        super.createShape(x, y, 150, 100, depth, "Oval");
        initPort();
    }


    public void drawShape(Graphics2D g2d) {

        int x = getX();
        int y = getY();
        int w = getWidth();
        int h = getHeight();

        Ellipse2D ellipse = new Ellipse2D.Double(x, y, w, h);
        g2d.setColor(Color.GRAY);
        g2d.fill(ellipse);
        g2d.setColor(Color.BLACK);
        g2d.draw(ellipse);

        label.drawLabel(g2d, x, y, w, h);

        if (isSelected()) {
            for (Port port : portArrayList) {
                port.drawPort(g2d); 
            }
        }
    }

    private void initPort() {
        
        for(int i=0; i<4; i++){
            portArrayList.add(new Port(0, 0, this));
        }
    
        setPortPositions(getX(), getY());
    }
    
    public void setPortPositions(int x, int y) {
        int w = getWidth(), h = getHeight();
        int cx = x + w / 2;
        int cy = y + h / 2;
    
        portArrayList.get(0).setPosition(cx, y);         // top
        portArrayList.get(1).setPosition(cx, y + h);     // bottom
        portArrayList.get(2).setPosition(x, cy);         // left
        portArrayList.get(3).setPosition(x + w, cy);     // right
    }

}
