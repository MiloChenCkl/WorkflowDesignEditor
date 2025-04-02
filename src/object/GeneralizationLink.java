package object;

import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Polygon;

public class GeneralizationLink extends AbstractLink {

    public GeneralizationLink(Port fromPort, Port toPort) {
        createLink(fromPort, toPort);
    }

    @Override
    public void drawLink(Graphics2D g2d) {
        Port from = getFromPort();
        Port to = getToPort();

        int x1 = from.getX();
        int y1 = from.getY();
        int x2 = to.getX();
        int y2 = to.getY();
        
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawLine(x1, y1, x2, y2);

        drawHollowTriangle(g2d, x1, y1, x2, y2);
    }

    private void drawHollowTriangle(Graphics2D g2d, int x1, int y1, int x2, int y2) {
        final int SIZE = 12;
        double angle = Math.atan2(y2 - y1, x2 - x1);

        int tipX = x2;
        int tipY = y2;

        int leftX = (int) (x2 - SIZE * Math.cos(angle - Math.PI / 6));
        int leftY = (int) (y2 - SIZE * Math.sin(angle - Math.PI / 6));

        int rightX = (int) (x2 - SIZE * Math.cos(angle + Math.PI / 6));
        int rightY = (int) (y2 - SIZE * Math.sin(angle + Math.PI / 6));

        Polygon triangle = new Polygon(
            new int[] {tipX, leftX, rightX},
            new int[] {tipY, leftY, rightY},
            3
        );

        g2d.setColor(Color.WHITE);
        g2d.fillPolygon(triangle);
        g2d.setColor(Color.BLACK);
        g2d.drawPolygon(triangle);
    }
}
