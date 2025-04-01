package object;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class Oval extends AbstractShape {
    
    public Oval(int x, int y, int depth) {
        super.createShape(x, y, 150, 100, depth, "Oval");
        portArrayList = new ArrayList<Port>(4);
        initPort(x, y);
    }

    public void initPort(int x, int y){
        
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
            drawConnectionPorts(g2d);
        }
    }

    protected void drawConnectionPorts(Graphics2D g2d) {
        int x = getX();
        int y = getY();
        int w = getWidth();
        int h = getHeight();
        int portSize = 10;
        int half = portSize / 2;
    
        int cx = x + w / 2;
        int cy = y + h / 2;
    
        int[][] points = {
            {cx, y - 4},        // top
            {cx, y + h + 4},    // bottom
            {x - 4, cy},        // left
            {x + w + 4, cy},    // right
        };
    
        g2d.setColor(Color.BLACK);
        for (int[] p : points) {
            g2d.fillRect(p[0] - half, p[1] - half, portSize, portSize);
        }
    }

}
