package object;

import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Polygon;

public class CompositionLink extends AbstractLink {

    public CompositionLink(Port fromPort, Port toPort) {
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
        
        int[] adjustedEnd = getLineEndBeforeDiamond(x1, y1, x2, y2, 14);
        int ax = adjustedEnd[0];
        int ay = adjustedEnd[1];

        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawLine(x1, y1, ax, ay);

        drawHollowDiamond(g2d, x2, y2, x1, y1);
    }

    private int[] getLineEndBeforeDiamond(int x1, int y1, int x2, int y2, int offset) {
        double angle = Math.atan2(y2 - y1, x2 - x1);
        int newX = (int)(x2 - offset * Math.cos(angle));
        int newY = (int)(y2 - offset * Math.sin(angle));
        return new int[]{newX, newY};
    }

    private void drawHollowDiamond(Graphics2D g2d, int xTip, int yTip, int xFrom, int yFrom) {
        final int SIZE = 12;
        double angle = Math.atan2(yTip - yFrom, xTip - xFrom);

        int cx = xTip;

        int frontX = (int) (cx);
        int frontY = (int) (yTip);

        int backX = (int) (cx - SIZE * Math.cos(angle));
        int backY = (int) (yTip - SIZE * Math.sin(angle));

        int leftX = (int) (cx - SIZE / 2.0 * Math.cos(angle) + SIZE / 2.0 * Math.sin(angle));
        int leftY = (int) (yTip - SIZE / 2.0 * Math.sin(angle) - SIZE / 2.0 * Math.cos(angle));

        int rightX = (int) (cx - SIZE / 2.0 * Math.cos(angle) - SIZE / 2.0 * Math.sin(angle));
        int rightY = (int) (yTip - SIZE / 2.0 * Math.sin(angle) + SIZE / 2.0 * Math.cos(angle));

        Polygon diamond = new Polygon(
            new int[]{frontX, leftX, backX, rightX},
            new int[]{frontY, leftY, backY, rightY},
            4
        );

        g2d.setColor(Color.WHITE);   // 填白色
        g2d.fillPolygon(diamond);
        g2d.setColor(Color.BLACK);  // 外框黑色
        g2d.drawPolygon(diamond);
    }
}

