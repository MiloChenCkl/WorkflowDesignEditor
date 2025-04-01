package object;

public class Port {
    private int posX, posY;
    private AbstractShape owner; 

    public Port(int posX, int posY, AbstractShape owner ){
        this.owner = owner;
        this.posX = posX;
        this.posY = posY;
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


}
