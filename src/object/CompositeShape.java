package object;

import java.awt.Graphics2D;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class CompositeShape extends AbstractShape {

    private List<AbstractShape> children;

    public CompositeShape(List<AbstractShape> selectedShapes) {
        this.children = new ArrayList<>(selectedShapes);

        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;

        for (AbstractShape shape : children) {
            minX = Math.min(minX, shape.getX());
            minY = Math.min(minY, shape.getY());
            maxX = Math.max(maxX, shape.getX() + shape.getWidth());
            maxY = Math.max(maxY, shape.getY() + shape.getHeight());
        }

        super.setPosition(minX, minY);
        super.setSize(maxX - minX, maxY - minY);
    }

    @Override
    public void drawShape(Graphics2D g2d) {
        for (AbstractShape child : children) {
            child.drawShape(g2d);
        }

        if (isSelected()) {
            int boundary = 10;
            g2d.setColor(Color.BLACK);
            g2d.drawRect(getX()-boundary, getY()-boundary, getWidth()+2*boundary, getHeight()+2*boundary); 
        }
    }

    @Override
    public boolean isInShape(int mouseX, int mouseY) {
        for (AbstractShape shape : children) {
            if (shape.isInShape(mouseX, mouseY)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void setSelected(Boolean selected) {
        super.setSelected(selected);
        for (AbstractShape shape : children) {
            shape.setSelected(selected);
        }
    }

    @Override
    public void setPosition(int x, int y) {
        int dx = x - getX();
        int dy = y - getY();
        super.setPosition(x, y);

        for (AbstractShape shape : children) {
            shape.setPosition(shape.getX() + dx, shape.getY() + dy);
        }
    }

    public List<AbstractShape> ungroup() {
        return new ArrayList<>(children);
    }

}