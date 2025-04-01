package object;

import java.awt.Graphics2D;
import java.util.ArrayList;

public abstract class AbstractShape {

    protected ArrayList<Port> portArrayList;
    private int x, y;
    private int width, height;
    private int depth;
    private Boolean selected = false;
    protected Label label;
    
    protected void createShape(int x, int y, int width, int height, int depth, String shapeOfLabel){
        setPosition(x, y);
        setSize(width, height);
        setDepth(depth);
        label = new Label(shapeOfLabel);
    }

    public boolean isInShape(int mouseX, int mouseY){
        return mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height;
    }
    

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;     
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }   

    public void setSize(int width, int height){
        this.width = width;
        this.height = height;     
    }
    
    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public void setDepth(int depth){
        this.depth = depth;
    }

    public int getDepth(){
        return depth;
    }


    public void setSelected(Boolean selected){
        this.selected = selected;
    }

    public Boolean isSelected(){
        return selected;
    }

    public Label getLabel(){
        return label;
    }

    public abstract void drawShape(Graphics2D g2d); 

}
