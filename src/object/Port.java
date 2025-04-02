package object;

import java.awt.Graphics2D;
import java.awt.Color;
import java.util.ArrayList;

public class Port {
    private int posX, posY;
    private AbstractShape owner;
    private ArrayList<AbstractLink> connectedLinks = new ArrayList<>();

    public static final int SIZE = 8; 

    public Port(int posX, int posY, AbstractShape owner){
        this.owner = owner;
        this.posX = posX;
        this.posY = posY;
    }

    public void setPosition(int x, int y){
        this.posX = x;
        this.posY = y;
    }

    public int getX(){
        return posX;
    }

    public int getY(){
        return posY;
    }

    public AbstractShape getOwner(){
        return owner;
    }

    public void addLink(AbstractLink link) {
        connectedLinks.add(link);
    }

    public void removeLink(AbstractLink link) {
        connectedLinks.remove(link);
    }

    public ArrayList<AbstractLink> getConnectedLinks() {
        return connectedLinks;
    }

    public void drawPort(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        g2d.fillRect(posX - SIZE/2, posY - SIZE/2, SIZE, SIZE);
    }

}
