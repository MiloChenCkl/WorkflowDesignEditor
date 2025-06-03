package gui;

import object.AbstractShape;
import object.AbstractLink;
import objectCreator.Tool;
import object.Port;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;

public class Canvas extends JPanel implements MouseListener, MouseMotionListener {

    private static Canvas instance;
    private int mouseX, mouseY;
    private int dragEndX, dragEndY;
    private boolean isDragging = false;
    private boolean selected = false;
    private Port startPort;
    private Port endPort;

    private int depth = 0;
    private Tool creator = null;
    private ArrayList<AbstractShape> shapeArrayList;
    private ArrayList<AbstractLink> linkArrayList;

    private Canvas() {
        addMouseListener(this);
        addMouseMotionListener(this);
        shapeArrayList = new ArrayList<AbstractShape>();
        linkArrayList = new ArrayList<AbstractLink>();
    }

    public static Canvas getInstance() {
        synchronized (Canvas.class) {
            if (instance == null) {
                instance = new Canvas();
            }
        }
        return instance;
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {

        mouseX = e.getX();
        mouseY = e.getY();

        if(creator != null) {
            AbstractShape shape = creator.createShape(mouseX, mouseY, depth++);
            if (shape != null) {
                shapeArrayList.add(shape);
                repaint();
            }
            return;
        }

    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {

        isDragging = false;
        mouseX = e.getX();  
        mouseY = e.getY();
        selected = false;
        clearSelection();

        for (int i = shapeArrayList.size() - 1; i >= 0; i--) {

            AbstractShape shape = shapeArrayList.get(i);

            if (shape.isInShape(mouseX, mouseY)) {

                if (isSelectMode()) {
                    shape.setSelected(true);
                    selected = true;
                }

                startPort = shape.getClosestPort(mouseX, mouseY);

                break;
            }
        }

        System.out.println("mousePressed: " + mouseX + ", " + mouseY);
        repaint();

    }


    @Override
    public void mouseDragged(java.awt.event.MouseEvent e) {

        isDragging = true;
        dragEndX = e.getX();
        dragEndY = e.getY();

        if(selected){
            dragObject(mouseX, mouseY, dragEndX, dragEndY);
            mouseX = e.getX();
            mouseY = e.getY();
        }
        
    }

    public void dragObject(int x, int y, int endX, int endY) {

        int dx = endX - x;
        int dy = endY - y;

        if (isSelectMode()) {
            for (AbstractShape shape : shapeArrayList) {
                if (shape.isSelected()) {
                    shape.setPosition(shape.getX() + dx, shape.getY() + dy);
                    shape.setPortPositions(shape.getX(), shape.getY());
                }
            }
        }

        repaint();
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {

        if (isSelectMode()) {
            if (!selected && isDragging) {
                isDragging = false;
                selectInRectangle(mouseX, mouseY, dragEndX, dragEndY);
            }
            else if (!selected && !isDragging){
                clearSelection();
            }
        }


        if (isDragging == false) return; 

        endPort = null;
        for (int i = shapeArrayList.size() - 1; i >= 0; i--) {
            AbstractShape shape = shapeArrayList.get(i);
            if (shape.isInShape(dragEndX, dragEndY)) {
                endPort = shape.getClosestPort(dragEndX, dragEndY);
                break;
            }
        }

        if (startPort == null || endPort == null || startPort.getOwner() == endPort.getOwner()) {
            startPort = null;
            return;
        }


        if (creator != null){
            AbstractLink link = creator.createLink(startPort, endPort);
            if (link != null) {
                linkArrayList.add(link);
                startPort.addLink(link);  
                endPort.addLink(link);
            }
        }
            
        startPort = null;
        endPort = null;

        repaint();

    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {

    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {

    }

    @Override
    public void mouseMoved(java.awt.event.MouseEvent e) {

    }

    public List<AbstractShape> getSelectedShapes() {
        List<AbstractShape> selected = new ArrayList<>();
        for (AbstractShape shape : shapeArrayList) {
            System.out.println("Checking shape: " + shape + " at (" + shape.getX() + ", " + shape.getY() + "), selected: " + shape.isSelected());
            if (shape.isSelected()) {
                selected.add(shape);
            }
        }
        return selected;
    }

    private void selectInRectangle(int x, int y, int endX, int endY) {
        int left = Math.min(x, endX);
        int top = Math.min(y, endY);
        int right = Math.max(x, endX);
        int bottom = Math.max(y, endY);

        for (AbstractShape shape : shapeArrayList) {
            int sx = shape.getX();
            int sy = shape.getY();
            int sw = shape.getWidth();
            int sh = shape.getHeight();
    
            boolean isInside = sx >= left && sy >= top && (sx + sw) <= right && (sy + sh) <= bottom;
            shape.setSelected(isInside); 
        }

        repaint();
    }

    public void removeShape(AbstractShape shape) {
        shapeArrayList.remove(shape);
    }
    
    public void removeShapes(List<AbstractShape> shapeList) {
        shapeArrayList.removeAll(shapeList);
    }
    
    public void addShape(AbstractShape shape) {
        shapeArrayList.add(shape);
    }
    
    public void addShapes(List<AbstractShape> shapeList) {
        shapeArrayList.addAll(shapeList);
    }
    
    public void clearSelection() {
        for (AbstractShape shape : shapeArrayList) {
            shape.setSelected(false);
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.clearRect(0, 0, getWidth(), getHeight());
        Graphics2D g2d = (Graphics2D) g;

        for (AbstractShape shape : shapeArrayList) {
            shape.drawShape(g2d);
        }

        for (AbstractLink link : linkArrayList) {
            link.drawLink(g2d);
        }
    
    }

    public void setCreator(Tool creator) {
        this.creator = creator;
    }

    public Tool getCreator() {
        return creator;
    }

    public boolean isSelectMode(){
        return this.creator == null;
    }
}


