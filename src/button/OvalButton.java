package button;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import gui.Canvas;
import gui.ToolBar;
import objectCreator.OvalCreator;
public class OvalButton extends AbstractButtons implements ActionListener { 

    public OvalButton() {
        super("Oval");
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        ToolBar toolBar = ToolBar.getInstance();
        toolBar.setButtonsColor();

        Canvas canvas = Canvas.getInstance();
        canvas.setCreator(new OvalCreator());

        setBackground(Color.GRAY);
        System.out.println("Oval button clicked");
    }

}
