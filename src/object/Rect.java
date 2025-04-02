package object;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Rect extends AbstractShape {

    
    public Rect(int x, int y, int depth) {
        portArrayList = new ArrayList<Port>(8);
        super.createShape(x, y, 150, 100, depth, "Oval");
        initPort();
    }


    public void drawShape(Graphics2D g2d) {

        int x = getX();
        int y = getY();
        int w = getWidth();
        int h = getHeight();

        Rectangle2D rect = new Rectangle2D.Double(x, y, w, h);
        g2d.setColor(Color.GRAY);
        g2d.fill(rect);
        g2d.setColor(Color.BLACK);
        g2d.draw(rect);

        label.drawLabel(g2d, x, y, w, h);

        if (isSelected()) {
            for (Port port : portArrayList) {
                port.drawPort(g2d); 
            }
        }
    }

    private void initPort() {

        for(int i=0; i<8; i++){
            portArrayList.add(new Port(0, 0, this));
        }
    
        setPortPositions(getX(), getY());
    }
    
    public void setPortPositions(int x, int y) {
        int w = getWidth(), h = getHeight();
        int cx = x + w / 2;
        int cy = y + h / 2;
    
        portArrayList.get(0).setPosition(x, y);             //  0  1  2
        portArrayList.get(1).setPosition(cx, y);            //  3     4
        portArrayList.get(2).setPosition(x + w, y);         //  5  6  7
        portArrayList.get(3).setPosition(x, cy);
        portArrayList.get(4).setPosition(x + w, cy);
        portArrayList.get(5).setPosition(x, y + h);  
        portArrayList.get(6).setPosition(cx, y + h);
        portArrayList.get(7).setPosition(x + w, y + h);
    }

}