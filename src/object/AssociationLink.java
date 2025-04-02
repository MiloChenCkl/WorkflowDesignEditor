package object;

import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Color;

public class AssociationLink extends AbstractLink {

    public AssociationLink(Port fromPort, Port toPort) {
        createLink(fromPort, toPort); 
    }

    @Override
    public void drawLink(Graphics2D g2d) {

        System.out.println("draw as link");

        Port from = getFromPort();
        Port to = getToPort();

        int x1 = from.getX();
        int y1 = from.getY();
        int x2 = to.getX();
        int y2 = to.getY();

        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawLine(x1, y1, x2, y2);

        drawArrowHead(g2d, x1, y1, x2, y2);
    }

    private void drawArrowHead(Graphics2D g2d, int x1, int y1, int x2, int y2) {
        final int ARROW_SIZE = 10;

        double dx = x2 - x1;
        double dy = y2 - y1;
        double angle = Math.atan2(dy, dx);

        int xArrow1 = (int) (x2 - ARROW_SIZE * Math.cos(angle - Math.PI / 6));
        int yArrow1 = (int) (y2 - ARROW_SIZE * Math.sin(angle - Math.PI / 6));

        int xArrow2 = (int) (x2 - ARROW_SIZE * Math.cos(angle + Math.PI / 6));
        int yArrow2 = (int) (y2 - ARROW_SIZE * Math.sin(angle + Math.PI / 6));

        int[] xPoints = {x2, xArrow1, xArrow2};
        int[] yPoints = {y2, yArrow1, yArrow2};

        g2d.fillPolygon(xPoints, yPoints, 3);
    }
}