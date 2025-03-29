package gui;


import button.ButtonType;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

public class Canvas extends JPanel implements MouseListener, MouseMotionListener {

    private static Canvas instance;
    private int x, y;
    private static ButtonType selectedButton = null;


    private Canvas() {
        addMouseListener(this);
        addMouseMotionListener(this);
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

        selectedButton = ToolBar.getInstance().getSelectedButton();

        x = e.getX();
        y = e.getY();

        if (selectedButton == ButtonType.ORAL) {
            System.out.println("x"+ x + " y" + y);
            return;
        }
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {

    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {

    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {

    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {

    }

    @Override
    public void mouseDragged(java.awt.event.MouseEvent e) {

    }

    @Override
    public void mouseMoved(java.awt.event.MouseEvent e) {

    }


    
}


