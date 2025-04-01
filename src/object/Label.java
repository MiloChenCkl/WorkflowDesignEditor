package object;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.Shape;

public class Label {

    protected String name = "Default";
    protected Color color = Color.white;
    protected int fontSize = 12;
    protected LabelShapeType shapeOfLabel = LabelShapeType.OVAL;

    public Label(String shapeOfLabel){
        this.shapeOfLabel = LabelShapeType.fromString(shapeOfLabel);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontsize(int fontSize) {
        this.fontSize = fontSize;
    }

    public LabelShapeType getShapeOfLabel() {
        return shapeOfLabel;
    }

    public void setShapeOfLabel(LabelShapeType shapeType) {
        this.shapeOfLabel = shapeType;
    }

    public void drawLabel(Graphics2D g2d, int x, int y, int w, int h) {
        g2d.setColor(getColor());

        Shape shape = null;
        int shrink = 50;
        double drawX = x + shrink / 2.0;
        double drawY = y + shrink / 2.0;
        double drawW = w - shrink;
        double drawH = h - shrink;

        switch (shapeOfLabel) {
            case OVAL:
                shape = new Ellipse2D.Double(drawX, drawY, drawW, drawH);
                break;
            case RECT:
            default:
                shape = new Rectangle2D.Double(drawX, drawY, drawW, drawH);
                break;
        }

        g2d.fill(shape);
        g2d.draw(shape);

        Font font = new Font("SansSerif", Font.BOLD, getFontSize());
        g2d.setFont(font);
        g2d.setColor(Color.BLACK);

        FontMetrics metrics = g2d.getFontMetrics(font);
        String labelText = getName();
        int textWidth = metrics.stringWidth(labelText);
        int textAscent = metrics.getAscent();

        int textX = x + (w - textWidth) / 2;
        int textY = y + (h + textAscent) / 2;

        g2d.drawString(labelText, textX, textY);

    }

}
